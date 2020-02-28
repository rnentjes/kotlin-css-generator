package nl.astraeus.css.properties

class Image(
    value: String
) : CssProperty(value) {

    companion object {
        fun url(url: String) = Image("url($url)")
        fun none() = Image("none")
        fun initial() = Image("initial")
        fun inherit() = Image("inherit")
    }
}

class ImageRepeat(
    value: String
) : CssProperty(value) {

    companion object {
        fun stretch(url: String) = Image("stretch")
        fun repeat() = Image("repeat")
        fun round() = Image("round")
        fun initial() = Image("initial")
        fun inherit() = Image("inherit")
    }

}

class ImageSlice(
    value: String
) : CssProperty(value) {

    companion object {
        fun nr(nr: Int) = Image("$nr")
        fun perc(perc: Int) = Image("$perc%")
        fun perc(perc: Double) = Image("$perc%")
        fun stretch(url: String) = Image("stretch")
        fun repeat() = Image("repeat")
        fun fill() = Image("fill")
        fun initial() = Image("initial")
        fun inherit() = Image("inherit")
    }

}

class ImageSource(
    value: String
) : CssProperty(value) {

    companion object {
        fun none() = ImageSource("none")
        fun text(txt: String) = ImageSource(txt)
        fun image(url: String) = ImageSource("'$url'")
        fun initial() = ImageSource("initial")
        fun inherit() = ImageSource("inherit")
    }

}
