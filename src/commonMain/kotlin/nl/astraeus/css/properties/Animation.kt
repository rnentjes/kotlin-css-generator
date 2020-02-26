package nl.astraeus.css.properties

class AnimationDirection(
    value: String
) : CssProperty(value) {

    companion object {
        fun normal() = AnimationDirection("normal")
        fun reverse() = AnimationDirection("reverse")
        fun alternate() = AnimationDirection("alternate")
        fun alternateReverse() = AnimationDirection("alternate-reverse")
        fun initial() = AnimationDirection("initial")
        fun inherit() = AnimationDirection("inherit")
    }
}

class AnimationFillMode(
    value: String
) : CssProperty(value) {

    companion object {
        fun none() = AnimationFillMode("none")
        fun forwards() = AnimationFillMode("forwards")
        fun backwards() = AnimationFillMode("backwards")
        fun both() = AnimationFillMode("both")
        fun initial() = AnimationFillMode("initial")
        fun inherit() = AnimationFillMode("inherit")
    }
}

class AnimationFrame(
    value: String = ""
): CssProperty(value) {

    companion object {
        fun name(name: String): AnimationFrame = AnimationFrame(name)
        fun none(): AnimationFrame = AnimationFrame("none")
        fun initial(): AnimationFrame = AnimationFrame("initial")
        fun inherit(): AnimationFrame = AnimationFrame("inherit")
    }
}


class AnimationPlayState(
    value: String
) : CssProperty(value) {

    companion object {
        fun name(name: String) = AnimationPlayState(name)
        fun paused() = AnimationPlayState("paused")
        fun running() = AnimationPlayState("running")
        fun initial() = AnimationPlayState("initial")
        fun inherit() = AnimationPlayState("inherit")
    }
}

class AnimationTimingFunction(
    value: String = ""
) : CssProperty(value) {

    companion object {
        fun linear() = AnimationTimingFunction("linear")
        fun ease() = AnimationTimingFunction("ease")
        fun easeIn() = AnimationTimingFunction("ease-in")
        fun easeOut() = AnimationTimingFunction("ease-out")
        fun easeInOut() = AnimationTimingFunction("ease-in-out")
        fun cubicBezier(
            n1: Double,
            n2: Double,
            n3: Double,
            n4: Double
        ) = AnimationTimingFunction("cubic-bezier($n1,$n2,$n3,$n4)")
        fun initial() = AnimationTimingFunction("initial")
        fun inherit() = AnimationTimingFunction("inherit")

    }
}
