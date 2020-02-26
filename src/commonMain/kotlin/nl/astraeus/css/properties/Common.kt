package nl.astraeus.css.properties

class Length(
    value: String
): CssProperty(value) {

    companion object {
        fun px(nr: Int) = Length("${nr}px")
        fun em(nr: Int) = Length("${nr}em")
        fun em(nr: Double) = Length("${nr}em")
        fun perc(nr: Int) = Length("${nr}%")
        fun perc(nr: Double) = Length("${nr}%")
        fun pc(nr: Int) = Length("${nr}pc")
        fun pc(nr: Double) = Length("${nr}pc")
        fun cm(nr: Int) = Length("${nr}cm")
        fun cm(nr: Double) = Length("${nr}cm")
        fun initial() = Length("initial")
        fun inherit() = Length("inherit")
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

