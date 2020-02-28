package nl.astraeus.css.properties

class CaptionSide(
    value: String
): CssProperty(value) {

    companion object {
        fun top() = BoxSizing("top")
        fun bottom() = BoxSizing("bottom")
        fun initial() = BoxShadow("initial")
        fun inherit() = BoxShadow("inherit")
    }

}
