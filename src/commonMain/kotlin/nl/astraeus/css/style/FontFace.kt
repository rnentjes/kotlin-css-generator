package nl.astraeus.css.style

import nl.astraeus.css.properties.*

@CssTagMarker
open class FontFace(
    var fontFamily: TextProperty? = null,
    var fontSize: FontSize? = null,
    var src: TextProperty? = null,
    var fontStretch: FontStretch? = null,
    var fontStyle: FontStyle? = null,
    var fontWeight: FontWeight? = null,
    var unicodeRange: TextProperty? = null
) : CssGenerator() {

    override fun getValidator(name: String) = null

    override fun getMapping(): Map<String, Any?> = mapOf(
        "font-family" to fontFamily,
        "font-size" to fontSize,
        "src" to src,
        "font-stretch" to fontStretch,
        "font-style" to fontStyle,
        "font-weight" to fontWeight,
        "unicode-range" to unicodeRange
    )
}
