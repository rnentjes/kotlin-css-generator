package nl.astraeus.css

class StyleBase(
    val mainColor: Color = hsl(128, 50, 50),
    val mainBackgroundColor: Color = hsl(64, 50, 50),
    val mainFont: PlainProperty = plain("Arial")
)

private fun StyleDefinition.sizePX(
    left: Int,
    top: Int,
    width: Int,
    height: Int
) {
    this@sizePX.top = px(top)
    this@sizePX.left = px(left)
    this@sizePX.width = px(width)
    this@sizePX.height = px(height)
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
            top = px(10)
            left = em(5)
            backgroundColor = rgba(255, 255, 255, 0.75)

            css("> a") {
                color = hsl(200, 50, 50)
            }
        }

        css("nav") {
            css("ul") {
                color = hsl(0, 100, 25)
                backgroundColor = base.mainBackgroundColor
            }
            css("li") {
                sizePX(25, 25, 200, 200)

                css("a") {
                    width = px(725)
                    backgroundColor = base.mainBackgroundColor
                }
            }
        }
    }

    return css.getCss()
}

fun main() {
    val css1 = generateCss(StyleBase())
    val css2 = generateCss(StyleBase(
        hsl(32, 40, 50),
        hsl(64, 60, 35),
        plain("Courier")
    ))

    println(css1)
    println(css2)
}
