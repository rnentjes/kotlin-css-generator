package nl.astraeus.css.properties

class Position(
    value: String
) : CssProperty(value) {

    companion object {
        val static = Position("static")
        val absolute = Position("absolute")
        val fixed = Position("fixed")
        val relative = Position("relative")
        val sticky = Position("sticky")
        val initial = Position("initial")
        val inherit = Position("inherit")
    }

}
