package nl.astraeus.css

enum class AlignContent(
    val value: String
) : CssProperty {
    STRETCH("stretch"),
    CENTER("center"),
    FLEX_START("flex-start"),
    FLEX_END("flex-end"),
    SPACE_BETWEEN("space-between"),
    SPACE_AROUND("space-around"),
    INITIAL("initial"),
    INHERIT("inherit"),
    ;

    override fun css(): String = value
}
