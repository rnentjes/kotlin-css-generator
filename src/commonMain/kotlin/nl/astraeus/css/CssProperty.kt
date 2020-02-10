package nl.astraeus.css

abstract class CssProperty {

    abstract fun css(): String

}

fun plain(value: String) = PlainProperty(value)

class PlainProperty(
    val value: String
): CssProperty() {

    override fun css(): String = value

}
