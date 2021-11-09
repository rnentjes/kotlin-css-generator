package nl.astraeus.css.properties

enum class MeasurementUoM {
  NONE,
  PX,
  EM,
  REL,
  REM,
  PC,
  PRC,
  CM,
  FR,
  VH,
  VW
}

open class Measurement(
  value: String,
  val uom: MeasurementUoM = MeasurementUoM.NONE
) : CssProperty(value), CalcExpression {

  override fun toString(): String = super.value

  companion object {
    val auto = Measurement("auto")
    val initial = Measurement("initial")
    val inherit = Measurement("inherit")
    val normal = Measurement("normal")

    fun fromString(value: String): Measurement = when {
      value == "0" -> Measurement("0", MeasurementUoM.PX)
      value.endsWith("px") -> Measurement(value.slice(0..(value.length - 2)), MeasurementUoM.PX)
      value.endsWith("rel") -> Measurement(value.slice(0..(value.length - 3)), MeasurementUoM.REL)
      else -> {
        TODO("Unable to parse $value")
      }
    }
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
val Int.vw: Measurement
  get() = Measurement("${this}vw", MeasurementUoM.VW)
val Int.vh: Measurement
  get() = Measurement("${this}vh", MeasurementUoM.VH)

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
val Double.fr: Measurement
  get() = Measurement("${this}fr", MeasurementUoM.FR)
val Double.vw: Measurement
  get() = Measurement("${this}vw", MeasurementUoM.VW)
val Double.vh: Measurement
  get() = Measurement("${this}vh", MeasurementUoM.VH)

open class LineHeight(value: String) : CssProperty(value) {
  companion object {
    val normal = LineHeight("normal")
    val initial = LineHeight("initial")
    val inherit = LineHeight("inherit")
  }
}
