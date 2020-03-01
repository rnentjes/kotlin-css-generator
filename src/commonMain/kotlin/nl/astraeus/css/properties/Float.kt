package nl.astraeus.css.properties

class Float(
    value: String
) : CssProperty(value) {

    companion object {
        fun none() = Float("none")
        fun left() = Float("left")
        fun right() = Float("right")
        fun initial() = Float("initial")
        fun inherit() = Float("inherit")
    }

}
