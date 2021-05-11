package nl.astraeus.css.properties

class TextAlignLast(
    value: String
) : CssProperty(value) {

    companion object {
        val auto = TextAlignLast("auto")
        val left = TextAlignLast("left")
        val right = TextAlignLast("right")
        val center = TextAlignLast("center")
        val justify = TextAlignLast("justify")
        val start = TextAlignLast("start")
        val end = TextAlignLast("end")
        val initial = TextAlignLast("initial")
        val inherit = TextAlignLast("inherit")
    }

}
