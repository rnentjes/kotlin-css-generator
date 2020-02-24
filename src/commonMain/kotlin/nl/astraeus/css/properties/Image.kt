package nl.astraeus.css.properties

class Image(
    value: String
) : CssProperty(value) {

    companion object {
        fun url(url: String) = Image("url($url)")
        fun none() = Image("none")
        fun initial() = Image("initial")
        fun inherit() = Image("inherit")
    }
}
