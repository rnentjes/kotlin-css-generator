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

class BackgroundClip(
    value: String
) : CssProperty(value) {

    companion object {
        fun borderBox() = BackgroundClip("border-box")
        fun paddingBox() = BackgroundClip("padding-box")
        fun contentBox() = BackgroundClip("content-box")
        fun initial() = BackgroundClip("initial")
        fun inherit() = BackgroundClip("inherit")

    }
}

class BackgroundOrigin(
    value: String
) : CssProperty(value) {

    companion object {
        fun borderBox() = BackgroundOrigin("border-box")
        fun paddingBox() = BackgroundOrigin("padding-box")
        fun contentBox() = BackgroundOrigin("content-box")
        fun initial() = BackgroundOrigin("initial")
        fun inherit() = BackgroundOrigin("inherit")

    }
}

class BackgroundPosition(
    value: String
) : CssProperty(value) {

    override fun validateMultiple(props: List<*>) {
        for (prop in props) {
            if (prop is CssProperty) {
                if (prop.css() == "initial" || prop.css() == "inherit") {
                    check(props.size == 1) {
                        "'background-position' can only have single value when 'initial' or 'inherit'"
                    }
                }
            }
        }
    }

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

    override fun validateMultiple(props: List<*>) {
        check(props.size <= 2) {
            "'background-size' can not have more than 2 values"
        }
    }

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

