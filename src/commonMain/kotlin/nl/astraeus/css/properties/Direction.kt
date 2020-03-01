package nl.astraeus.css.properties

class Direction(
    value: String
) : CssProperty(value) {

    companion object {
        fun ltr() = Direction("ltr")
        fun rtl() = Direction("rtl")
        fun initial() = Direction("initial")
        fun inherit() = Direction("inherit")
    }

}
