package nl.astraeus.css

import nl.astraeus.css.properties.*
import nl.astraeus.css.properties.AlignContent.Companion.flexStart
import nl.astraeus.css.style.StyleDefinition

class StyleBase(
    val mainColor: Color = Color.hsl(128, 50, 50),
    val mainBackgroundColor: Color = Color.hsl(64, 50, 50),
    val mainFont: TextProperty = text("Arial")
)

private fun StyleDefinition.sizePX(
    left: Int,
    top: Int,
    width: Int,
    height: Int
) {
    this@sizePX.top = Measurement.px(top)
    this@sizePX.left = Measurement.px(left)
    this@sizePX.width = Measurement.px(width)
    this@sizePX.height = Measurement.px(height)
}

private fun generateCss(
    base: StyleBase
): String {
    val css = CssBuilder()

    css.style {
        css("body") {
            fontFamily = base.mainFont
            color = base.mainColor
            backgroundColor = base.mainBackgroundColor
        }

        css(".test") {
            top = Measurement.px(10)
            left = Measurement.em(5)
            backgroundColor = Color.rgba(255, 255, 255, 0.75)

            css("> a") {
                color = Color.hsl(200, 50, 50)
            }
        }

        css("nav") {
            css("ul") {
                color = Color.hsl(0, 100, 25)
                backgroundColor = base.mainBackgroundColor
            }
            css("li") {
                sizePX(25, 25, 200, 200)

                css("a") {
                    width = Measurement.px(725)
                    background = text("red initial")
                    backgroundColor = base.mainBackgroundColor
                    all = All.initial()
                }
            }
        }
    }

    return css.getCss()
}

fun main() {
    val css1 = generateCss(StyleBase())
    val css2 = generateCss(StyleBase(
        Color.hsl(32, 40, 50),
        Color.hsl(64, 60, 35),
        text("Courier")
    ))

    println(css1)
    println(css2)

    val sd = css {
        css("#pipo") {
            backgroundColor = Color.hex("eeeeee")
            fontFamily = text("Arial, Courier")
            animationDelay = listOf(DelayDuration.initial())

            css("div") {
                color = Color.hex("1b1b1b1")
                alignContent = flexStart()
                animationName = listOf(
                    text("foo"),
                    text("bar")
                )
                animationIterationCount = listOf(
                    Count.count(3),
                    Count.infinite()
                )
                animationTimingFunction = listOf(
                    AnimationTimingFunction.cubicBezier(0.1, 0.2, 0.3, 0.4),
                    AnimationTimingFunction.easeInOut()
                )
                borderRadius = listOf(
                    BorderRadius.px(4),
                    BorderRadius.px(5),
                    BorderRadius.px(6),
                    BorderRadius.px(7),
                    BorderRadius.px(8)
                )
            }
        }
    }

    println("======")
    println(sd.generateCss())
    println("======")
    println(sd.generateCss(minified = true))
}
