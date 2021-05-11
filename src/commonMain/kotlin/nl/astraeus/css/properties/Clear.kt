package nl.astraeus.css.properties


class Clear(
  value: String
) : CssProperty(value) {

  companion object {
    val none = Clear("none")
    val left = Clear("left")
    val right = Clear("right")
    val both = Clear("both")
    val initial = Clear("initial")
    val inherit = Clear("inherit")
  }

}
