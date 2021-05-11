package nl.astraeus.css.properties

class WordWrap(
    value: String
) : CssProperty(value) {

    companion object {
        val normal = WordWrap("normal")
        val breakWord = WordWrap("break-word")
        val initial = WordWrap("initial")
        val inherit = WordWrap("inherit")
    }

}
