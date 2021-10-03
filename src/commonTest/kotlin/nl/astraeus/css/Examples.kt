package nl.astraeus.css

import nl.astraeus.css.properties.BorderStyle
import nl.astraeus.css.properties.Color
import nl.astraeus.css.properties.Measurement
import nl.astraeus.css.properties.em
import nl.astraeus.css.properties.hsla
import nl.astraeus.css.properties.prc
import nl.astraeus.css.properties.px
import nl.astraeus.css.style.Style
import nl.astraeus.css.style.cls
import nl.astraeus.css.style.txt
import kotlin.test.Test

class Examples {

  @Test
  fun testColor() {
    val color = hsla(0, 50, 50, 1.0)
    val backgroundColor = Color.white

    val css = style {
      select(cls("button")) {
        padding(5.px)

        select("a") {
          color(color)
          backgroundColor(backgroundColor)

          hover {
            color(color.lighten(10))
            backgroundColor(backgroundColor.darken(10))
          }
        }
      }
    }

    println(css.generateCss(minified = true))
  }

  @Test
  fun testMixins() {
    fun Style.borderStyles(borderWidth: Measurement = 2.px) {
      borderWidth(borderWidth)
      borderColor(Color.aquamarine)
      borderStyle(BorderStyle.solid)
    }

    val css = style {
      select(txt("a"), cls("button")) {
        borderStyles()

        color(Color.white)
      }

      select(cls("btn-primary")) {
        borderStyles(3.px)
        color(Color.blue)
      }
    }

    println(css.generateCss())
  }

  @Test
  fun testMeasurements() {
    val css = style {
      select("body") {
        fontSize(1.2.em)
        borderWidth(3.px)
        width(75.prc)
      }
    }

    println(css.generateCss())
  }

  @Test
  fun testGeneration() {
    val color = hsla(0, 50, 50, 1.0)
    val backgroundColor = Color.white

    val css = style {
      select(cls("button")) {
        padding(5.px)

        select("a", "span") {
          color(color)
          backgroundColor(backgroundColor)

          hover {
            color(color.lighten(10))
            backgroundColor(backgroundColor.darken(10))
          }
        }
      }
    }

    println(css.generateCss(
      minified = false,
      sortProperties = true,
      combineEqualBlocks = false
    ))
  }

  @Test
  fun testMediaQueries() {
    val css = style {
      media("screen and (min-width: 30em)") {
        select("html", "body") {
          backgroundColor(Color.purple)
          color(Color.blue)
        }
      }

      media("print") {
        select("html", "body") {
          backgroundColor(Color.white)
          color(Color.darkGrey)
        }
      }

    }

    println(css.generateCss(
      minified = false,
      sortProperties = true,
      combineEqualBlocks = true
    ))
  }
}
