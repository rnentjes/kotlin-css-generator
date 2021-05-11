package nl.astraeus.css.properties

class OutlineWidth(
  value: String
) : CssProperty(value) {

  companion object {
    val thin = OutlineWidth("thin")
    val medium = OutlineWidth("medium")
    val thick = OutlineWidth("thick")
    val initial = BorderWidth("initial")
    val inherit = BorderWidth("inherit")
  }
}
