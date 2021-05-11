package nl.astraeus.css.properties

class BackfaceVisibility(
    value: String
) : CssProperty(value) {

    companion object {
        val visible = BackfaceVisibility("visible")
        val hidden = BackfaceVisibility("hidden")
        val initial = BackfaceVisibility("initial")
        val inherit = BackfaceVisibility("inherit")
    }
}
