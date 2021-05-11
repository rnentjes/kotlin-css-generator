package nl.astraeus.css.style

import nl.astraeus.css.properties.CssProperty
import nl.astraeus.css.properties.FontSize
import nl.astraeus.css.properties.FontStretch
import nl.astraeus.css.properties.FontStyle
import nl.astraeus.css.properties.FontWeight

@CssTagMarker
open class FontFace : CssGenerator() {

  override fun getValidator(name: String) = null

  fun fontFamily(font: String) {
    props["font-family"] = listOf(CssProperty(font))
  }

  fun fontSize(size: FontSize) {
    props["font-size"] = listOf(size)
  }

  fun src(src: String) {
    props["src"] = listOf(CssProperty(src))
  }

  fun fontStretch(stretch: FontStretch) {
    props["font-stretch"] = listOf(stretch)
  }

  fun fontStyle(style: FontStyle) {
    props["font-style"] = listOf(style)
  }

  fun fontWeight(weight: FontWeight) {
    props["font-weight"] = listOf(weight)
  }

  fun unicodeRange(unicodeRange: String) {
    props["unicode-range"] = listOf(CssProperty(unicodeRange))
  }

}
