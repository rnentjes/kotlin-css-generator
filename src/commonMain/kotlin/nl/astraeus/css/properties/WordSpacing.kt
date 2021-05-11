package nl.astraeus.css.properties

class WordSpacing(
    value: String
) : CssProperty(value) {

    companion object {
        val normal = WordSpacing("normal")
        val initial = WordSpacing("initial")
        val inherit = WordSpacing("inherit")
    }

}
