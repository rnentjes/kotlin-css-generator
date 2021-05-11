package nl.astraeus.css.properties

class TransformStyle(
  value: String
) : CssProperty(value) {

  companion object {
    val flat = TransformStyle("flat")
    val preserve3d = TransformStyle("preserve-3d")
    val initial = TransformStyle("initial")
    val inherit = TransformStyle("inherit")
  }

}
