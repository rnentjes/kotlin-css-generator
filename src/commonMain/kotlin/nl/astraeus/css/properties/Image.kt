package nl.astraeus.css.properties

class Image(
  value: String
) : CssProperty(value) {

  companion object {
    val none = Image("none")
    val initial = Image("initial")
    val inherit = Image("inherit")

    fun url(url: String) = Image("url($url)")
  }
}

class ImageRepeat(
  value: String
) : CssProperty(value) {

  companion object {
    val repeat = ImageRepeat("repeat")
    val round = ImageRepeat("round")
    val initial = ImageRepeat("initial")
    val inherit = ImageRepeat("inherit")

    fun stretch(url: String) = ImageRepeat("stretch")
  }

}

class ImageSlice(
  value: String
) : CssProperty(value) {

  companion object {
    val repeat = ImageSlice("repeat")
    val fill = ImageSlice("fill")
    val initial = ImageSlice("initial")
    val inherit = ImageSlice("inherit")

    fun nr(nr: Int) = ImageSlice("$nr")
    fun perc(perc: Int) = ImageSlice("$perc%")
    fun perc(perc: Double) = ImageSlice("$perc%")
    fun stretch(url: String) = ImageSlice("stretch")
  }

}

class ImageSource(
  value: String
) : CssProperty(value) {

  companion object {
    val none = ImageSource("none")
    val initial = ImageSource("initial")
    val inherit = ImageSource("inherit")

    fun text(txt: String) = ImageSource(txt)
    fun image(url: String) = ImageSource("'$url'")
  }

}
