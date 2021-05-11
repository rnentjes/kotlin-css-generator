package nl.astraeus.css.properties

class TextTransform(
  value: String
) : CssProperty(value) {

  companion object {
    val none = TextTransform("none")
    val capitalize = TextTransform("capitalize")
    val uppercase = TextTransform("uppercase")
    val lowercase = TextTransform("lowercase")
    val initial = TextTransform("initial")
    val inherit = TextTransform("inherit")
  }

}
