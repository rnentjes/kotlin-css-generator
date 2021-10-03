package nl.astraeus.css.properties

class WhiteSpace(
  value: String
) : CssProperty(value) {

  companion object {
    val normal = WhiteSpace("normal")
    val nowrap = WhiteSpace("nowrap")
    val pre = WhiteSpace("pre")
    val preLine = WhiteSpace("pre-line")
    val preWrap = WhiteSpace("pre-wrap")
    val initial = WhiteSpace("initial")
    val inherit = WhiteSpace("inherit")
  }

}
