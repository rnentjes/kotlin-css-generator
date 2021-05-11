package nl.astraeus.css.properties

class Perspective(
    value: String
) : CssProperty(value) {

    companion object {
        val none = Perspective("none")
        val initial = Perspective("initial")
        val inherit = Perspective("inherit")
    }

}
