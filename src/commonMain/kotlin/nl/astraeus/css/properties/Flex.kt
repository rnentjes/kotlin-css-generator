package nl.astraeus.css.properties

class FlexDirection(
  value: String
) : CssProperty(value) {

  companion object {
    val row = FlexDirection("row")
    val rowReverse = FlexDirection("row-reverse")
    val column = FlexDirection("column")
    val columnReverse = FlexDirection("column-reverse")
    val initial = FlexDirection("initial")
    val inherit = FlexDirection("inherit")
  }

}

class FlexGrowShrink(
  value: String
) : CssProperty(value) {

  companion object {
    val initial = FlexGrowShrink("initial")
    val inherit = FlexGrowShrink("inherit")

    fun number(number: Int) = FlexGrowShrink("$number")
  }

}

class FlexWrap(
  value: String
) : CssProperty(value) {

  companion object {
    val nowrap = FlexWrap("nowrap")
    val wrap = FlexWrap("wrap")
    val wrapReverse = FlexWrap("wrap-reverse")
    val initial = FlexWrap("initial")
    val inherit = FlexWrap("inherit")
  }

}
