package io.github.cassius.jonus.calculator
package expression

/*
Contains definitions for the main functionality of the application. This trait
 */
trait Dependency[A]:
  def evaluate(expr: MathExpr[A]): A
