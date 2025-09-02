package io.github.cassius.jonus.calculator

import expression.MathExpr

enum Command:
  case Exit
  case Help
  case Evaluate[A](expression: MathExpr[A])
