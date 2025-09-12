package io.github.cassius.jonus.calculator
package parser

import cats.parse.*
import cats.parse.Rfc5234.*
import io.github.cassius.jonus.calculator.expression.*

final class ParserImpl extends ExpressionParser[Double] {
  private val number =
    digit.rep *> (Parser.char('.') *> digit.rep).?.string.map(num =>
      num.toDouble
    )
  private val litExpr = number.map(Num.apply)
  private val add =
    ((litExpr <* Tokens.plus) ~ litExpr).map(Add.apply)
  private val subtract =
    ((litExpr <* Tokens.minus) ~ litExpr).map(Subtract.apply)
  private val multiply =
    ((litExpr <* Tokens.times) ~ litExpr).map(Multiply.apply)
  private val divide =
    ((litExpr <* Tokens.dividedBy) ~ litExpr).map(Divide.apply)
  private val exponent =
    ((litExpr <* Tokens.exp) ~ litExpr).map(Exp.apply)

  override def parseExpression(text: String): MathExpr[Double] =
    val finalExpr =
      litExpr.backtrack | add.backtrack | subtract.backtrack | multiply.backtrack | divide.backtrack | exponent
    finalExpr.parse(text) match
      case Right(expr) => expr._2
      case Left(value) => Num(0)
  override def parseCommand(text: String): Command =
    val commandExpr = Tokens.help.as(Command.Help) | Tokens.exit.as(
      Command.Exit
    ) | Tokens.eval.as(Command.Evaluate)
    commandExpr.parse(text) match
      case Right(command) => command._2
      case Left(invalid)  => Command.Help
}
