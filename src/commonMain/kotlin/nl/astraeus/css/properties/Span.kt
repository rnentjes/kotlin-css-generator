package nl.astraeus.css.properties

class Span(
    value: String
) : CssProperty(value) {

    companion object {
        fun none() = Clip("none")
        fun all() = Clip("all")
        fun initial() = Clip("initial")
        fun inherit() = Clip("inherit")
    }

}
