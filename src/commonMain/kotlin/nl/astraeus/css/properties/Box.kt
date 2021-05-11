package nl.astraeus.css.properties

class BoxDecorationBreak(
    value: String
): CssProperty(value) {

    companion object {
        val slice = BoxDecorationBreak("slice")
        val clone = BoxDecorationBreak("clone")
        val initial = BoxDecorationBreak("initial")
        val inherit = BoxDecorationBreak("inherit")
        val unset = BoxDecorationBreak("unset")
    }
}

class BoxShadow(
    value: String
): CssProperty(value) {

    companion object {
        val none = BoxShadow("none")
        val inset = BoxShadow("inset")
        val initial = BoxShadow("initial")
        val inherit = BoxShadow("inherit")

        fun text(txt: String) = BoxShadow(txt)
    }
}

class BoxSizing(
    value: String
): CssProperty(value) {

    companion object {
        val contextBox = BoxSizing("content-box")
        val borderBox = BoxSizing("border-box")
        val initial = BoxShadow("initial")
        val inherit = BoxShadow("inherit")
    }
}
