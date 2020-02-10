package nl.astraeus.css


enum class DelayDurationType {
    TIME,
    INITIAL,
    INHERIT
}

class DelayDuration(
    val type: DelayDurationType,
    val seconds: Int
) : CssProperty {

    override fun css(): String = when(type) {
        DelayDurationType.TIME -> "${seconds}s"
        DelayDurationType.INITIAL -> "initial"
        DelayDurationType.INHERIT -> "inherit"
    }

}

fun seconds(seconds: Int): DelayDuration = DelayDuration(DelayDurationType.TIME, seconds)
fun initial(): DelayDuration = DelayDuration(DelayDurationType.INITIAL, 0)
fun inherit(): DelayDuration = DelayDuration(DelayDurationType.INHERIT, 0)
