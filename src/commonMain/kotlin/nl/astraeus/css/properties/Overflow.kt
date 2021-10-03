package nl.astraeus.css.properties

class Overflow(
  value: String
) : CssProperty(value) {

  companion object {
    val visible = Overflow("visible")
    val hidden = Overflow("hidden")
    val scroll = Overflow("scroll")
    val auto = Overflow("auto")
    val initial = BorderWidth("initial")
    val inherit = BorderWidth("inherit")
  }
}
