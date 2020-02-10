package nl.astraeus.css

enum class All(
    val value: String
) : CssProperty {
    INITIAL("initial"),
    INHERIT("inherit"),
    UNSET("unset"),
    ;

    override fun css(): String = value
}
