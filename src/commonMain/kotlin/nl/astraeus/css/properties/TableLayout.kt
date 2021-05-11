package nl.astraeus.css.properties

class TableLayout(
    value: String
) : CssProperty(value) {

    companion object {
        val auto = TableLayout("auto")
        val fixed = TableLayout("fixed")
        val initial = TableLayout("initial")
        val inherit = TableLayout("auto")
    }

}
