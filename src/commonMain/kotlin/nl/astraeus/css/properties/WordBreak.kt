package nl.astraeus.css.properties

class WordBreak(
    value: String
) : CssProperty(value) {

    companion object {
        val normal = WordBreak("normal")
        val breakAll = WordBreak("break-all")
        val keepAll = WordBreak("keep-all")
        val breakWord = WordBreak("break-word")
        val initial = WordBreak("initial")
        val inherit = WordBreak("inherit")
    }

}
