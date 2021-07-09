package nl.astraeus.css.properties

enum class MeasurementUoM {
  NONE,
  PX,
  EM,
  REM,
  PC,
  PRC,
  CM,
  FR
}

open class Measurement(
  value: String,
  val uom: MeasurementUoM = MeasurementUoM.NONE
) : CssProperty(value) {

  companion object {
    val auto = Measurement("auto")
    val initial = Measurement("initial")
    val inherit = Measurement("inherit")
    val normal = Measurement("normal")

    fun px(nr: Int) = if (nr == 0) {
      Measurement(
        "0",
        MeasurementUoM.PX
      )
    } else {
      Measurement(
        "${nr}px",
        MeasurementUoM.PX
      )
    }

    fun px(nr: Double) = nr.px
    fun em(nr: Int) = nr.em
    fun em(nr: Double) = nr.em
    fun prc(nr: Int) = nr.prc
    fun prc(nr: Double) = nr.prc
    fun pc(nr: Int) = nr.pc
    fun pc(nr: Double) = nr.pc
    fun cm(nr: Int) = nr.cm
    fun cm(nr: Double) = nr.cm
    fun fr(nr: Int) = nr.fr
  }
}

val Int.px: Measurement
  get() = Measurement(
    "${this}${
      if (this == 0) {
        ""
      } else {
        "px"
      }
    }",
    MeasurementUoM.PX
  )
val Int.em: Measurement
  get() = Measurement(
    "${this}${
      if (this == 0) {
        ""
      } else {
        "em"
      }
    }",
    MeasurementUoM.EM
  )
val Int.rem: Measurement
  get() = Measurement(
    "${this}${
      if (this == 0) {
        ""
      } else {
        "rem"
      }
    }",
    MeasurementUoM.REM
  )
val Int.prc: Measurement
  get() = Measurement("${this}%", MeasurementUoM.PRC)
val Int.pc: Measurement
  get() = Measurement("${this}pc", MeasurementUoM.PC)
val Int.cm: Measurement
  get() = Measurement("${this}cm", MeasurementUoM.CM)
val Int.fr: Measurement
  get() = Measurement("${this}fr", MeasurementUoM.FR)

fun Int.px(): Measurement = Measurement.px(this)

val Double.px: Measurement
  get() = Measurement("${this}px", MeasurementUoM.PX)
val Double.em: Measurement
  get() = Measurement("${this}em", MeasurementUoM.EM)
val Double.rem: Measurement
  get() = Measurement("${this}rem", MeasurementUoM.REM)
val Double.prc: Measurement
  get() = Measurement("${this}%", MeasurementUoM.PRC)
val Double.pc: Measurement
  get() = Measurement("${this}pc", MeasurementUoM.PC)
val Double.cm: Measurement
  get() = Measurement("${this}cm", MeasurementUoM.CM)

fun Double.px(): Measurement = Measurement.px(this)

open class LineHeight(value: String) : CssProperty(value) {
  companion object {
    val normal = LineHeight("normal")
    val initial = LineHeight("initial")
    val inherit = LineHeight("inherit")
  }
}
