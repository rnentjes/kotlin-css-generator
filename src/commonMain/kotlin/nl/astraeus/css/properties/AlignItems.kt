package nl.astraeus.css.properties

class AlignItems(
    value: String
) : CssProperty(value) {

    companion object {
        fun stretch() = AlignItems("stretch")
        fun center() = AlignItems("center")
        fun flexStart() = AlignItems("flex-start")
        fun flexEnd() = AlignItems("flex-end")
        fun baseline() = AlignItems("baseline")
        fun initial() = AlignItems("initial")
        fun inherit() = AlignItems("inherit")
    }

}
