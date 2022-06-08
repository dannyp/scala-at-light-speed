package com.rockthejvm

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name:String) {
    def apply(age:Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob(43) // INVOKING bob as  a function === bob.apply(43)

  /*
    Scala runs on the JVM.
    Functional programming:
    - compose functions
    - pass functions as arguments
    - return functions as results

    Conclusion: FunctionX = Function1, Function2, ... FunctionN (N = 22)
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 + 1
  }
  simpleIncrementer.apply(23) // 24
  simpleIncrementer(23) // simpleIncrementer.apply(23)
  // defined a function! (even though it's an object)

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  // function with 2 arguments and a String return type
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  stringConcatenator("I love", " Scala")

  // syntactic sugars
  val doubler = (x:Int) => 2 * x;
  doubler(4)

  // higher-order functions: take functions as arguments / return functions as resuts.
  val aMappedList = List(1, 2, 3).map(x => x * 2) // HOF
  val aFlatMappedList = List(1,2,3).flatMap(x => List(x, 2*x))
  val aFilteredList = List(1,2,3,4,5).filter(_ <= 3)

  // all bairs between 1,2,3, and the letters a b c
  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))

  // for comprehensions
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  // equivalent to the map/flatMap chain above

  /**
   * Collections
   */

  // lists
  val aList = List(1,2,3,4,5,5)
  val firstElement = aList.head
  val rest = aList.tail
  val aPrependedList = 0 :: aList // List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 // List(0,1,2,3,4,5,6)

  // sequences
  val aSequence: Seq[Int] = Seq(1,2,3)
  val accessedElement = aSequence(1) // 2 (the element at index 1)

  // vectors: fast Seq impl
  val aVector = Vector(1,2,3,4,5)

  // sets = no duplicates
  val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5 // Set(1,2,3,4,5)
  val aRemovedSet = aSet - 3 // Set(1,2,4)

  // ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(2 * _).toList //List(2,4,6,8, 2000)

  // tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // maps
  val aPhonebook: Map[String, Int] = Map(
    ("Daniel", 654987),
    "Jane" -> 4564123 // ("Jane", 4564123)
  )
}

