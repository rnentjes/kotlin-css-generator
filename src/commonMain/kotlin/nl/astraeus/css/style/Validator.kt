package nl.astraeus.css.style

import nl.astraeus.css.properties.CssProperty

abstract class Validator {

    open fun validate(properties: List<CssProperty>): Boolean = true

    open fun getMessage(name: String): String = "'$name' validation message not defined for $this"

}

class MaxCountValidator(
    val number: Int
): Validator() {

    override fun validate(property: List<CssProperty>): Boolean = property.size <= number

    override fun getMessage(name: String): String = "'$name' should not have more than 4 entries"

}

class InitialInheritSingleValue: Validator() {

    override fun validate(properties: List<CssProperty>): Boolean {
        for (prop in properties) {
            if (prop.css() == "initial" || prop.css() == "inherit") {
                return properties.size == 1
            }
        }

        return true
    }

    override fun getMessage(name: String): String = "'$name' can only have single value when 'initial' or 'inherit'"

}
