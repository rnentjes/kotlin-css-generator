package nl.astraeus.css.properties


class Clear(
    value: String
): CssProperty(value) {

    companion object {
        fun none() = Clear("none")
        fun left() = Clear("left")
        fun right() = Clear("right")
        fun both() = Clear("both")
        fun initial() = Clear("initial")
        fun inherit() = Clear("inherit")
    }

}
