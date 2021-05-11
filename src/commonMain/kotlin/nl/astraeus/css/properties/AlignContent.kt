package nl.astraeus.css.properties

class AlignContent(
  value: String
) : CssProperty(value) {

  companion object {
    val stretch = AlignContent("stretch")
    val center = AlignContent("center")
    val flexStart = AlignContent("flex-start")
    val flexEnd = AlignContent("flex-end")
    val spaceBetween = AlignContent("space-between")
    val spaceAround = AlignContent("space-around")
    val initial = AlignContent("initial")
    val inherit = AlignContent("inherit")
  }
}
