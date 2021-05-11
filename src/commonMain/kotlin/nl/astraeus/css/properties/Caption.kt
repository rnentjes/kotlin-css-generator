package nl.astraeus.css.properties

class CaptionSide(
    value: String
): CssProperty(value) {

    companion object {
        val top = CaptionSide("top")
        val bottom = CaptionSide("bottom")
        val initial = CaptionSide("initial")
        val inherit = CaptionSide("inherit")
    }

}
