package nl.astraeus.css.properties

class BorderRadius(
  value: String
) : CssProperty(value) {
  companion object {
    fun px(nr: Int) = BorderRadius("${nr}px")
    fun em(nr: Int) = BorderRadius("${nr}em")
    fun em(nr: Double) = BorderRadius("${nr}em")
    fun perc(nr: Int) = BorderRadius("${nr}%")
    fun perc(nr: Double) = BorderRadius("${nr}%")
    fun pc(nr: Int) = BorderRadius("${nr}pc")
    fun pc(nr: Double) = BorderRadius("${nr}pc")
    fun cm(nr: Int) = BorderRadius("${nr}cm")
    fun cm(nr: Double) = BorderRadius("${nr}cm")
    val initial = BorderRadius("initial")
    val inherit = BorderRadius("inherit")
  }
}

class BorderStyle(
  value: String
) : CssProperty(value) {

  companion object {
    val none = BorderStyle("none")
    val hidden = BorderStyle("hidden")
    val dotted = BorderStyle("dotted")
    val dashed = BorderStyle("dashed")
    val solid = BorderStyle("solid")
    val double = BorderStyle("double")
    val groove = BorderStyle("groove")
    val ridge = BorderStyle("ridge")
    val inset = BorderStyle("inset")
    val outset = BorderStyle("outset")
    val initial = BorderStyle("initial")
    val inherit = BorderStyle("inherit")
  }
}

class BorderWidth(
  value: String
) : CssProperty(value) {

  companion object {
    val thin = BorderWidth("thin")
    val medium = BorderWidth("medium")
    val thick = BorderWidth("thick")
    val initial = BorderWidth("initial")
    val inherit = BorderWidth("inherit")
  }
}

class BorderCollapse(
  value: String
) : CssProperty(value) {

  companion object {
    val separate = BorderCollapse("separate")
    val collapse = BorderCollapse("collapse")
  }
}

class BorderImageWidth(
  value: String
) : CssProperty(value) {

  companion object {
    fun px(nr: Int) = BorderImageWidth("${nr}px")
    fun nr(nr: Int) = BorderImageWidth("$nr")
    fun perc(nr: Int) = BorderImageWidth("${nr}%")
    fun perc(nr: Double) = BorderImageWidth("${nr}%")
    val auto = BorderImageWidth("auto")
    val initial = BorderImageWidth("initial")
    val inherit = BorderImageWidth("inherit")
  }
}

class BorderSpacing(
  value: String
) : CssProperty(value) {

  companion object {
    fun px(nr: Int) = BorderSpacing("${nr}px")
    fun em(nr: Int) = BorderSpacing("${nr}em")
    fun em(nr: Double) = BorderSpacing("${nr}em")
    fun perc(nr: Int) = BorderSpacing("${nr}%")
    fun perc(nr: Double) = BorderSpacing("${nr}%")
    fun pc(nr: Int) = BorderSpacing("${nr}pc")
    fun pc(nr: Double) = BorderSpacing("${nr}pc")
    fun cm(nr: Int) = BorderSpacing("${nr}cm")
    fun cm(nr: Double) = BorderSpacing("${nr}cm")
    val initial = BorderSpacing("initial")
    val inherit = BorderSpacing("inherit")
  }
}
