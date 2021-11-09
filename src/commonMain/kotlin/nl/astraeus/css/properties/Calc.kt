package nl.astraeus.css.properties

fun calc(expression: CalcExpression) = Calc(expression)

infix operator fun CalcExpression.plus(other: CalcExpression) = CompoundCalcExpression(
  this,
  "+",
  other
)

infix operator fun CalcExpression.minus(other: CalcExpression) = CompoundCalcExpression(
  this,
  "-",
  other
)

interface CalcExpression

class CompoundCalcExpression(
  val left: CalcExpression,
  val operator: String,
  val right: CalcExpression
): CalcExpression {
  override fun toString(): String {
    return "$left $operator $right"
  }
}

class Calc(
  expression: CalcExpression
) : CssProperty(expression.toString())
