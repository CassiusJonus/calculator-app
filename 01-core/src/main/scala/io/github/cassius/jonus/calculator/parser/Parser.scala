package io.github.cassius.jonus.calculator
package parser

import expression.MathExpr
import zio.*
/*
Defines the behavior of the parser that will be used to parse Mathematical
Expressions and commands input by the user.
 */
trait Parser[A]:
  def parseExpression(text: String): MathExpr[A]
  def parseCommand(text: String): Command
