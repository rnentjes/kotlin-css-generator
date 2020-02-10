package nl.astraeus.css

import kotlin.test.Test

object TestCssBuilder {

    @Test
    fun testBuilder() {
        val css = CssBuilder()

        css.style {

            css(".test") {
                top = px(10)
                left = em(5)
                backgroundColor = rgba(255, 255, 255, 0.75)

                sel("> a") {
                    color = hsl(200, 50, 50)
                }
            }
        }

        println(css)
    }

}
