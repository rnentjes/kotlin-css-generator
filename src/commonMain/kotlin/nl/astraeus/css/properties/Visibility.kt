package nl.astraeus.css.properties

class Visibility(
  value: String
) : CssProperty(value) {

  companion object {
    val visible = Visibility("visible")
    val hidden = Visibility("hidden")
    val collapse = Visibility("collapse")
    val initial = Visibility("initial")
    val inherit = Visibility("inherit")
  }

}
