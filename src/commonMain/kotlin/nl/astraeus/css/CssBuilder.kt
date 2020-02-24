package nl.astraeus.css

import nl.astraeus.css.style.StyleDefinition

fun css(definition: StyleDefinition.() -> Unit): StyleDefinition {
    val css = StyleDefinition()

    definition(css)

    return css
}

class CssBuilder {
    var definition: StyleDefinition =
        StyleDefinition()

    fun style(definition: StyleDefinition.() -> Unit) {
        definition(this.definition)
    }

    fun getCss(): String = definition.generateCss()

    override fun toString(): String {
        return "CssBuilder(${definition.generateCss()})"
    }
}
