package nl.astraeus.css.properties

class Isolation(
  value: String
) : CssProperty(value) {

  companion object {
    val auto = Isolation("auto")
    val isolate = Isolation("isolate")
    val initial = Isolation("initial")
    val inherit = Isolation("inherit")
  }

}
