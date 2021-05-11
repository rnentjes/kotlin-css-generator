package nl.astraeus.css.properties

interface CssValue {
    fun css(): String
}

open class CssProperty(
    var value: String
): CssValue {

    override fun css(): String = value

}

fun text(value: String) = TextProperty(value)

class TextProperty(
    value: String
): CssProperty(value)
