package nl.astraeus.css.properties

class InitialInherit(
    value: String
) : CssProperty(value) {

    companion object {
        val initial = InitialInherit("initial")
        val inherit = InitialInherit("inherit")
    }

}
