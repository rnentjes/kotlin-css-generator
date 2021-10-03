package nl.astraeus.css.properties

class LetterSpacing(
  value: String
) : CssProperty(value) {

  companion object {
    val normal = LetterSpacing("normal")
    val initial = LetterSpacing("initial")
    val inherit = LetterSpacing("inherit")
  }

}
