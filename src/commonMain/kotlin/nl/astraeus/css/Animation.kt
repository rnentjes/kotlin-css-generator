package nl.astraeus.css

enum class AnimationDirection(
    val value: String
) : CssProperty {
    NORMAL("normal"),
    REVERSE("reverse"),
    ALTERNATE("alternate"),
    ALTERNATE_REVERSE("alternate-reverse"),
    INITIAL("initial"),
    INHERIT("inherit"),
    ;

    override fun css(): String = value
}

enum class AnimationFillMode(
    val value: String
) : CssProperty {
    NONE("none"),
    FORWARDS("forwards"),
    BACKWARDS("backwards"),
    BOTH("both"),
    INITIAL("initial"),
    INHERIT("inherit"),
    ;

    override fun css(): String = value
}
