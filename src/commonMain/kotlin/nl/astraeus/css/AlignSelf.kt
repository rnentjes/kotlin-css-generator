package nl.astraeus.css

enum class AlignSelf(
    val value: String
) : CssProperty {
    AUTO("auto"),
    STRETCH("stretch"),
    CENTER("center"),
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    BASELINE("baseline"),
    INITIAL("initial"),
    INHERIT("inherit"),
    ;

    override fun css(): String = value
}
