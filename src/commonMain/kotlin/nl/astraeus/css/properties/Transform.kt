package nl.astraeus.css.properties

class Transform(
    value: String
) : CssProperty(value) {

    companion object {
        val none = Transform("none")
        val initial = Transform("initial")
        val inherit = Transform("inherit")

        fun matrix(
            n1: Double,
            n2: Double,
            n3: Double,
            n4: Double,
            n5: Double,
            n6: Double
        ) = Transform("matrix($n1, $n2, $n3, $n4, $n5, $n6)")
        fun matrix3d(
            n01: Double, n02: Double, n03: Double, n04: Double,
            n05: Double, n06: Double, n07: Double, n08: Double,
            n09: Double, n10: Double, n11: Double, n12: Double,
            n13: Double, n14: Double, n15: Double, n16: Double
        ) = Transform(
            "matrix3d($n01, $n02, $n03, $n04, $n05, $n06, $n07, $n08, $n09, $n10, $n11, $n12, $n13, $n14, $n15, $n16)"
        )
        fun translate(x: Double, y: Double) = Transform("translate($x, $y)")
        fun translate3d(x: Double, y: Double, z: Double) = Transform("translate3d($x, $y, $z)")
        fun translateX(x: Double) = Transform("translateX($x)")
        fun translateY(y: Double) = Transform("translateY($y)")
        fun translateZ(z: Double) = Transform("translateZ($z)")
        fun scale(x: Double, y: Double) = Transform("scale($x, $y)")
        fun scale3d(x: Double, y: Double, z: Double) = Transform("scale3d($x, $y, $z)")
        fun scaleX(x: Double) = Transform("scaleX($x)")
        fun scaleY(y: Double) = Transform("scaleY($y)")
        fun scaleZ(z: Double) = Transform("scaleZ($z)")
        fun rotate(angle: Double) = Transform("rotate($angle)")
        fun rotate3d(x: Double, y: Double, z: Double, angle: Double) = Transform("scale3d($x, $y, $z, $angle")
        fun rotateX(x: Double) = Transform("rotateX($x)")
        fun rotateY(y: Double) = Transform("rotateY($y)")
        fun rotateZ(z: Double) = Transform("rotateZ($z)")
        fun skew(x: Double, y: Double) = Transform("skew($x, $y)")
        fun skewX(x: Double) = Transform("skew($x)")
        fun skewY(y: Double) = Transform("skew($y)")
        fun perspective(length: Measurement) = Transform("perspective(${length.css()})")
    }

}
