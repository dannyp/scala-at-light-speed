package com.rockthejvm

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}
import scala.concurrent.ExecutionContext.Implicits.global

object Advanced extends App {
  /**
   * lazy evaluation
    */

  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1

  // useful in infinite collections

  /**
   "pseudo-collections"; Option, Try
   */
  def methodWhichCanReturnNull(): String = "hello, Scala"
  if (methodWhichCanReturnNull() == null) {
    //defensive code against null
  }

  val anOption = Option(methodWhichCanReturnNull()) // Some("hello, Scala")
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string $string"
    case None => "I have obtained nothing"
  }
  // map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException()
  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Failure(exception) => s"I have obtained an exception $exception"
    case Success(value) => s"I have obtained a valid string $value"
  }
  // map, flatMap, filter.

  /**
   * Evaluate something on another thread
   * (async processing)
   */
  val aFuture = Future {
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    67
  }
  // future is a "collection" which contains a value when it's evaluated
  // future is composable with map, flapMap and filter
  // monads

  /**
   * Implicits basics
   */
  // #1 implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs)

  // #2 implicit conversions
  implicit class MyRichInteger(n:Int) {
    def isEven() = n % 2 == 0
  }
  println(23.isEven()) // new MyRichInteger(23).isEven
  // use carefully!
}
