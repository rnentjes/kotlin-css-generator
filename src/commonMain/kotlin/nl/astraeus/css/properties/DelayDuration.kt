package nl.astraeus.css.properties

class DelayDuration(
    value: String
) : CssProperty(value) {

    companion object {
        fun seconds(seconds: Int) = DelayDuration("${seconds}s")
        fun initial() = DelayDuration("initial")
        fun inherit() = DelayDuration("inherit")
    }
}
