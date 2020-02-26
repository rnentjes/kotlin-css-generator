package nl.astraeus.css.properties

class BorderRadius(
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

class BorderStyle(
    value: String
): CssProperty(value) {

    companion object {
        fun none() = BorderStyle("none")
        fun hidden() = BorderStyle("hidden")
        fun dotted() = BorderStyle("dotted")
        fun dashed() = BorderStyle("dashed")
        fun solid() = BorderStyle("solid")
        fun double() = BorderStyle("double")
        fun groove() = BorderStyle("groove")
        fun ridge() = BorderStyle("ridge")
        fun inset() = BorderStyle("inset")
        fun outset() = BorderStyle("outset")
        fun initial() = BorderStyle("initial")
        fun inherit() = BorderStyle("inherit")
    }
}

class BorderWidth(
    value: String
): CssProperty(value) {

    companion object {
        fun thin() = BorderWidth("thin")
        fun medium() = BorderWidth("medium")
        fun thick() = BorderWidth("thick")

        fun px(nr: Int) = BorderRadius("${nr}px")
        fun em(nr: Int) = BorderRadius("${nr}em")
        fun em(nr: Double) = BorderRadius("${nr}em")
        fun perc(nr: Int) = BorderRadius("${nr}%")
        fun perc(nr: Double) = BorderRadius("${nr}%")
        fun pc(nr: Int) = BorderRadius("${nr}pc")
        fun pc(nr: Double) = BorderRadius("${nr}pc")
        fun cm(nr: Int) = BorderRadius("${nr}cm")
        fun cm(nr: Double) = BorderRadius("${nr}cm")

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
