package nl.astraeus.css.properties

class All(
    value: String
) : CssProperty(value) {

    companion object {
        fun initial() = All("initial")
        fun inherit() = All("inherit")
        fun unset() = All("unset")
        fun revert() = All("revert")
    }

}
