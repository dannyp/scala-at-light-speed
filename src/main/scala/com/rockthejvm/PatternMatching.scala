package com.rockthejvm

object PatternMatching extends App {

  // switch expression
  val anInteger = 55

  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }

  // PM is an EXPRESSION

  // Case class decomposition
  case class Person(name:String, age:Int)
  val bob = Person("Bob", 43) // Person.apply("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
    case _ => "Something else"
  }

  // Deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "GTFO"
  }

  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List contining 2 on it's second position"
    case _ => "unknown list"
  }
  println(listDescription)
  // If PM doesn't match anything it will throw a MatchError
  // PM Fill try all cases in sequence

}
