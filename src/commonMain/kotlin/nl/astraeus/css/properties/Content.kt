package nl.astraeus.css.properties

class Content(
    value: String
) : CssProperty(value) {

    companion object {
        fun normal() = Content("normal")
        fun none() = Content("none")
        fun counter() = Content("counter")
        fun attr(attribute: String) = Content("attr($attribute)")
        fun string(txt: String) = Content("\"$txt\"")
        fun openQuote() = Content("open-quote")
        fun closeQuote() = Content("close-quote")
        fun noOpenQuote() = Content("no-open-quote")
        fun noCloseQuote() = Content("no-close-quote")
        fun url(url: String) = Content("url($url)")
        fun initial() = Content("initial")
        fun inherit() = Content("inherit")
    }

}
