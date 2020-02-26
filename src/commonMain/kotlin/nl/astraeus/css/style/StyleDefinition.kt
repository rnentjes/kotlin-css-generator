package nl.astraeus.css.style

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

    open fun generateCss(namespace: String = "", indent: String = "  ", minified: Boolean = false): String {
        val builder = StringBuilder()

        for ((name, prop) in definitions) {
            val css = StringBuilder()
            css.append(prop.generatePropertyCss(indent, minified))
            for (style in prop.includes) {
                css.append(style.generatePropertyCss(indent, minified))
            }
            if (css.isNotBlank()) {
                builder.append("\n$namespace $name".trim())
                if (!minified) {
                    builder.append(" ")
                }
                builder.append("{")
                if (!minified) {
                    builder.append("\n")
                }
                builder.append(css)
                builder.append("}")
                if (!minified) {
                    builder.append("\n\n")
                }
            }

            builder.append(prop.generateCss( "$namespace $name".trim(), indent, minified))
        }

        return builder.toString()
    }

}
