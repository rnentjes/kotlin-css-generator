package nl.astraeus.css.properties

class EmptyCells(
    value: String
) : CssProperty(value) {

    companion object {
        val show = EmptyCells("show")
        val hide = EmptyCells("hide")
        val initial = EmptyCells("initial")
        val inherit = EmptyCells("inherit")
    }

}
