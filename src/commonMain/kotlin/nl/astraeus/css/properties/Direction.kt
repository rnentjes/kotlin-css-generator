package nl.astraeus.css.properties

class Direction(
  value: String
) : CssProperty(value) {

  companion object {
    val ltr = Direction("ltr")
    val rtl = Direction("rtl")
    val initial = Direction("initial")
    val inherit = Direction("inherit")
  }

}
