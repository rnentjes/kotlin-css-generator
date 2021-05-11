package nl.astraeus.css.properties

class TimingFunction(
    value: String
) : CssProperty(value) {

    companion object {
        val linear = TimingFunction("linear")
        val ease = TimingFunction("ease")
        val easeIn = TimingFunction("ease-in")
        val easeOut = TimingFunction("ease-out")
        val easeInOut = TimingFunction("ease-in-out")
        val stepStart = TimingFunction("step-start")
        val stepEnd = TimingFunction("step-end")
        val initial = TimingFunction("initial")
        val inherit = TimingFunction("inherit")

        fun steps(steps: Int, start: Boolean) = TimingFunction("steps($steps, ${if (start) { "start" } else { "end" }}")
        fun cubicBezier(n1: Double, n2: Double, n3: Double, n4: Double) = TimingFunction("cubic-bezier($n1, $n2, $n3, $n4)")
    }

}
