package nl.astraeus.css.properties

class BorderRadius(
    value: String
): CssProperty(value) {
    constructor(topLeft: Int, topRight: Int, bottomRight: Int, bottomLeft: Int): this(
        "${topLeft}px ${topRight}px ${bottomRight}px ${bottomLeft}px"
    )
    constructor(topLeft: Int, topRightBottomLeft: Int, bottomRight: Int): this(
        "${topLeft}px ${topRightBottomLeft}px ${bottomRight}px"
    )
    constructor(topLeftBottomRight: Int, topRightBottomLeft: Int): this(
        "${topLeftBottomRight}px ${topRightBottomLeft}px"
    )
    constructor(radius: Int): this("${radius}px")

    companion object {
        fun px(nr: Int) = BorderRadius("${nr}px")
        fun em(nr: Int) = BorderRadius("${nr}em")
        fun em(nr: Double) = BorderRadius("${nr}em")
        fun perc(nr: Int) = BorderRadius("${nr}%")
        fun perc(nr: Double) = BorderRadius("${nr}%")
        fun pc(nr: Int) = BorderRadius("${nr}pc")
        fun pc(nr: Double) = BorderRadius("${nr}pc")
        fun cm(nr: Int) = BorderRadius("${nr}cm")
        fun cm(nr: Double) = BorderRadius("${nr}cm")
        fun initial() = BorderRadius("initial")
        fun inherit() = BorderRadius("inherit")
    }
}

class RuleBorderStyle(
    value: String
): CssProperty(value) {

    companion object {
        fun none() = RuleBorderStyle("none")
        fun hidden() = RuleBorderStyle("hidden")
        fun dotted() = RuleBorderStyle("dotted")
        fun dashed() = RuleBorderStyle("dashed")
        fun solid() = RuleBorderStyle("solid")
        fun double() = RuleBorderStyle("double")
        fun groove() = RuleBorderStyle("groove")
        fun ridge() = RuleBorderStyle("ridge")
        fun inset() = RuleBorderStyle("inset")
        fun outset() = RuleBorderStyle("outset")
        fun initial() = RuleBorderStyle("initial")
        fun inherit() = RuleBorderStyle("inherit")
    }
}

class BorderWidth(
    value: String
): CssProperty(value) {

    companion object {
        fun thin() = BorderWidth("thin")
        fun medium() = BorderWidth("medium")
        fun thick() = BorderWidth("thick")

        fun px(nr: Int) = BorderWidth("${nr}px")
        fun em(nr: Int) = BorderWidth("${nr}em")
        fun em(nr: Double) = BorderWidth("${nr}em")
        fun perc(nr: Int) = BorderWidth("${nr}%")
        fun perc(nr: Double) = BorderWidth("${nr}%")
        fun pc(nr: Int) = BorderWidth("${nr}pc")
        fun pc(nr: Double) = BorderWidth("${nr}pc")
        fun cm(nr: Int) = BorderWidth("${nr}cm")
        fun cm(nr: Double) = BorderWidth("${nr}cm")

        fun initial() = BorderWidth("initial")
        fun inherit() = BorderWidth("inherit")
    }
}

class BorderCollapse(
    value: String
): CssProperty(value) {

    companion object {
        fun separate() = BorderWidth("separate")
        fun collapse() = BorderWidth("collapse")
    }
}

class BorderImageWidth (
    value: String
): CssProperty(value) {

    companion object {
        fun px(nr: Int) = BorderRadius("${nr}px")
        fun nr(nr: Int) = Image("$nr")
        fun perc(nr: Int) = BorderRadius("${nr}%")
        fun perc(nr: Double) = BorderRadius("${nr}%")
        fun auto() = BorderWidth("auto")
        fun initial() = BorderWidth("initial")
        fun inherit() = BorderWidth("inherit")
    }
}

class BorderSpacing(
    value: String
): CssProperty(value) {

    companion object {
        fun px(nr: Int) = BorderRadius("${nr}px")
        fun em(nr: Int) = BorderRadius("${nr}em")
        fun em(nr: Double) = BorderRadius("${nr}em")
        fun perc(nr: Int) = BorderRadius("${nr}%")
        fun perc(nr: Double) = BorderRadius("${nr}%")
        fun pc(nr: Int) = BorderRadius("${nr}pc")
        fun pc(nr: Double) = BorderRadius("${nr}pc")
        fun cm(nr: Int) = BorderRadius("${nr}cm")
        fun cm(nr: Double) = BorderRadius("${nr}cm")
        fun initial() = BorderRadius("initial")
        fun inherit() = BorderRadius("inherit")
    }
}
