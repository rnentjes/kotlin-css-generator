package nl.astraeus.css.properties

open class Measurement(
    value: String
) : CssProperty(value) {

    companion object {
        fun auto() = Measurement("auto")
        fun initial() = Measurement("initial")
        fun inherit() = Measurement("inherit")
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

class FontSize(
    value: String
) : CssProperty(value) {

    companion object {
        fun xxSmall() = FontSize("xx-small")
        fun xSmall() = FontSize("x-small")
        fun small() = FontSize("small")
        fun medium() = FontSize("medium")
        fun large() = FontSize("large")
        fun xLarge() = FontSize("x-large")
        fun xxLarge() = FontSize("xx-large")
        fun smaller() = FontSize("smaller")
        fun larger() = FontSize("larger")
        fun initial() = FontSize("initial")
        fun inherit() = FontSize("inherit")
        fun px(nr: Int) = FontSize("${nr}px")
        fun em(nr: Int) = FontSize("${nr}em")
        fun em(nr: Double) = FontSize("${nr}em")
        fun perc(nr: Int) = FontSize("${nr}%")
        fun perc(nr: Double) = FontSize("${nr}%")
        fun pc(nr: Int) = FontSize("${nr}pc")
        fun pc(nr: Double) = FontSize("${nr}pc")
        fun cm(nr: Int) = FontSize("${nr}cm")
        fun cm(nr: Double) = FontSize("${nr}cm")
    }
}
