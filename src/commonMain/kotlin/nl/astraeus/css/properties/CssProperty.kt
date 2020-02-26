package nl.astraeus.css.properties

open class CssProperty(
    val value: String
) {

    fun css(): String = value

}

fun text(value: String) = TextProperty(value)

class TextProperty(
    value: String
): CssProperty(value)
