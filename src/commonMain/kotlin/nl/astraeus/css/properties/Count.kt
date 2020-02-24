package nl.astraeus.css.properties

class  Count(
    value: String
) : CssProperty(value) {

    companion object {
        fun count(number: Int): Count =
            Count("$number")
        fun infinite(): Count =
            Count("infinite")
        fun initial(): Count =
            Count("initial")
        fun inherit(): Count =
            Count("inherit")
    }
}
