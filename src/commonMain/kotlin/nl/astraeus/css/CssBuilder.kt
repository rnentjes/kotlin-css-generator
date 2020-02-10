package nl.astraeus.css

@DslMarker
annotation class CssTagMarker

@CssTagMarker
open class Style(
    var color: Color? = null,
    var backgroundColor: Color? = null,
    var left: Measurement? = null,
    var top: Measurement? = null,
    var width: Measurement? = null,
    var height: Measurement? = null,
    var fontFamily: PlainProperty? = null,
    var fontSize: FontSize? = null
) {

    fun getMapping() = mapOf(
        "color" to color,
        "background-color" to backgroundColor,
        "left" to left,
        "top" to top,
        "width" to width,
        "height" to height,
        "font-family" to fontFamily,
        "font-size" to fontSize
    )

    fun propertyCss(indent: String, name: String, prop: CssProperty?): String = if (prop != null) {
        "$indent$name: ${prop.css()};\n"
    } else {
        ""
    }

    fun generatePropertyCss(indent: String): String {
        val builder = StringBuilder()

        for ((name, prop) in getMapping()) {
            builder.append(propertyCss(indent, name, prop))
        }

        return builder.toString()
    }

}

@CssTagMarker
open class StyleDefinition : Style() {
    val definitions: MutableMap<String, StyleDefinition> = mutableMapOf()
    val includes: MutableList<Style> = mutableListOf()

    fun css(selector: String, style: StyleDefinition.() -> Unit) {
        val styleValue = StyleDefinition()

        style(styleValue)

        definitions[selector] = styleValue
    }

    fun include(style: Style) {
        includes.add(style)
    }

    open fun generateCss(namespace: String = "", indent: String = "  "): String {
        val builder = StringBuilder()

        for ((name, prop) in definitions) {
            val css = StringBuilder()
            css.append(prop.generatePropertyCss(indent))
            for (style in prop.includes) {
                css.append(style.generatePropertyCss(indent))
            }
            if (css.isNotBlank()) {
                builder.append("$namespace $name".trim())
                builder.append(" {\n")
                builder.append(css)
                builder.append("}\n\n")
            }

            builder.append(prop.generateCss( "${namespace} $name".trim(), indent))
        }

        return builder.toString()
    }

}

fun css(definition: Style.() -> Unit): Style {
    val css = Style()

    definition(css)

    return css
}

class CssBuilder {
    var definition: StyleDefinition = StyleDefinition()

    fun style(definition: StyleDefinition.() -> Unit) {
        definition(this.definition)
    }

    fun getCss(): String = definition.generateCss()

    override fun toString(): String {
        return "CssBuilder(${definition.generateCss()})"
    }
}
