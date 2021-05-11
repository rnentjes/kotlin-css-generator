package nl.astraeus.css.properties

class TextAlign(
    value: String
) : CssProperty(value) {

    companion object {
        val left = TextAlign("left")
        val right = TextAlign("right")
        val center = TextAlign("center")
        val justify = TextAlign("justify")
        val initial = TextAlign("initial")
        val inherit = TextAlign("inherit")
    }

}
