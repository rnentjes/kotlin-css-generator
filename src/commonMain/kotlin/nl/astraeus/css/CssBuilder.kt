package nl.astraeus.css

import nl.astraeus.css.style.ConditionalCss
import nl.astraeus.css.style.ConditionalStyle
import nl.astraeus.css.style.Css
import nl.astraeus.css.style.Style

fun css(definition: Css) = definition

fun style(definition: ConditionalCss): ConditionalStyle {
    val css = ConditionalStyle()

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
