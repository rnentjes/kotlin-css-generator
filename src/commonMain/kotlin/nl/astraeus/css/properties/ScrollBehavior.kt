package nl.astraeus.css.properties

class ScrollBehavior(
    value: String
) : CssProperty(value) {

    companion object {
        val auto = ScrollBehavior("auto")
        val smooth = ScrollBehavior("smooth")
        val initial = ScrollBehavior("initial")
        val inherit = ScrollBehavior("inherit")
    }

}
