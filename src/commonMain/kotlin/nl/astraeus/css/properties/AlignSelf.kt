package nl.astraeus.css.properties

class AlignSelf(
  value: String
) : CssProperty(value) {

  companion object {
    val auto = AlignSelf("auto")
    val stretch = AlignSelf("stretch")
    val center = AlignSelf("center")
    val flexStart = AlignSelf("flex-start")
    val flexEnd = AlignSelf("flex-end")
    val baseline = AlignSelf("baseline")
    val initial = AlignSelf("initial")
    val inherit = AlignSelf("inherit")
  }

}
