package nl.astraeus.css.properties

class HangingPunctuation(
    value: String
) : CssProperty(value) {

    companion object {
        val none = HangingPunctuation("none")
        val first = HangingPunctuation("first")
        val last = HangingPunctuation("last")
        val allowEnd = HangingPunctuation("allow-end")
        val forceEnd = HangingPunctuation("force-end")
        val initial = HangingPunctuation("initial")
        val inherit = HangingPunctuation("inherit")
    }

}
