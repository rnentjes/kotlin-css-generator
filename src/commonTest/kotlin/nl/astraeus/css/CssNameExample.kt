package nl.astraeus.css

import nl.astraeus.css.properties.Color
import nl.astraeus.css.style.DescriptionProvider
import kotlin.test.Test

private val CAPITAL_LETTER by lazy { Regex("[A-Z]") }

fun String.hyphenize(): String =
  replace(CAPITAL_LETTER) {
    "-${it.value.lowercase()}"
  }

open class CssName(name: String? = null) : DescriptionProvider {
  val name: String = if (name != null) {
    "css-$name"
  } else{
    "css${this::class.simpleName?.hyphenize() ?: this::class}"
  }

  override fun description() = name
}

object MainTitle : CssName()
object SectionTitle : CssName("sct-title")

class CssNameExample {

  @Test
  fun testCssName() {
    val css = style {
      select(MainTitle) {
        color(Color.white)
      }

      select(SectionTitle) {
        color(Color.red)
      }
    }

    println(css.generateCss())
  }
}
