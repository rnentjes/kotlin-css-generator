package nl.astraeus.css

import nl.astraeus.css.properties.oklch
import kotlin.test.Test

class ColorTest {

  @Test
  fun testColor() {
    val css = style {
      select("body") {
        color(oklch(100, 0.5, 0.5))
        backgroundColor(oklch(100, 0.5, 0.5, 0.25))
      }
    }

    println(css.generateCss())
  }

}