package nl.astraeus.css.properties

class Span(
  value: String
) : CssProperty(value) {

  companion object {
    val none = Clip("none")
    val all = Clip("all")
    val initial = Clip("initial")
    val inherit = Clip("inherit")
  }

}
