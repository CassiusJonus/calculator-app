package io.github.cassius.jonus.calculator
package parser

import cats.parse.*
import io.github.cassius.jonus.calculator.expression.*

final class ParserImpl extends ExpressionParser[Double]:
  def parseExpression(expr: String) =
    Num(1)

  def parseCommand(command: String) =
    Command.Help
