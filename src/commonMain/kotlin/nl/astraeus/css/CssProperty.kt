package nl.astraeus.css

interface CssProperty {

    fun css(): String

}

fun text(value: String) = TextProperty(value)

class TextProperty(
    val value: String
): CssProperty {

    override fun css(): String = value

}
