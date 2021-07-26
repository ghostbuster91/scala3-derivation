package com.example

enum Opt[+T] derives Eq:
  case Sm(t: T)
  case Nn

@main def test(): Unit =
  import Opt.*
  val eqoi = summon[Eq[Opt[Int]]]
  assert(eqoi.eqv(Sm(23), Sm(23)))
  assert(!eqoi.eqv(Sm(23), Sm(13)))
  assert(!eqoi.eqv(Sm(23), Nn))
  println("qqqq")