package nl.astraeus.css.properties

class FontSize(
    value: String
) : CssProperty(value) {

    companion object {
        val xxSmall = FontSize("xx-small")
        val xSmall = FontSize("x-small")
        val small = FontSize("small")
        val medium = FontSize("medium")
        val large = FontSize("large")
        val xLarge = FontSize("x-large")
        val xxLarge = FontSize("xx-large")
        val smaller = FontSize("smaller")
        val larger = FontSize("larger")
        val initial = FontSize("initial")
        val inherit = FontSize("inherit")

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
        val normal = FontStretch("normal")
        val condensed = FontStretch("condensed")
        val ultraCondensed = FontStretch("ultra-condensed")
        val extraCondensed = FontStretch("extra-condensed")
        val semiCondensed = FontStretch("semi-condensed")
        val expanded = FontStretch("expanded")
        val semiExpanded = FontStretch("semi-expanded")
        val extraExpanded = FontStretch("extra-expanded")
        val ultraExpanded = FontStretch("ultra-expanded")
        val initial = FontWeight("initial")
        val inherit = FontWeight("inherit")
    }

}

class FontStyle(
    value: String
) : CssProperty(value) {

    companion object {
        val normal = FontStyle("normal")
        val italic = FontStyle("italic")
        val oblique = FontStyle("oblique")
        val initial = FontStyle("initial")
        val inherit = FontStyle("inherit")
    }

}

class FontWeight(
    value: String
) : CssProperty(value) {

    companion object {
        val normal = FontWeight("normal")
        val bold = FontWeight("bold")
        val _100 = FontWeight("100")
        val _200 = FontWeight("200")
        val _300 = FontWeight("300")
        val _400 = FontWeight("400")
        val _500 = FontWeight("500")
        val _600 = FontWeight("600")
        val _700 = FontWeight("700")
        val _800 = FontWeight("800")
        val _900 = FontWeight("900")
        val initial = FontWeight("initial")
        val inherit = FontWeight("inherit")
    }

}

class FontKerning(
    value: String
) : CssProperty(value) {

    companion object {
        val auto = FontKerning("auto")
        val normal = FontKerning("normal")
        val none = FontKerning("none")
    }

}

class FontSizeAdjust(
    value: String
) : CssProperty(value) {

    companion object {
        val none = FontSizeAdjust("none")
        val initial = FontSizeAdjust("initial")
        val inherit = FontSizeAdjust("inherit")
    }

}

class FontVariant(
    value: String
) : CssProperty(value) {

    companion object {
        val normal = FontVariant("normal")
        val smallCaps = FontVariant("small-caps")
        val initial = FontVariant("initial")
        val inherit = FontVariant("inherit")
    }

}

class FontVariantCaps(
    value: String
) : CssProperty(value) {

    companion object {
        val normal = FontVariantCaps("normal")
        val smallCaps = FontVariantCaps("small-caps")
        val allSmallCaps = FontVariantCaps("all-small-caps")
        val petiteCaps = FontVariantCaps("petite-caps")
        val allPetiteCaps = FontVariantCaps("all-petite-caps")
        val unicase = FontVariantCaps("unicase")
        val initial = FontVariantCaps("initial")
        val inherit = FontVariantCaps("inherit")
        val unset = FontVariantCaps("unset")
    }

}
