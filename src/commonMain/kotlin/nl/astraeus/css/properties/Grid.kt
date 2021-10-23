package nl.astraeus.css.properties


class Grid(
  value: String
) : CssProperty(value) {

  companion object {
    val none = Grid("none")
    val initial = Grid("initial")
    val inherit = Grid("inherit")
  }

}

class GridAuto(
  value: String
) : CssProperty(value) {

  companion object {
    val auto = GridAuto("auto")
    val maxContent = GridAuto("max-content")
    val minContent = GridAuto("min-content")
  }

}

class GridFlow(
  value: String
) : CssProperty(value) {

  companion object {
    val row = GridFlow("row")
    val column = GridFlow("column")
    val dense = GridFlow("dense")
    val rowDense = GridFlow("row dense")
    val columnDense = GridFlow("column dense")
  }

}

class GridValue(
  value: String
) : CssProperty(value) {

  companion object {
    val auto = GridValue("auto")

    fun span(column: Int) = GridValue("span $column")
    fun column(line: Int) = GridValue("$line")
    fun row(line: Int) = GridValue("$line")
  }

}

class TemplateRowColumn(
  value: String
) : CssProperty(value) {

  companion object {
    val none = TemplateRowColumn("none")
    val auto = TemplateRowColumn("auto")
    val maxContent = TemplateRowColumn("max-content")
    val minContent = TemplateRowColumn("min-content")
    val initial = TemplateRowColumn("initial")
    val inherit = TemplateRowColumn("inherit")

    fun length(length: Measurement) = TemplateRowColumn(length.value)
  }

}

