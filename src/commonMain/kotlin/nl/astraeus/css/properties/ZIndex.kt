package nl.astraeus.css.properties

class ZIndex(
  value: String
) : CssProperty(value) {

  companion object {
    val auto = ZIndex("auto")
    val initial = ZIndex("initial")
    val inherit = ZIndex("inherit")
  }

}
