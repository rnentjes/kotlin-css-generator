package nl.astraeus.css

import nl.astraeus.css.properties.*
import nl.astraeus.css.properties.AlignContent.Companion.flexStart
import nl.astraeus.css.style.Css
import nl.astraeus.css.style.Style

class StyleBase(
    val mainColor: Color = Color.hsl(128, 50, 50),
    val mainBackgroundColor: Color = Color.hsl(64, 50, 50),
    val mainFont: TextProperty = text("Arial")
)

private fun Style.sizePX(
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
        select("body") {
            fontFamily = base.mainFont
            color = base.mainColor
            backgroundColor = base.mainBackgroundColor
        }

        select(".test") {
            top = Measurement.px(10)
            left = Measurement.em(5)
            backgroundColor = Color.rgba(255, 255, 255, 0.75)

            select("> a") {
                color = Color.hsl(200, 50, 50)
            }
        }

        select("nav") {
            select("ul") {
                color = Color.hsl(0, 100, 25)
                backgroundColor = base.mainBackgroundColor
            }
            select("li") {
                sizePX(25, 25, 200, 200)

                select("a") {
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

    val border = css {
        borderRadius = BorderRadius(1, 2, 3, 4)
        borderColor = listOf(Color.hsl(22,66,55))

        select("a") {
            width = Measurement.px(10)
        }
    }

    val border2: Css = {
        borderRadius = BorderRadius(1, 2, 3, 4)
        borderColor = listOf(Color.hsl(20,60,50))
    }

    val font: Css = {
        fontFamily = text("Arial, Courier")
        fontSize = FontSize.larger()
    }

    val sd = style {
        select("#pipo") {
            backgroundColor = Color.hex("eeeeee")
            fontFamily = text("Arial, Courier")
            animationDelay = listOf(DelayDuration.initial())

            select("div") {
                fontFace {
                    fontFamily = text("SanSation")
                    fontSize = FontSize.larger()
                    src = text("font/sansation_bold.woff")
                    fontStretch = FontStretch.condensed()
                    fontStyle = FontStyle.italic()
                    fontWeight = FontWeight._600()
                }

                fontFamily = text("SanSation")
                color = Color.hex("1b1b1b1")
                alignContent = flexStart()
                animationName = listOf(
                    text("foo"),
                    text("bar")
                )
                select("span") {
                    animationIterationCount = listOf(
                        Count.count(3),
                        Count.infinite()
                    )
                    animationTimingFunction = listOf(
                        AnimationTimingFunction.cubicBezier(0.1, 0.2, 0.3, 0.4),
                        AnimationTimingFunction.easeInOut()
                    )
                }
                select("border-0") {
                    apply(border)
                    borderRadius = BorderRadius(4, 5, 6, 7)
                }
                select("border-1") {
                    apply(border2)
                    borderRadius = BorderRadius(4, 5, 6, 7)
                }
                select("border-2") {
                    borderRadius = BorderRadius(4, 5, 6, 7)
                    apply(border2)

                    display = Display.none()
                    borderBottomWidth = BorderWidth.perc(13)
                }
            }
        }
    }
    val borderStyle = style {
        select(".border") {
            apply(border)
            apply(font)

            select("> p") {
                fontSize = FontSize.smaller()
            }
        }
    }

    println("======")
    println(sd.generateCss())
    println("======")
    println(sd.generateCss(minified = true))
    println("======")
    println(borderStyle.generateCss())
}
