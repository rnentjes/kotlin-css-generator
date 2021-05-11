package nl.astraeus.css.properties

class UnicodeBidi(
    value: String
) : CssProperty(value) {

    companion object {
        val normal = UnicodeBidi("normal")
        val embed = UnicodeBidi("embed")
        val bidiOverride = UnicodeBidi("bidi-override")
        val initial = UnicodeBidi("initial")
        val inherit = UnicodeBidi("inherit")
    }

}
