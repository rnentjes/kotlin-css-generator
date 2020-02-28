package nl.astraeus.css.properties

class BoxDecorationBreak(
    value: String
): CssProperty(value) {

    companion object {
        fun slice() = BorderWidth("slice")
        fun clone() = BorderWidth("clone")
        fun initial() = BorderWidth("initial")
        fun inherit() = BorderWidth("inherit")
        fun unset() = BorderWidth("unset")
    }
}

class BoxShadow(
    value: String
): CssProperty(value) {

    companion object {
        fun none() = BoxShadow("none")
        fun text(txt: String) = BoxShadow(txt)
        fun inset() = BoxShadow("inset")
        fun initial() = BoxShadow("initial")
        fun inherit() = BoxShadow("inherit")
    }
}

class BoxSizing(
    value: String
): CssProperty(value) {

    companion object {
        fun contextBox() = BoxSizing("content-box")
        fun borderBox() = BoxSizing("border-box")
        fun initial() = BoxShadow("initial")
        fun inherit() = BoxShadow("inherit")
    }
}
