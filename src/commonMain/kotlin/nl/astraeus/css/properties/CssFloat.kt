package nl.astraeus.css.properties

class CssFloat(
  value: String
) : CssProperty(value) {

  companion object {
    val none = CssFloat("none")
    val left = CssFloat("left")
    val right = CssFloat("right")
    val initial = CssFloat("initial")
    val inherit = CssFloat("inherit")
  }

}
