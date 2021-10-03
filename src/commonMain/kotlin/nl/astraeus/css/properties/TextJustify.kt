package nl.astraeus.css.properties

class TextJustify(
  value: String
) : CssProperty(value) {

  companion object {
    val auto = TextJustify("auto")
    val interWord = TextJustify("inter-word")
    val interCharacter = TextJustify("inter-character")
    val none = TextJustify("none")
    val initial = TextJustify("initial")
    val inherit = TextJustify("inherit")
  }

}
