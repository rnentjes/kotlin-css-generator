package nl.astraeus.css.properties

open class CssProperty(
    val value: String
) {
    fun css(): String = value

    open fun validate() {}

    open fun validateMultiple(props: List<*>) {}
}

fun text(value: String) = TextProperty(value)

class TextProperty(
    value: String
): CssProperty(value)
