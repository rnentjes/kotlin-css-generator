package nl.astraeus.css.style

@CssTagMarker
open class KeyFrames : CssGenerator() {
  val frames: MutableMap<Int, Css> = mutableMapOf()

  override fun getValidator(name: String): List<Validator>? = listOf()

  fun percentage(percentage: Int, style: Css) {
    val css = Style()

    style(css)

    frames[percentage] = style
  }
}
