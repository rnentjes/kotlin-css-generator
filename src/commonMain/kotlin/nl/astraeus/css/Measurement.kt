package nl.astraeus.css

fun px(nr: Int): Measurement = Measurement(MeasurementType.PX, nr)
fun em(nr: Int): Measurement = Measurement(MeasurementType.EM, nr)
fun perc(nr: Int): Measurement = Measurement(MeasurementType.PERCENTAGE, nr)

enum class MeasurementType {
    PX,
    EM,
    PERCENTAGE,
    OTHER
}

open class Measurement(
    val type: MeasurementType,
    val intValue: Int = 0,
    val stringValue: String = ""
) : CssProperty() {

    override fun css(): String = when(type) {
        MeasurementType.PX -> {
            "${intValue}px"
        }
        MeasurementType.EM -> {
            "${intValue}em"
        }
        MeasurementType.PERCENTAGE -> {
            "${stringValue}%"
        }
        else -> {
            error("Unhandled type $type")
        }
    }

}

enum class FontSizeType {
    PX,
    EM,
    PERCENTAGE,

}

class FontSize(
    val fontType: FontSizeType,
    intValue: Int = 0,
    stringValue: String = ""
) : Measurement(
    MeasurementType.PX,
    intValue,
    stringValue
) {
    override fun css(): String = "12px"
}
