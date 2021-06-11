package nl.astraeus.css

import nl.astraeus.css.properties.Color
import nl.astraeus.css.properties.Count
import nl.astraeus.css.properties.Display
import nl.astraeus.css.properties.em
import nl.astraeus.css.properties.hsl
import nl.astraeus.css.properties.px
import nl.astraeus.css.properties.rgba
import nl.astraeus.css.style.attr
import nl.astraeus.css.style.attrEquals
import nl.astraeus.css.style.cls
import nl.astraeus.css.style.id
import kotlin.test.Test

class TestCssBuilder {

  @Test
  fun testBuilder() {
    val css = style {

      select(".test") {
        top(10.px)
        left(4.em)
        backgroundColor(rgba(255, 255, 255, 0.75))
        animationIterationMode(
          Count.auto,
          Count.auto,
          Count.auto,
          Count.auto,
          Count.auto
        )

        child("li") {
          color(hsl(200, 50, 50))
        }

        select("> a") {
          color(hsl(200, 50, 50))
        }

        hover {
          color(Color.red)
        }

        child("li") {
          listStyle("none")

          child("ul") {
            opacity(0.0)
            display(Display.none)
            paddingLeft(20.px)
            child("li") {
              listStyle("none")

              child("ul") {
                paddingLeft(30.px)
                child("li") {
                  listStyle("none")
                }
              }
            }
          }

          hover {
            child("ul") {
              opacity(1.0)
              display(Display.block)
            }
          }
        }
      }
    }

    println(css.generateCss())
  }

  @Test
  fun testClass() {
    val css2 = style {
      select(id("my-label")) {
        color(Color.antiqueWhite)
      }

      select(cls("my-label")) {
        color(Color.aliceBlue)
      }

      // tr.even {}
      select("tr") {
        and(cls("even")) {
          color(Color.gray)
        }

/*
        nthChild(2) {

        }
*/

        // not(bla) {
        not(cls("bla")) {
          color(Color.blue)
        }

      }

      // table .even {}
      select("tr") {
        select(cls("even")) {
          color(Color.green)
        }

        // [type]
        select(attr("type")) {

        }

        // [type="checkbox"]
        select(attrEquals("type", "checkbox")) {

        }

        // table > .odd
        child(cls("odd")) {

        }

        //adjSibling()
      }

      select(cls("button")) {
        fontSize(12.px)
        color(hsl(200, 50, 50))

        // .button:hover
        hover {
          color(hsl(200, 40, 40))
        }

        child(".green") {
          color(Color.green)
        }

        sibling(".red") {
          color(Color.red)
        }

        adjSibling(".blue") {
          color(Color.blue)
        }
      }
    }

    println(css2.generateCss())
  }


  @Test
  fun testOr() {
    val css = style {
      select("h1") {
        color(Color.blue)

        select("table") {
          color(Color.red)

          select("th", "td") {
            color(Color.green)
          }
        }
      }
    }

    println(css.generateCss())
  }
}
