package nl.astraeus.css.properties

class WritingMode(
    value: String
) : CssProperty(value) {

    companion object {
        val horizontalTb = WritingMode("horizontal-tb")
        val verticalRl = WritingMode("vertical-rl")
        val verticalLr = WritingMode("vertical-lr")
    }

}
