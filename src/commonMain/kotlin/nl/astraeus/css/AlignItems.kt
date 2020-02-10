package nl.astraeus.css

enum class AlignItems(
    val value: String
) : CssProperty {
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
