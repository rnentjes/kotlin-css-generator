package nl.astraeus.css.properties

class Content(
    value: String
) : CssProperty(value) {

    companion object {
        val normal = Content("normal")
        val none = Content("none")
        val counter = Content("counter")
        val openQuote = Content("open-quote")
        val closeQuote = Content("close-quote")
        val noOpenQuote = Content("no-open-quote")
        val noCloseQuote = Content("no-close-quote")
        val initial = Content("initial")
        val inherit = Content("inherit")

        fun attr(attribute: String) = Content("attr($attribute)")
        fun string(txt: String) = Content("\"$txt\"")
        fun url(url: String) = Content("url($url)")
    }

}
