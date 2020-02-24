package nl.astraeus.css.properties

class AlignContent(
    value: String
) : CssProperty(value) {

    companion object {
        fun stretch() = AlignContent("stretch")
        fun center() = AlignContent("center")
        fun flexStart() = AlignContent("flex-start")
        fun flexEnd() = AlignContent("flex-end")
        fun spaceBetween() = AlignContent("space-between")
        fun spaceAround() = AlignContent("space-around")
        fun initial() = AlignContent("initial")
        fun inherit() = AlignContent("inherit")
    }
}
