package nl.astraeus.css.properties

class AlignSelf(
    value: String
) : CssProperty(value) {

    companion object {
        fun auto() = AlignSelf("auto")
        fun stretch() = AlignSelf("stretch")
        fun center() = AlignSelf("center")
        fun flexStart() = AlignSelf("flex-start")
        fun flexEnd() = AlignSelf("flex-end")
        fun baseline() = AlignSelf("baseline")
        fun initial() = AlignSelf("initial")
        fun inherit() = AlignSelf("inherit")
    }
}
