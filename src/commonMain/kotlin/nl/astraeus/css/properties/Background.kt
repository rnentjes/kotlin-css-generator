package nl.astraeus.css.properties

class BackgroundAttachment(
    value: String
) : CssProperty(value) {

    companion object {
        fun scroll() = BackgroundAttachment("scroll")
        fun fixed() = BackgroundAttachment("fixed")
        fun local() = BackgroundAttachment("local")
        fun initial() = BackgroundAttachment("initial")
        fun inherit() = BackgroundAttachment("inherit")
    }
}

class BackgroundBlendMode(
    value: String
) : CssProperty(value) {

    companion object {
        fun normal() = BackgroundBlendMode("normal")
        fun multiply() = BackgroundBlendMode("multiply")
        fun screen() = BackgroundBlendMode("screen")
        fun overlay() = BackgroundBlendMode("overlay")
        fun darken() = BackgroundBlendMode("darken")
        fun lighten() = BackgroundBlendMode("lighten")
        fun colorDodge() = BackgroundBlendMode("color-dodge")
        fun saturation() = BackgroundBlendMode("saturation")
        fun color() = BackgroundBlendMode("color")
        fun luminosity() = BackgroundBlendMode("luminosity")
    }
}

class BackgroundPosition(
    value: String
) : CssProperty(value) {

    companion object {
        fun left() = BackgroundPosition("left")
        fun center() = BackgroundPosition("center")
        fun right() = BackgroundPosition("right")
        fun initial() = BackgroundPosition("initial")
        fun inherit() = BackgroundPosition("inherit")

    }
}

class BackgroundRepeat(
    value: String
) : CssProperty(value) {

    companion object {
        fun repeat() = BackgroundRepeat("repeat")
        fun repeatX() = BackgroundRepeat("repeat-x")
        fun repeatY() = BackgroundRepeat("repeat-y")
        fun noRepeat() = BackgroundRepeat("no-repeat")
        fun space() = BackgroundRepeat("space")
        fun round() = BackgroundRepeat("round")
        fun initial() = BackgroundRepeat("initial")
        fun inherit() = BackgroundRepeat("inherit")
        fun unset() = BackgroundRepeat("unset")
    }
}

class BackgroundSize(
    value: String
) : CssProperty(value) {

    companion object {
        fun px(px: Int) = BackgroundSize("${px}px")
        fun perc(pc: Double) = BackgroundSize("${pc}%")
        fun auto() = BackgroundSize("auto")
        fun cover() = BackgroundSize("cover")
        fun contain() = BackgroundSize("contain")
        fun initial() = BackgroundSize("initial")
        fun inherit() = BackgroundSize("inherit")
    }
}

