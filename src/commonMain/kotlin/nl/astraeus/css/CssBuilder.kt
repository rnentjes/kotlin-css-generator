package nl.astraeus.css

import nl.astraeus.css.style.Css
import nl.astraeus.css.style.Style

fun css(definition: Css) = definition

fun style(definition: Css): Style {
    val css = Style()

    definition(css)

    return css
}


class CssBuilder {
    var definition: Style = Style()

    fun style(definition: Style.() -> Unit) {
        definition(this.definition)
    }

    fun getCss(minified: Boolean = false): String = definition.generateCss(minified = minified)

    override fun toString(): String {
        return "CssBuilder(${definition.generateCss()})"
    }
}
