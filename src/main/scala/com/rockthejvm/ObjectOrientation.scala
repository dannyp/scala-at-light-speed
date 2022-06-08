package com.rockthejvm

object ObjectOrientation extends App {

  // java equivalent: public static void main(String[] args)

  // class and instance
  class Animal {
    // define fields
    val age:Int = 0
    def eat(): Unit = println("I'm eating")
  }
  val anAnimal = new Animal

  // inheritance
  class Dog(val name:String) extends Animal  // constructor definition
  val aDog = new Dog("Lassie")

  // constructor arguments are not fields. Need to put a val before the constructor argument
  aDog.name

  //subtype polymorphism

  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default public, can restrict by using private, protected
    def walk(): Unit
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal:Animal): Unit
  }

  trait Philosopher {
    def ?!(thought:String):Unit // valid method name
  }

  // single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println(s"I am eating you, animal")

    override def ?!(thought:  _root_.scala.Predef.String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = {object} {method} {argument}, // only available for methods with ONE argument
  aCroc ?! "What if we could fly?"

  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous classes

  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I'am a dinosaur so I can each pretty much anything.")
  }

  /*
  * class Carninvore_Anonymous_37456 extends Carnivore
  class Carnivore {
    override def eat(animal: Animal): Unit = println("I'am a dinosaur so I can each pretty much anything.")
    }
    val dinosaur = new  Carninvore_Anonymous_37456
  */

  // singleton object
  object MySingleton {
    val mySpecialValue = 53278
    def mySpecialMethod(): Int = 53278
    def apply(x: Int) : Int = x + 1
  }
  MySingleton.mySpecialMethod()
  MySingleton.apply(55)
  MySingleton(65) // equivalent to MySingleton.apply(55)


  object Animal { // companions - companion object
    // companions can access each other's private fields / methods.
    // the singleton Animal and instances of Animal are different things.
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/method

  /*
   case classes = lightweight data structures with some boilerplate
   - sensible equals and hash code
   - serialisation
   - companion with apply
   - pattern matching
   */

  case class Person(name:String, age: Int)

  // may be ocnstucted without the keyword "new"
  val bob = Person("bob", 54) // Person.apply("Bob", 54)

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch {
    case e: Exception => "Some faulty error message"
  } finally {
    // execute some code no matter what
  }

  // generics
  abstract class MyList[T] {
    def head: T
    def tail: MyList[T]
  }

  val aList: List[Int] = List(1,2,3) // List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail
  val aStringList = List("hello", "scala")

  val firstString = aStringList.head  // "hello":String
  val restString =  aStringList.tail // list of String

  // Point #1: in Scala we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object.
  /*
    Benefits:
    1) works miracles in multithreaded/distributed env
    2) helps making sense of the code ("reasoning about")
   */

  // Point #2: Scala is closest to the OO ideal
  val reversedList = aList.reverse // returns a NEW list

}

