package nl.astraeus.css.properties

open class Measurement(
    value: String
) : CssProperty(value) {

    companion object {
        val auto = Measurement("auto")
        val initial = Measurement("initial")
        val inherit = Measurement("inherit")
        val normal = Measurement("normal")

        fun px(nr: Int) = if (nr == 0) { Measurement("0") } else { Measurement("${nr}px") }
        fun px(nr: Double) = nr.px
        fun em(nr: Int) = nr.em
        fun em(nr: Double) = nr.em
        fun prc(nr: Int) = nr.prc
        fun prc(nr: Double) = nr.prc
        fun pc(nr: Int) = nr.pc
        fun pc(nr: Double) = nr.pc
        fun cm(nr: Int) = nr.cm
        fun cm(nr: Double) = nr.cm
    }
}

val Int.px: Measurement
    get() = Measurement("${this}${if (this == 0) { "" } else { "px"}}")
val Int.em: Measurement
    get() = Measurement("${this}${if (this == 0) { "" } else { "em"}}")
val Int.rem: Measurement
    get() = Measurement("${this}${if (this == 0) { "" } else { "rem"}}")
val Int.prc: Measurement
    get() = Measurement("${this}%")
val Int.pc: Measurement
    get() = Measurement("${this}pc")
val Int.cm: Measurement
    get() = Measurement("${this}cm")
fun Int.px(): Measurement = Measurement.px(this)

val Double.px: Measurement
    get() = Measurement("${this}px")
val Double.em: Measurement
    get() = Measurement("${this}em")
val Double.rem: Measurement
    get() = Measurement("${this}rem")
val Double.prc: Measurement
    get() = Measurement("${this}%")
val Double.pc: Measurement
    get() = Measurement("${this}pc")
val Double.cm: Measurement
    get() = Measurement("${this}cm")
fun Double.px(): Measurement = Measurement.px(this)

open class LineHeight(value: String) : CssProperty(value) {
    companion object {
        val normal = LineHeight("normal")
        val initial = LineHeight("initial")
        val inherit = LineHeight("inherit")
    }
}
