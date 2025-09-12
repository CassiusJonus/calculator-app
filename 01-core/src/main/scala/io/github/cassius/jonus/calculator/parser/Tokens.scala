package io.github.cassius.jonus.calculator
package parser

import cats.parse.Rfc5234.*
import cats.parse.*

/*
Contains tokens that will be used to parse math expressions and terminal
commands
 */
object Tokens:
  val plus =
    Parser.char('+')
  val minus =
    Parser.char('-')
  val times =
    Parser.char('*')
  val dividedBy =
    Parser.char('/')
  val exp =
    Parser.char('^')
  val help =
    Parser.string("help")
  val exit =
    Parser.string("exit")
  val eval =
    Parser.string("eval")
