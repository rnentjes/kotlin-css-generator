package nl.astraeus.css.properties

class DelayDuration(
  value: String
) : CssProperty(value) {

  companion object {
    val initial = DelayDuration("initial")
    val inherit = DelayDuration("inherit")

    fun seconds(seconds: Int) = DelayDuration("${seconds}s")
    fun millis(milliSeconds: Int) = DelayDuration("${milliSeconds}ms")
  }
}
