package nl.astraeus.css.style

import nl.astraeus.css.properties.*

@DslMarker
annotation class CssTagMarker

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
    var backgroundClip: BackgroundClip? = null,
    var backgroundColor: Color? = null,
    var backgroundImage: Image? = null,
    var backgroundOrigin: BackgroundOrigin? = null,
    var backgroundPosition: List<BackgroundPosition>? = null,
    var backgroundRepeat: List<BackgroundRepeat>? = null,
    var backgroundSize: List<BackgroundSize>? = null,
    var border: TextProperty? = null,
    var borderBottom: TextProperty? = null,
    var borderColor: Color? = null,
    var borderBottomColor: Color? = null,
    var borderBottomLeftRadius: List<BorderRadius>? = null,
    var borderBottomRightRadius: List<BorderRadius>? = null,
    var borderBottomStyle: BorderStyle? = null,
    var borderBottomWidth: BorderWidth? = null,
    var borderLeft: TextProperty? = null,
    var borderLeftColor: Color? = null,
    var borderRadius: List<BorderRadius>? = null,
    var borderRight: TextProperty? = null,
    var borderRightColor: Color? = null,
    var borderTop: TextProperty? = null,
    var borderTopColor: Color? = null,
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
        "border-color" to borderColor,
        "border-left" to borderLeft,
        "border-left-color" to borderLeftColor,
        "border-right" to borderRight,
        "border-right-color" to borderRightColor,
        "border-top" to borderTop,
        "border-top-color" to borderTopColor,
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

    fun propertyCss(indent: String, name: String, prop: CssProperty): String {
        prop.validate()

        return "$indent$name: ${prop.css()};\n"
    }

    fun propertyCss(indent: String, name: String, props: List<*>): String {
        val builder = StringBuilder()

        for ((index, prop) in props.withIndex()) {
            if (prop is CssProperty) {
                if (index == 0) {
                    prop.validateMultiple(props)
                }
                if (builder.isNotEmpty()) {
                    builder.append(", ")
                }
                builder.append(prop.css())
            }
        }

        return "$indent$name: $builder;\n"
    }

    fun generatePropertyCss(indent: String): String {
        val builder = StringBuilder()

        for ((name, prop) in getMapping()) {
            if (prop is List<*> && prop.isNotEmpty()) {
                builder.append(propertyCss(indent, name, prop))
            } else if (prop is CssProperty) {
                builder.append(propertyCss(indent, name, prop))
            }
        }

        return builder.toString()
    }

}
