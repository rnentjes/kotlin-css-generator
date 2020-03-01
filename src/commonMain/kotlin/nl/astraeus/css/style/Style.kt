package nl.astraeus.css.style

import nl.astraeus.css.properties.*
import nl.astraeus.logging.log

typealias Css = Style.() -> Unit

@DslMarker
annotation class CssTagMarker

abstract class CssGenerator {
    val definitions: MutableMap<String, Css> = mutableMapOf()
    val extentions: MutableList<Css> = mutableListOf()

    abstract fun getMapping(): Map<String, Any?>

    abstract fun getValidator(name: String): List<Validator>?

    private fun propertyCss(indent: String, name: String, prop: CssProperty, minified: Boolean): String {
        getValidator(name)?.forEach {
            if (!it.validate(prop)) {
                log.warn { "Validate error '$name' - ${it.getMessage(name)}" }
            }
        }

        return if (!minified) {
            val paddedName = StringBuilder()
            paddedName.append(indent)
            paddedName.append(name)
            paddedName.append(":")
            while (paddedName.length < 32) {
                paddedName.append(' ')
            }
            "$paddedName${prop.css()};\n"
        } else {
            "$name:${prop.css()};"
        }
    }

    private fun propertyCss(indent: String, name: String, props: List<*>, minified: Boolean): String {
        val builder = StringBuilder()

        getValidator(name)?.forEach {
            if (!it.validate(props as List<CssProperty>)) {
                log.warn { "Validate error '$name' - ${it.getListMessage(name)}" }
            }
        }

        for ((index, prop) in props.withIndex()) {
            if (prop is CssProperty) {
                getValidator(name)?.forEach {
                    if (!it.validate(prop)) {
                        log.warn { "Validate error '$name' - ${it.getMessage(name)}" }
                    }
                }
                if (builder.isNotEmpty()) {
                    builder.append(",")
                    if (!minified) {
                        builder.append(" ")
                    }
                }
                builder.append(prop.css())
            }
        }

        return if (!minified) {
            val paddedName = StringBuilder()
            paddedName.append(indent)
            paddedName.append(name)
            paddedName.append(":")
            while (paddedName.length < 32) {
                paddedName.append(' ')
            }
            "$paddedName$builder;\n"
        } else {
            "$name:$builder;"
        }
    }

    fun generatePropertyCss(indent: String, minified: Boolean): String {
        val builder = StringBuilder()

        for ((name, prop) in getMapping()) {
            if (prop is List<*> && prop.isNotEmpty()) {
                builder.append(propertyCss(indent, name, prop, minified))
            } else if (prop is CssProperty) {
                builder.append(propertyCss(indent, name, prop, minified))
            }
        }

        return builder.toString()
    }

    open fun generateCss(namespace: String = "", indent: String = "  ", minified: Boolean = false): String {
        val builder = StringBuilder()

        for ((name, prop) in definitions) {
            val css = StringBuilder()

            val finalStyle = Style()

            prop(finalStyle)

            css.append(finalStyle.generatePropertyCss(indent, minified))

            if (css.isNotBlank()) {
                builder.append("\n$namespace $name".trim())
                if (!minified) {
                    builder.append(" ")
                }
                builder.append("{")
                if (!minified) {
                    builder.append("\n")
                }

                finalStyle.fontFace?.let { ff ->
                    if (!minified) {
                        builder.append(indent)
                    }
                    builder.append("@font-face {")
                    if (!minified) {
                        builder.append("\n")
                    }
                    builder.append(ff.generatePropertyCss("  $indent", minified))
                    builder.append(indent)
                    builder.append("}")
                    if (!minified) {
                        builder.append("\n")
                    }
                }

                builder.append(css)
                builder.append("}")
                if (!minified) {
                    builder.append("\n\n")
                }
            }

            builder.append(finalStyle.generateCss( "$namespace $name".trim(), indent, minified))
        }

        return builder.toString()
    }
}

@CssTagMarker
open class Style(
    var alignContent: AlignContent? = null,
    var alignItems: AlignItems? = null,
    var alignSelf: AlignSelf? = null,
    var all: All? = null,
    var animation: TextProperty? = null,
    var animationDelay: List<DelayDuration>? = null,
    var animationDirection: List<AnimationDirection>? = null,
    var animationDuration: List<DelayDuration>? = null,
    var animationFillMode: List<AnimationFillMode>? = null,
    var animationIterationCount: List<Count>? = null,
    var animationFrame: AnimationFrame? = null,
    var animationName: List<TextProperty>? = null,
    var animationPlayState: List<AnimationPlayState>? = null,
    var animationTimingFunction: List<AnimationTimingFunction>? = null,
    var backfaceVisibility: BackfaceVisibility? = null,
    var background: TextProperty? = null,
    var backgroundAttachment: BackgroundAttachment? = null,
    var backgroundBlendMode: BackgroundBlendMode? = null,
    var backgroundClip: ClipOrigin? = null,
    var backgroundColor: Color? = null,
    var backgroundImage: Image? = null,
    var backgroundOrigin: ClipOrigin? = null,
    var backgroundPosition: List<BackgroundPosition>? = null,
    var backgroundRepeat: List<BackgroundRepeat>? = null,
    var backgroundSize: List<BackgroundSize>? = null,
    var border: TextProperty? = null,
    var borderBottom: TextProperty? = null,
    var borderBottomColor: Color? = null,
    var borderBottomLeftRadius: List<BorderRadius>? = null,
    var borderBottomRightRadius: List<BorderRadius>? = null,
    var borderBottomStyle: RuleBorderStyle? = null,
    var borderBottomWidth: BorderWidth? = null,
    var borderCollapse: BorderCollapse? = null,
    var borderColor: List<Color>? = null,
    var borderImage: TextProperty? = null,
    var borderImageOutset: Length? = null,
    var borderImageRepeat: List<ImageRepeat>? = null,
    var borderImageSlice: List<ImageSlice>? = null,
    var borderImageSource: List<ImageSource>? = null,
    var borderImageWidth: List<BorderImageWidth>? = null,
    var borderLeft: TextProperty? = null,
    var borderLeftColor: Color? = null,
    var borderLeftStyle: RuleBorderStyle? = null,
    var borderLeftWidth: BorderWidth? = null,
    var borderRadius: BorderRadius? = null,
    var borderRight: TextProperty? = null,
    var borderRightColor: Color? = null,
    var borderRightStyle: RuleBorderStyle? = null,
    var borderRightWidth: BorderWidth? = null,
    var borderSpacing: List<BorderSpacing>? = null,
    var borderStyle: List<RuleBorderStyle>? = null,
    var borderTop: TextProperty? = null,
    var borderTopColor: Color? = null,
    var borderTopLeftRadius: BorderRadius? = null,
    var borderTopRightRadius: BorderRadius? = null,
    var borderTopStyle: RuleBorderStyle? = null,
    var borderTopWidth: BorderWidth? = null,
    var bottom: Measurement? = null,
    var boxDecorationBreak: BoxDecorationBreak? = null,
    var boxShadow: BoxShadow? = null,
    var boxSizing: BoxSizing? = null,
    var breakAfter: Break? = null,
    var breakBefore: Break? = null,
    var breakInside: Break? = null,
    var captionSide: CaptionSide? = null,
    var caretColor: Color? = null,
    //var charset: TextProperty? = null,
    var clear: Clear? = null,
    var clip: Clip? = null,
    var clipPath: ClipPath? = null,
    var columnCount: Count? = null,
    var columnFill: Fill? = null,
    var columnGap: Measurement? = null,
    var columnRule: TextProperty? = null,
    var columnRuleColor: Color? = null,
    var columnRuleStyle: RuleBorderStyle? = null,
    var columnRuleWidth: Measurement? = null,
    var columnSpan: Span? = null,
    var columnWidth: Measurement? = null,
    var columns: TextProperty? = null,
    var content: Content? = null,
    var counterIncrement: TextProperty? = null,
    var counterReset: TextProperty? = null,
    var cursor: TextProperty? = null,
    var direction: Direction? = null,
    var display: Display? = null,
    var emptyCells: EmptyCells? = null,
    var filter: TextProperty? = null,
    var flex: TextProperty? = null,
    var flexBasis: Measurement? = null,
    var flexDirection: FlexDirection? = null,
    var flexFlow: TextProperty? = null,
    var flexGrow: FlexGrowShrink? = null,
    var flexShrink: FlexGrowShrink? = null,
    var flexWrap: FlexWrap? = null,
    var float: Float? = null,
    var font: TextProperty? = null,

    var color: Color? = null,
    var fontFamily: TextProperty? = null,
    var fontSize: FontSize? = null,
    var height: Measurement? = null,
    var left: Measurement? = null,
    var top: Measurement? = null,
    var transitionDelay: DelayDuration? = null,
    var transitionDuration: DelayDuration? = null,
    var width: Measurement? = null
) : CssGenerator() {
    var fontFace: FontFace? = null
    private val validators = mapOf<String, List<Validator>>(
        "background-position" to listOf(InitialInheritSingleValue()),
        "background-size" to listOf(MaxCountValidator(2)),
        "border-radius" to listOf(
            MaxCountValidator(4),
            InitialInheritSingleValue()
        ),
        "animation-timing-function" to listOf(MaxCountValidator(4)),
        "border-image-repeat" to listOf(MaxCountValidator(2)),
        "border-image-slice" to listOf(MaxCountValidator(4)),
        "border-spacing" to listOf(MaxCountValidator(4)),
        "border-style" to listOf(MaxCountValidator(4))
    )

    override fun getValidator(name: String) = validators[name]

    override fun getMapping(): Map<String, Any?> = mapOf(
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
        "animation-frame" to animationFrame,
        "animation-name" to animationName,
        "animation-play-state" to animationPlayState,
        "animation-timing-function" to animationTimingFunction,
        "backface-visibility" to backfaceVisibility,
        "background" to background,
        "background-attachment" to backgroundAttachment,
        "background-blend-mode" to backgroundBlendMode,
        "background-clip" to backgroundClip,
        "background-color" to backgroundColor,
        "background-image" to backgroundImage,
        "background-origin" to backgroundOrigin,
        "background-position" to backgroundPosition,
        "background-repeat" to backgroundRepeat,
        "background-size" to backgroundSize,
        "border" to border,
        "border-bottom" to borderBottom,
        "border-bottom-color" to borderBottomColor,
        "border-bottom-left-radius" to borderBottomLeftRadius,
        "border-bottom-right-radius" to borderBottomRightRadius,
        "border-bottom-style" to borderBottomStyle,
        "border-bottom-width" to borderBottomWidth,
        "border-collapse" to borderCollapse,
        "border-color" to borderColor,
        "border-image" to borderImage,
        "border-image-outset" to borderImageOutset,
        "border-image-repeat" to borderImageRepeat,
        "border-image-slice" to borderImageSlice,
        "border-image-source" to borderImageSource,
        "border-image-width" to borderImageWidth,
        "border-left" to borderLeft,
        "border-left-color" to borderLeftColor,
        "border-left-style" to borderLeftStyle,
        "border-left-width" to borderLeftWidth,
        "border-radius" to borderRadius,
        "border-right" to borderRight,
        "border-right-color" to borderRightColor,
        "border-right-style" to borderRightStyle,
        "border-right-width" to borderRightWidth,
        "border-spacing" to borderSpacing,
        "border-style" to borderStyle,
        "border-top" to borderTop,
        "border-top-color" to borderTopColor,
        "border-top-left-radius" to borderTopLeftRadius,
        "border-top-right-radius" to borderTopRightRadius,
        "border-top-style" to borderTopStyle,
        "border-top-width" to borderTopWidth,
        "bottom" to bottom,
        "box-decoration-break" to boxDecorationBreak,
        "box-shadow" to boxShadow,
        "box-sizing" to boxSizing,
        "break-after" to breakAfter,
        "break-before" to breakBefore,
        "break-inside" to breakInside,
        "caption-side" to captionSide,
        "caret-color" to caretColor,
        //"@charset" to charset,
        "clear" to clear,
        "clip" to clip,
        "clip-path" to clipPath,
        "color" to color,
        "column-count" to columnCount,
        "column-fill" to columnFill,
        "column-gap" to columnGap,
        "column-rule" to columnRule,
        "column-rule-color" to columnRuleColor,
        "column-rule-style" to columnRuleStyle,
        "column-rule-width" to columnRuleWidth,
        "column-span" to columnSpan,
        "column-width" to columnWidth,
        "columns" to columns,
        "content" to content,
        "counter-increment" to counterIncrement,
        "counter-reset" to counterReset,
        "cursor" to cursor,
        "direction" to direction,
        "display" to display,
        "empty-cells" to emptyCells,
        "filter" to filter,
        "flex" to flex,
        "float" to float,
        "font" to font,


        "font-family" to fontFamily,
        "font-size" to fontSize,
        "height" to height,
        "left" to left,
        "top" to top,
        "transition-delay" to transitionDelay,
        "transition-duration" to transitionDuration,
        "width" to width
    )

    fun select(selector: String, style: Css) {
        definitions[selector] = style
    }

    fun apply(style: Css) {
        style(this)
    }

    fun fontFace(face: FontFace.() -> Unit) {
        fontFace = FontFace()

        face.invoke(fontFace!!)
    }
}
