package nl.astraeus.css.properties

class UserSelect(
    value: String
) : CssProperty(value) {

    companion object {
        val auto = UserSelect("auto")
        val none = UserSelect("none")
        val text = UserSelect("text")
        val all = UserSelect("all")
    }

}
