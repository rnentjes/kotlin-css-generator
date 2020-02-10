package nl.astraeus.css


enum class CountType {
    NUMBER,
    INFINITE,
    INITIAL,
    INHERIT
}

class Count(
    val type: CountType,
    val number: Int
) : CssProperty {

    override fun css(): String = when(type) {
        CountType.NUMBER -> "$number"
        CountType.INFINITE -> "infinite"
        CountType.INITIAL -> "initial"
        CountType.INHERIT -> "inherit"
    }

    companion object {
        fun count(number: Int): Count = Count(CountType.NUMBER, number)
        fun infinite(): Count = Count(CountType.INFINITE, 0)
        fun initial(): Count = Count(CountType.INITIAL, 0)
        fun inherit(): Count = Count(CountType.INHERIT, 0)
    }
}

