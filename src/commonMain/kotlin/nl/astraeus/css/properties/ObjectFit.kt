package nl.astraeus.css.properties

class ObjectFit(
    value: String
) : CssProperty(value) {

    companion object {
        val fill = ObjectFit("fill")
        val contain = ObjectFit("contain")
        val cover = ObjectFit("cover")
        val scaleDown = ObjectFit("scale-down")
        val none = ObjectFit("none")
        val initial = ObjectFit("initial")
        val inherit = ObjectFit("inherit")
    }

}
