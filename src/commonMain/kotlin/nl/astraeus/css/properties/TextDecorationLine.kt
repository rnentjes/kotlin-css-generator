package nl.astraeus.css.properties

class TextDecorationLine(
    value: String
) : CssProperty(value) {

    companion object {
        val none = TextDecorationLine("none")
        val underline = TextDecorationLine("underline")
        val overline = TextDecorationLine("overline")
        val lineThrough = TextDecorationLine("line-through")
        val initial = TextDecorationLine("initial")
        val inherit = TextDecorationLine("inherit")
    }

}
