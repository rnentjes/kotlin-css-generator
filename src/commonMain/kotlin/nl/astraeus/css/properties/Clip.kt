package nl.astraeus.css.properties

class Clip(
    value: String
) : CssProperty(value) {

    companion object {
        fun rect(top: Int, right: Int, bottom: Int, left: Int) = Clip("rect(${top}px,${right}px,${bottom}px,${left}px)")
        val auto = Clip("auto")
        val initial = Clip("initial")
        val inherit = Clip("inherit")

    }
}

class ClipPath(
    value: String
) : CssProperty(value) {

    companion object {
        val auto = ClipPath("auto")
        fun circle(perc: Double) = ClipPath("circle(${perc}%)")
        fun ellipse(radiusX: Double, radiusY: Double) = ClipPath("ellipse(${radiusX}%,${radiusY}%)")
        fun ellipse(
            radiusX: Double,
            radiusY: Double,
            positionX: Double,
            positionY: Double
        ) = ClipPath("ellipse(${radiusX}%,${radiusY}% at ${positionX}%,${positionY}%)")

        // todo: other options
        fun other(text: String) = ClipPath(text)

        val marginBox = ClipPath("margin-box")
        val borderBox = ClipPath("border-box")
        val paddingBox = ClipPath("padding-box")
        val contentBox = ClipPath("content-box")
        val fillBox = ClipPath("fill-box")
        val strokeBox = ClipPath("stroke-box")
        val viewBox = ClipPath("view-box")
        val none = ClipPath("none")
    }
}

class ClipOrigin(
    value: String
) : CssProperty(value) {

    companion object {
        val borderBox = ClipOrigin("border-box")
        val paddingBox = ClipOrigin("padding-box")
        val contentBox = ClipOrigin("content-box")
        val initial = ClipOrigin("initial")
        val inherit = ClipOrigin("inherit")

    }
}
