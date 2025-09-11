package io.github.cassius.jonus.calculator
package expression

/*
Defines an interface for a mathematical expression that will be extended by case
classes defining the valid expressions for the application.
 */
sealed trait MathExpr[A]:

end MathExpr

// list of expressions that the application will process
case class Num[A](num: A) extends MathExpr[A]
case class Add[A](a: MathExpr[A], b: MathExpr[A]) extends MathExpr[A]
case class Subtract[A](a: MathExpr[A], b: MathExpr[A]) extends MathExpr[A]
case class Multiply[A](a: MathExpr[A], b: MathExpr[A]) extends MathExpr[A]
case class Divide[A](a: MathExpr[A], b: MathExpr[A]) extends MathExpr[A]
case class Exp[A](base: MathExpr[A], exponent: MathExpr[A]) extends MathExpr[A]
