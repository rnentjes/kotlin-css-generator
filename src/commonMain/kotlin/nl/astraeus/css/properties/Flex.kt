package nl.astraeus.css.properties

class FlexDirection(
    value: String
) : CssProperty(value) {

    companion object {
        fun row() = FlexDirection("row")
        fun rowReverse() = FlexDirection("row-reverse")
        fun column() = FlexDirection("column")
        fun columnReverse() = FlexDirection("column-reverse")
        fun initial() = FlexDirection("initial")
        fun inherit() = FlexDirection("inherit")
    }

}

class FlexGrowShrink(
    value: String
) : CssProperty(value) {

    companion object {
        fun number(number: Int) = FlexDirection("$number")
        fun initial() = FlexDirection("initial")
        fun inherit() = FlexDirection("inherit")
    }

}

class FlexWrap(
    value: String
) : CssProperty(value) {

    companion object {
        fun nowrap() = FlexWrap("nowrap")
        fun wrap() = FlexWrap("wrap")
        fun wrapReverse() = FlexWrap("wrap-reverse")
        fun initial() = FlexWrap("initial")
        fun inherit() = FlexWrap("inherit")
    }

}
