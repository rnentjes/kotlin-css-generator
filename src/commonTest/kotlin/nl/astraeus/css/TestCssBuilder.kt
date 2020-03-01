package nl.astraeus.css

import nl.astraeus.css.properties.Color.Companion.hsl
import nl.astraeus.css.properties.Color.Companion.rgba
import nl.astraeus.css.properties.Measurement.Companion.em
import nl.astraeus.css.properties.Measurement.Companion.px

//import kotlin.test.Test

object TestCssBuilder {

    //@Test
    fun testBuilder() {
        val css = CssBuilder()

        css.style {

            select(".test") {
                top = px(10)
                left = em(5)
                backgroundColor = rgba(255, 255, 255, 0.75)

                select("> a") {
                    color = hsl(200, 50, 50)
                }
            }
        }

        println(css)
    }

}
