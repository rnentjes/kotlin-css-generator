package nl.astraeus.css.properties

class All(
  value: String
) : CssProperty(value) {

  companion object {
    val unset = All("unset")
    val revert = All("revert")
    val initial = All("initial")
    val inherit = All("inherit")
  }

}
