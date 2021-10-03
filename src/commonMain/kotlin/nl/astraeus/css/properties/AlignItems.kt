package nl.astraeus.css.properties

class AlignItems(
  value: String
) : CssProperty(value) {

  companion object {
    val stretch = AlignItems("stretch")
    val center = AlignItems("center")
    val flexStart = AlignItems("flex-start")
    val flexEnd = AlignItems("flex-end")
    val baseline = AlignItems("baseline")
    val initial = AlignItems("initial")
    val inherit = AlignItems("inherit")
  }

}
