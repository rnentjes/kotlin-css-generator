package nl.astraeus.css.properties

class VerticalAlign(
  value: String
) : CssProperty(value) {

  companion object {
    val baseline = VerticalAlign("baseline")
    val sub = VerticalAlign("sub")
    val _super = VerticalAlign("super")
    val top = VerticalAlign("top")
    val textTop = VerticalAlign("text-top")
    val middle = VerticalAlign("middle")
    val bottom = VerticalAlign("bottom")
    val textBottom = VerticalAlign("text-bottom")
    val initial = VerticalAlign("initial")
    val inherit = VerticalAlign("inherit")
  }

}
