package nl.astraeus.css.properties

class  Count(
    value: String
) : CssProperty(value) {

    companion object {
        val auto: Count = Count("auto")
        val infinite: Count = Count("infinite")
        val initial: Count = Count("initial")
        val inherit: Count = Count("inherit")

        fun count(number: Int): Count = Count("$number")
    }
}
