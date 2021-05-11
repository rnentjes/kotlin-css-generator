package nl.astraeus.css.properties

class Display(
    value: String
) : CssProperty(value) {

    companion object {
        val inline = Display("inline")
        val block = Display("block")
        val contents = Display("contents")
        val flex = Display("flex")
        val grid = Display("grid")
        val inlineBlock = Display("inline-block")
        val inlineFlex = Display("inline-flex")
        val inlineGrid = Display("inline-grid")
        val inlineTable = Display("inline-table")
        val listItem = Display("list-item")
        val runIn = Display("run-in")
        val table = Display("table")
        val tableCaption = Display("table-caption")
        val tableColumnGroup = Display("table-column-group")
        val tableHeaderGroup = Display("table-header-group")
        val tableFooterGroup = Display("table-footer-group")
        val tableRowGroup = Display("table-row-group")
        val tableCell = Display("table-cell")
        val tableColumn = Display("table-column")
        val tableRow = Display("table-row")
        val none = Display("none")
        val initial = Display("initial")
        val inherit = Display("inherit")
    }

}
