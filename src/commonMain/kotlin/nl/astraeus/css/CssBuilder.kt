package nl.astraeus.css

@DslMarker
annotation class CssTagMarker

@CssTagMarker
open class Style(
    var alignContent: AlignContent? = null,
    var alignItems: AlignItems? = null,
    var alignSelf: AlignSelf? = null,
    var all: All? = null,
    var animation: TextProperty? = null,
    var animationDelay: DelayDuration? = null,
    var animationDirection: AnimationDirection? = null,
    var animationDuration: DelayDuration? = null,
    var animationFillMode: AnimationFillMode? = null,
    var animationIterationCount: Count? = null,
    var backgroundColor: Color? = null,
    var color: Color? = null,
    var fontFamily: TextProperty? = null,
    var fontSize: FontSize? = null,
    var height: Measurement? = null,
    var left: Measurement? = null,
    var top: Measurement? = null,
    var transitionDelay: DelayDuration? = null,
    var transitionDuration: DelayDuration? = null,
    var width: Measurement? = null
) {

    fun getMapping() = mapOf(
        "align-content" to alignContent,
        "align-items" to alignItems,
        "align-self" to alignSelf,
        "all" to all,
        "animation" to animation,
        "animation-delay" to animationDelay,
        "animation-direction" to animationDirection,
        "animation-duration" to animationDuration,
        "animation-fill-mode" to animationFillMode,
        "animation-iteration-count" to animationIterationCount,
        "background-color" to backgroundColor,
        "color" to color,
        "font-family" to fontFamily,
        "font-size" to fontSize,
        "height" to height,
        "left" to left,
        "top" to top,
        "transition-delay" to transitionDelay,
        "transition-duration" to transitionDuration,
        "width" to width
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

fun css(definition: StyleDefinition.() -> Unit): StyleDefinition {
    val css = StyleDefinition()

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
