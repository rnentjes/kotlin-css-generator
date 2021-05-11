package nl.astraeus.css.properties

class Resize(
    value: String
) : CssProperty(value) {

    companion object {
        val none = Resize("none")
        val both = Resize("both")
        val horizontal = Resize("horizontal")
        val vertical = Resize("vertical")
        val initial = Resize("initial")
        val inherit = Resize("inherit")
    }

}
