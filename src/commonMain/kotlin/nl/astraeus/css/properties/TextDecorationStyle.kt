package nl.astraeus.css.properties

class TextDecorationStyle(
    value: String
) : CssProperty(value) {

    companion object {
        val solid = TextDecorationStyle("solid")
        val double = TextDecorationStyle("double")
        val dotted = TextDecorationStyle("dotted")
        val dashed = TextDecorationStyle("dashed")
        val wavy = TextDecorationStyle("wavy")
        val initial = TextDecorationStyle("initial")
        val inherit = TextDecorationStyle("inherit")
    }

}
