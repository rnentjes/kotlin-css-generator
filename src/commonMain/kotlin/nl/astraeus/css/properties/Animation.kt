package nl.astraeus.css.properties

class AnimationDirection(
    value: String
) : CssProperty(value) {

    companion object {
        val normal = AnimationDirection("normal")
        val reverse = AnimationDirection("reverse")
        val alternate = AnimationDirection("alternate")
        val alternateReverse = AnimationDirection("alternate-reverse")
        val initial = AnimationDirection("initial")
        val inherit = AnimationDirection("inherit")
    }
}

class AnimationFillMode(
    value: String
) : CssProperty(value) {

    companion object {
        val none = AnimationFillMode("none")
        val forwards = AnimationFillMode("forwards")
        val backwards = AnimationFillMode("backwards")
        val both = AnimationFillMode("both")
        val initial = AnimationFillMode("initial")
        val inherit = AnimationFillMode("inherit")
    }
}

class AnimationFrame(
    value: String = ""
): CssProperty(value) {

    companion object {
        fun name(name: String) = AnimationFrame(name)
        val none: AnimationFrame = AnimationFrame("none")
        val initial: AnimationFrame = AnimationFrame("initial")
        val inherit: AnimationFrame = AnimationFrame("inherit")
    }
}


class AnimationPlayState(
    value: String
) : CssProperty(value) {

    companion object {
        fun name(name: String) = AnimationPlayState(name)
        val paused = AnimationPlayState("paused")
        val running = AnimationPlayState("running")
        val initial = AnimationPlayState("initial")
        val inherit = AnimationPlayState("inherit")
    }
}
