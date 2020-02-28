package nl.astraeus.css.properties


class Break(
    value: String
): CssProperty(value) {

    companion object {
        fun auto() = Break("auto")
        fun all() = Break("all")
        fun always() = Break("always")
        fun avoid() = Break("avoid")
        fun avoidColumn() = Break("avoid-column")
        fun avoidPage() = Break("avoid-page")
        fun avoidRegion() = Break("avoid-region")
        fun column() = Break("column")
        fun left() = Break("left")
        fun page() = Break("page")
        fun recto() = Break("recto")
        fun region() = Break("region")
        fun right() = Break("right")
        fun verso() = Break("verso")
        fun initial() = Break("initial")
        fun inherit() = Break("inherit")
    }

}
