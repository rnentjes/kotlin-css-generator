package nl.astraeus.css

import nl.astraeus.css.properties.calc
import nl.astraeus.css.properties.em
import nl.astraeus.css.properties.minus
import nl.astraeus.css.properties.plus
import nl.astraeus.css.properties.px
import kotlin.test.Test

class TestCalcExpression {


  @Test
  fun testCalcExpression() {
    val a = calc(10.px + 20.px - 5.em)

    println(a)
  }
}
