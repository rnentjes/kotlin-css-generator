package nl.astraeus.css.properties

class Color(
    value: String
) : CssProperty(value) {

    companion object {
        fun auto() = Color("auto")
        fun transparant() = Color("transparant")
        fun initial() = Color("initial")
        fun inherit() = Color("inherit")
        fun hex(hex: String) = Color("#$hex")
        fun rgb(
            red: Int,
            green: Int,
            blue: Int
        ) = Color("rgb($red, $green, $blue)")
        fun rgba(
            red: Int,
            green: Int,
            blue: Int,
            alpha: Double
        ) = Color("rgba($red, $green, $blue, $alpha)")
        fun hsl(
            hue: Int,
            saturation: Int,
            lightness: Int
        ) = Color("hsl($hue, $saturation, $lightness)")
        fun hsla(
            hue: Int,
            saturation: Int,
            lightness: Int,
            alpha: Double
        ) = Color("hsla($hue, $saturation, $lightness, $alpha)")
    }
}
