package nl.astraeus.css.properties

class EmptyCells(
    value: String
) : CssProperty(value) {

    companion object {
        fun show() = EmptyCells("show")
        fun hide() = EmptyCells("hide")
        fun initial() = EmptyCells("initial")
        fun inherit() = EmptyCells("inherit")
    }

}
