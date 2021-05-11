package nl.astraeus.css.properties


class Break(
    value: String
): CssProperty(value) {

    companion object {
        val auto = Break("auto")
        val all = Break("all")
        val always = Break("always")
        val avoid = Break("avoid")
        val avoidColumn = Break("avoid-column")
        val avoidPage = Break("avoid-page")
        val avoidRegion = Break("avoid-region")
        val column = Break("column")
        val left = Break("left")
        val page = Break("page")
        val recto = Break("recto")
        val region = Break("region")
        val right = Break("right")
        val verso = Break("verso")
        val initial = Break("initial")
        val inherit = Break("inherit")
    }

}
