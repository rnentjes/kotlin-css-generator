package nl.astraeus.css.properties

class Display(
    value: String
) : CssProperty(value) {

    companion object {
        fun inline() = Display("inline")
        fun block() = Display("block")
        fun contents() = Display("contents")
        fun flex() = Display("flex")
        fun grid() = Display("grid")
        fun inlineBlock() = Display("inline-block")
        fun inlineFlex() = Display("inline-flex")
        fun inlineGrid() = Display("inline-grid")
        fun inlineTable() = Display("inline-table")
        fun listItem() = Display("list-item")
        fun runIn() = Display("run-in")
        fun table() = Display("table")
        fun tableCaption() = Display("table-caption")
        fun tableColumnGroup() = Display("table-column-group")
        fun tableHeaderGroup() = Display("table-header-group")
        fun tableFooterGroup() = Display("table-footer-group")
        fun tableRowGroup() = Display("table-row-group")
        fun tableCell() = Display("table-cell")
        fun tableColumn() = Display("table-column")
        fun tableRow() = Display("table-row")
        fun none() = Display("none")
        fun initial() = Display("initial")
        fun inherit() = Display("inherit")
    }

}
