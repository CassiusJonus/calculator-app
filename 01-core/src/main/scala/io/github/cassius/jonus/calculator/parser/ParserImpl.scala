package io.github.cassius.jonus.calculator
package parser

import cats.parse.*
import expression.MathExpr.*

final class ParserImpl extends ExpressionParser[Double]:
  def parseExpression(expr: String) =
    Num(0)
  def parseCommand(command: String) =
    Command.Help
