package nl.astraeus.css.properties

open class Measurement(
    value: String
) : CssProperty(value) {

    companion object {
        fun auto() = Measurement("auto")
        fun initial() = Measurement("initial")
        fun inherit() = Measurement("inherit")
        fun normal() = Measurement("normal")
        fun px(nr: Int) = Measurement("${nr}px")
        fun em(nr: Int) = Measurement("${nr}em")
        fun em(nr: Double) = Measurement("${nr}em")
        fun perc(nr: Int) = Measurement("${nr}%")
        fun perc(nr: Double) = Measurement("${nr}%")
        fun pc(nr: Int) = Measurement("${nr}pc")
        fun pc(nr: Double) = Measurement("${nr}pc")
        fun cm(nr: Int) = Measurement("${nr}cm")
        fun cm(nr: Double) = Measurement("${nr}cm")
    }
}
