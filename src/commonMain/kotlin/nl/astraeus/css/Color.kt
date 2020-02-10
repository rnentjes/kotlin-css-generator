package nl.astraeus.css

fun rgb(red: Int, green: Int, blue: Int): Color = RGBColor(red, green, blue)
fun rgba(red: Int, green: Int, blue: Int, alpha: Double): Color = RGBAColor(red, green, blue, alpha)
fun hsl(hue: Int, saturation: Int, lightness: Int): Color = HSLColor(hue, saturation, lightness)
fun hsla(hue: Int, saturation: Int, lightness: Int, alpha: Double): Color = HSLAColor(hue, saturation, lightness, alpha)

open class Color : CssProperty() {

    override fun css(): String = "#xxxxxx"

}

class RGBColor(
    val red: Int,
    val green: Int,
    val blue: Int
) : Color() {

    override fun css(): String = "rgb($red, $green, $blue)"

}

class RGBAColor(
    val red: Int,
    val green: Int,
    val blue: Int,
    val alpha: Double
) : Color() {

    override fun css(): String = "rgba($red, $green, $blue, $alpha)"

}

class HSLColor(
    val hue: Int,
    val saturation: Int,
    val lightness: Int
) : Color() {

    override fun css(): String = "hsl($hue, $saturation, $lightness)"

}

class HSLAColor(
    val hue: Int,
    val saturation: Int,
    val lightness: Int,
    val alpha: Double
) : Color() {

    override fun css(): String = "hsla($hue, $saturation, $lightness, $alpha)"

}
