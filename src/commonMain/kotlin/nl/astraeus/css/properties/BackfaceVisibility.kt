package nl.astraeus.css.properties

class BackfaceVisibility(
    value: String
) : CssProperty(value) {

    companion object {
        fun visible() = BackfaceVisibility("visible")
        fun hidden() = BackfaceVisibility("hidden")
        fun initial() = BackfaceVisibility("initial")
        fun inherit() = BackfaceVisibility("inherit")
    }
}
