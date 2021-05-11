package nl.astraeus.css.properties


class MixBlendMode(
  value: String
) : CssProperty(value) {

  companion object {
    val normal = MixBlendMode("normal")
    val multiply = MixBlendMode("multiply")
    val screen = MixBlendMode("screen")
    val overlay = MixBlendMode("overlay")
    val darken = MixBlendMode("darken")
    val lighten = MixBlendMode("lighten")
    val colorDodge = MixBlendMode("color-dodge")
    val colorBurn = MixBlendMode("color-burn")
    val difference = MixBlendMode("difference")
    val exclusion = MixBlendMode("exclusion")
    val hue = MixBlendMode("hue")
    val saturation = MixBlendMode("saturation")
    val color = MixBlendMode("color")
    val luminosity = MixBlendMode("luminosity")
  }

}
