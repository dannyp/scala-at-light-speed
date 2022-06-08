package com.rockthejvm

object Basics extends App {
  val meaningOfLife: Int = 42 // const int meaningOfLife = 42

  // Int Boolean Char Double Float String
  val aBoolean = false  // type is optional

  // Strings and string operations
  val aString = "I Love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val aInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expressions = structures that can be reduced to a value.
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if(meaningOfLife > 43) 56 else 999 // (meaningOfLife ? 43) ? 56 : 999
  val chainedIfExpression = {
    if(meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if(meaningOfLife > 999)78
    else 0
  }

  // code-block
  val aCodeBlock = {
    // definitions
    val aLocalValue = 57
    // Value of code block is value of the last expression.
    aLocalValue + 3
  }

  // define a function
  def myFunction(x:Int, y:Int): String = {
    y + " " + x
  }

  // recursive functions
  def factorial(n:Int): Int = {
    if (n <= 1 ) 1
    else n * factorial(n -1 )
  }

  // In scala we don't use loops for iteration. We use RECURSION.


  // the Unit type = no meaningful value === "void" in other langurages
  // implies SIDE EFFECTS
  println(("I don't love returning usin"))

  val theUnit = ()
}
