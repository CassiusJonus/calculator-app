package io.github.cassius.jonus.calculator
package expression

import zio.*

/*
Contains definitions for the main functionality of the application. This trait
 */
trait Dependency:

  def evaluateExpression[A](expr: MathExpr[A]): A
