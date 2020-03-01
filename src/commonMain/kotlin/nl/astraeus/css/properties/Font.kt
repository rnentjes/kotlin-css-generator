package nl.astraeus.css.properties

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

class FontStretch(
    value: String
) : CssProperty(value) {

    companion object {
        fun normal() = FontStretch("normal")
        fun condensed() = FontStretch("condensed")
        fun ultraCondensed() = FontStretch("ultra-condensed")
        fun extraCondensed() = FontStretch("extra-condensed")
        fun semiCondensed() = FontStretch("semi-condensed")
        fun expanded() = FontStretch("expanded")
        fun semiExpanded() = FontStretch("semi-expanded")
        fun extraExpanded() = FontStretch("extra-expanded")
        fun ultraExpanded() = FontStretch("ultra-expanded")
    }

}

class FontStyle(
    value: String
) : CssProperty(value) {

    companion object {
        fun normal() = FontStyle("normal")
        fun italic() = FontStyle("italic")
        fun oblique() = FontStyle("oblique")
    }

}

class FontWeight(
    value: String
) : CssProperty(value) {

    companion object {
        fun normal() = FontWeight("normal")
        fun bold() = FontWeight("bold")
        fun _100() = FontWeight("100")
        fun _200() = FontWeight("200")
        fun _300() = FontWeight("300")
        fun _400() = FontWeight("400")
        fun _500() = FontWeight("500")
        fun _600() = FontWeight("600")
        fun _700() = FontWeight("700")
        fun _800() = FontWeight("800")
        fun _900() = FontWeight("900")
    }

}

