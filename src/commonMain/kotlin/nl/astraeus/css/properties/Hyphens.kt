package nl.astraeus.css.properties

class Hyphens(
  value: String
) : CssProperty(value) {

  companion object {
    val none = Hyphens("none")
    val manual = Hyphens("manual")
    val auto = Hyphens("auto")
    val initial = Hyphens("initial")
    val inherit = Hyphens("inherit")
  }

}
