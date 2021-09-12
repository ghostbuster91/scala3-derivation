package com.example

enum Opt[+T]:
  case Sm(t: T)
  case Nn

object Opt:
  given nnEq : Eq[Nn.type] = new Eq[Nn.type] {
    override def eqv(x: Nn.type, y: Nn.type): Boolean = true
  }
  given smEq[T: Eq] : Eq[Sm[T]]  = Eq.derived[Sm[T]]
  given eqInstance[T: Eq]: Eq[Opt[T]] = Eq.derived[Opt[T]]

// Option[Dog] < Option[Animal]

@main def test(): Unit =
  import Opt.*
  val eqoi = summon[Eq[Opt[Int]]]
  assert(eqoi.eqv(Sm(23), Sm(23)))
  assert(!eqoi.eqv(Sm(23), Sm(13)))
  assert(!eqoi.eqv(Sm(23), Nn))
  println("qqqq")