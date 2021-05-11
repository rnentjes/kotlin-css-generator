package nl.astraeus.css.properties

class JustifyContent(
  value: String
) : CssProperty(value) {

  companion object {
    val flexStart = JustifyContent("flex-start")
    val flexEnd = JustifyContent("flex-end")
    val center = JustifyContent("center")
    val spaceBetween = JustifyContent("space-between")
    val spaceAround = JustifyContent("space-around")
    val initial = JustifyContent("initial")
    val inherit = JustifyContent("inherit")
  }

}
