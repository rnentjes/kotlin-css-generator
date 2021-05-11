package nl.astraeus.css.properties

class PointerEvents(
  value: String
) : CssProperty(value) {

  companion object {
    val auto = PointerEvents("auto")
    val none = PointerEvents("none")
    val initial = PointerEvents("initial")
    val inherit = PointerEvents("inherit")
  }

}
