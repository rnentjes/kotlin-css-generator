package nl.astraeus.css

import nl.astraeus.css.properties.AlignContent
import nl.astraeus.css.properties.DelayDuration
import nl.astraeus.css.properties.TimingFunction
import nl.astraeus.css.properties.hex

fun main() {
  val sd = style {
    select("#pipo") {
      backgroundColor(hex(0xeeeeee))
      fontFamily("Arial, Courier")
      animationDelay(DelayDuration.initial)

      select("div") {
        color(hex(0x1b1b1b1))
        alignContent(AlignContent.flexStart)
        animationName("animname")
        animationTimingFunction(
          TimingFunction.cubicBezier(0.1, 0.2, 0.3, 0.4),
          TimingFunction.easeInOut
        )
      }
    }
  }

  println(sd.generateCss())
}
