package nl.astraeus.css.properties

class Clip(
    value: String
) : CssProperty(value) {

    companion object {
        fun auto() = Clip("auto")
        fun rect(top: Int, right: Int, bottom: Int, left: Int) = Clip("rect(${top}px,${right}px,${bottom}px,${left}px)")
        fun initial() = Clip("initial")
        fun inherit() = Clip("inherit")

    }
}

class ClipPath(
    value: String
) : CssProperty(value) {

    companion object {
        fun auto() = ClipPath("auto")
        fun circle(perc: Double) = ClipPath("circle(${perc}%)")
        fun ellipse(radiusX: Double, radiusY: Double) = ClipPath("ellipse(${radiusX}%,${radiusY}%)")
        fun ellipse(
            radiusX: Double,
            radiusY: Double,
            positionX: Double,
            positionY: Double
        ) = ClipPath("ellipse(${radiusX}%,${radiusY}% at ${positionX}%,${positionY}%)")
        // todo: other options
        fun marginBox() = ClipPath("margin-box")
        fun borderBox() = ClipPath("border-box")
        fun paddingBox() = ClipPath("padding-box")
        fun contentBox() = ClipPath("content-box")
        fun fillBox() = ClipPath("fill-box")
        fun strokeBox() = ClipPath("stroke-box")
        fun viewBox() = ClipPath("view-box")
        fun none() = ClipPath("none")
    }
}

class ClipOrigin(
    value: String
) : CssProperty(value) {

    companion object {
        fun borderBox() = ClipOrigin("border-box")
        fun paddingBox() = ClipOrigin("padding-box")
        fun contentBox() = ClipOrigin("content-box")
        fun initial() = ClipOrigin("initial")
        fun inherit() = ClipOrigin("inherit")

    }
}
