package nl.astraeus.css.properties

class BackgroundAttachment(
    value: String
) : CssProperty(value) {

    companion object {
        val scroll = BackgroundAttachment("scroll")
        val fixed = BackgroundAttachment("fixed")
        val local = BackgroundAttachment("local")
        val initial = BackgroundAttachment("initial")
        val inherit = BackgroundAttachment("inherit")
    }
}

class BackgroundBlendMode(
    value: String
) : CssProperty(value) {

    companion object {
        val normal = BackgroundBlendMode("normal")
        val multiply = BackgroundBlendMode("multiply")
        val screen = BackgroundBlendMode("screen")
        val overlay = BackgroundBlendMode("overlay")
        val darken = BackgroundBlendMode("darken")
        val lighten = BackgroundBlendMode("lighten")
        val colorDodge = BackgroundBlendMode("color-dodge")
        val saturation = BackgroundBlendMode("saturation")
        val color = BackgroundBlendMode("color")
        val luminosity = BackgroundBlendMode("luminosity")
    }
}

class BackgroundPosition(
    value: String
) : CssProperty(value) {

    companion object {
        val left = BackgroundPosition("left")
        val center = BackgroundPosition("center")
        val right = BackgroundPosition("right")
        val initial = BackgroundPosition("initial")
        val inherit = BackgroundPosition("inherit")
    }
}

class BackgroundRepeat(
    value: String
) : CssProperty(value) {

    companion object {
        val repeat = BackgroundRepeat("repeat")
        val repeatX = BackgroundRepeat("repeat-x")
        val repeatY = BackgroundRepeat("repeat-y")
        val noRepeat = BackgroundRepeat("no-repeat")
        val space = BackgroundRepeat("space")
        val round = BackgroundRepeat("round")
        val initial = BackgroundRepeat("initial")
        val inherit = BackgroundRepeat("inherit")
        val unset = BackgroundRepeat("unset")
    }
}

class BackgroundSize(
    value: String
) : CssProperty(value) {

    companion object {
        fun px(px: Int) = BackgroundSize("${px}px")
        fun perc(pc: Double) = BackgroundSize("${pc}%")

        val auto = BackgroundSize("auto")
        val cover = BackgroundSize("cover")
        val contain = BackgroundSize("contain")
        val initial = BackgroundSize("initial")
        val inherit = BackgroundSize("inherit")
    }
}

