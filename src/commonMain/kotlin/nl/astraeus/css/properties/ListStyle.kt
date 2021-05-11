package nl.astraeus.css.properties


class ListStylePosition(
    value: String
) : CssProperty(value) {

    companion object {
        val inside = ListStylePosition("inside")
        val outside = ListStylePosition("outside")
        val initial = ListStylePosition("initial")
        val inherit = ListStylePosition("inherit")
    }

}

class ListStyleType(
    value: String
) : CssProperty(value) {

    companion object {
        val disc = ListStyleType("disc")
        val armenian = ListStyleType("armenian")
        val circle = ListStyleType("circle")
        val cjkIdeographic = ListStyleType("cjk-ideographic")
        val decimal = ListStyleType("decimal")
        val decimalLeadingZero = ListStyleType("decimal-leading-zero")
        val georgian = ListStyleType("georgian")
        val hebrew = ListStyleType("hebrew")
        val hiragana = ListStyleType("hiragana")
        val hiraganaIroha = ListStyleType("hiragana-iroha")
        val katakana = ListStyleType("katakana")
        val katakanaIroha = ListStyleType("katakana-iroha")
        val lowerAlpha = ListStyleType("lower-alpha")
        val lowerGreek = ListStyleType("lower-greek")
        val lowerLatin = ListStyleType("lower-latin")
        val lowerRoman = ListStyleType("lower-roman")
        val none = ListStyleType("none")
        val square = ListStyleType("square")
        val upperAlpha = ListStyleType("upper-alpha")
        val upperGreek = ListStyleType("upper-greek")
        val upperLatin = ListStyleType("upper-latin")
        val upperRoman = ListStyleType("upper-roman")
        val initial = ListStyleType("initial")
        val inherit = ListStyleType("inherit")
    }

}
