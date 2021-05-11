package nl.astraeus.css.properties

class PageBreak(
  value: String
) : CssProperty(value) {

  companion object {
    val auto = PageBreak("auto")
    val always = PageBreak("always")
    val avoid = PageBreak("avoid")
    val left = PageBreak("left")
    val right = PageBreak("right")
    val initial = PageBreak("initial")
    val inherit = PageBreak("inherit")
  }

}
