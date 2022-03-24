package nl.astraeus.css.style

import nl.astraeus.css.properties.*

typealias Css = Style.() -> Unit

typealias ConditionalCss = ConditionalStyle.() -> Unit

@DslMarker
annotation class CssTagMarker

private fun prp(vararg css: CssValue): List<CssProperty> {
  val result = mutableListOf<CssProperty>()

  for (c in css) {
    result.add(CssProperty(c.css()))
  }

  return result
}

private fun prp(vararg css: String): List<CssProperty> {
  val result = mutableListOf<CssProperty>()

  for (c in css) {
    result.add(CssProperty(c))
  }

  return result
}

abstract class CssGenerator {
  val definitions: MutableMap<String, MutableList<Css>> = LinkedHashMap()
  val props: MutableMap<String, List<CssProperty>> = mutableMapOf()

  abstract fun getValidator(name: String): List<Validator>?

  private fun propertyCss(
    indent: String,
    name: String,
    minified: Boolean,
    props: List<CssProperty>
  ): String {
    val builder = StringBuilder()

    getValidator(name)?.forEach {
      if (!it.validate(props)) {
        println("Validate error '$name' - ${it.getMessage(name)}")
      }
    }

    for (prop in props) {
      if (builder.isNotEmpty()) {
        builder.append(" ")
      }
      builder.append(prop.css())
    }

    val paddedName = StringBuilder()
    if (!minified) {
      paddedName.append(indent)
    }
    paddedName.append(name)
    paddedName.append(":")
    if (!minified) {
      while (paddedName.length < 32) {
        paddedName.append(' ')
      }
    }
    return "$paddedName$builder;"
  }

  fun generatePropertyCss(
    indent: String,
    sortProperties: Boolean,
    minified: Boolean
  ): String {
    val builder = StringBuilder()

    if (sortProperties) {
      for (name in props.keys.sorted()) {
        val prop = props[name] ?: error("$name not found in properties after sorting!")

        builder.append(propertyCss(indent, name, minified, prop))
        if (!minified) {
          builder.append("\n")
        }
      }
    } else {
      for ((name, prop) in props) {
        builder.append(propertyCss(indent, name, minified, prop))
        if (!minified) {
          builder.append("\n")
        }
      }
    }

    return builder.toString()
  }

  open fun generateCss(
    indent: String = "",
    minified: Boolean = false,
    warnOnRedeclaration: Boolean = true,
    allowCommaInSelector: Boolean = false,
    combineEqualBlocks: Boolean = false,
    sortProperties: Boolean = false
  ): String {
    val blocks = generateCssBlocks(
      indent = indent,
      minified = minified,
      warnOnRedeclaration = warnOnRedeclaration,
      allowCommaInSelector = allowCommaInSelector,
      sortProperties = sortProperties
    )

    val builder = StringBuilder()

    fun StringBuilder.generateBlock(
      indent: String,
      selectors: List<String>,
      block: CssBlock?
    ) {
      if (selectors.isNotEmpty() && block != null) {
        append(indent)
        append(selectors.joinToString(if (minified) { "," } else { ",\n" }))
        if (!minified) {
          append(" ")
        }
        append("{")
        if (!minified) {
          append("\n")
        }
        append(block.content)
        append(indent)
        append("}")
        if (!minified) {
          append("\n\n")
        }
      }
    }

    if (!combineEqualBlocks) {
      var first = true
      val selectors = mutableListOf<String>()
      var lastBlock: CssBlock? = null

      for (block in blocks) {
        if (first) {
          first = false
          selectors.add(block.selector)
          lastBlock = block
        } else {
          lastBlock = if (lastBlock != null && lastBlock.content == block.content) {
            selectors.add(block.selector)
            block
          } else {
            builder.generateBlock(indent, selectors, lastBlock)

            selectors.clear()
            selectors.add(block.selector)
            block
          }
        }
      }

      builder.generateBlock(indent, selectors, lastBlock)
    } else {
      val blockHashes: MutableMap<Int, MutableList<CssBlock>> = mutableMapOf()

      for (block in blocks) {
        blockHashes.getOrPut(block.content.hashCode()) {
          mutableListOf()
        }.add(block)
      }
      val done = mutableSetOf<Int>()

      for(block in blocks) {
        val hashCode = block.content.hashCode()

        if (!done.contains(hashCode)) {
          blockHashes[hashCode]?.let {
            val slctrs = it.map { blk ->
              blk.selector
            }
            builder.generateBlock(indent, slctrs, block)
            done.add(hashCode)
          }
        }
      }
    }

    return builder.toString()
  }

  open fun generateCssBlocks(
    namespace: String = "",
    indent: String = "",
    minified: Boolean = false,
    warnOnRedeclaration: Boolean = true,
    allowCommaInSelector: Boolean = false,
    sortProperties: Boolean = false
  ): List<CssBlock> {
    val blocks = mutableListOf<CssBlock>()

    for (name in definitions.keys) {
      val props = definitions[name]!!
      val css = StringBuilder()

      if (warnOnRedeclaration && props.size > 1) {
        css.append("  $indent/* style '$name' is defined ${props.size} times! */\n")
      }

      val finalStyle = Style()

      for (prop in props) {
        prop(finalStyle)
      }

      css.append(finalStyle.generatePropertyCss("  $indent", sortProperties, minified))

      if (css.isNotBlank()) {
        val builder = StringBuilder()

        check (allowCommaInSelector || (name.indexOf(',') == -1)) {
          "Comma is not allowed in selector (option is set in generateCss call)"
        }

        //builder.append("\n$namespace$name".trim())

        //builder.append("  $indent")
        //builder.append(" {\n")

        finalStyle.fontFace?.let { ff ->
          if (!minified) {
            builder.append("  $indent")
          }
          builder.append("@font-face")
          if (!minified) {
            builder.append(" ")
          }
          builder.append("{")
          if (!minified) {
            builder.append("\n")
          }
          builder.append(ff.generatePropertyCss("    $indent", sortProperties, minified))
          if (!minified) {
            builder.append("  $indent")
          }
          builder.append("}")
          if (!minified) {
            builder.append("\n")
          }
        }

        finalStyle.keyFrames.let { kf ->
          kf.keys.sorted().forEach { frameName ->
            val css = kf[frameName]

            if (!minified) {
              builder.append("  $indent")
            }
            builder.append("@keyframes ")
            builder.append(frameName)
            if (!minified) {
              builder.append(" ")
            }
            builder.append("{")
            if (!minified) {
              builder.append("\n")
            }
            css?.let { css ->
              for ((nr, style) in css.frames) {
                if (!minified) {
                  builder.append("    $indent")
                }
                builder.append("${nr}% ")
                if (!minified) {
                  builder.append("    $indent")
                }
                builder.append("{")
                if (!minified) {
                  builder.append("\n")
                }

                val finalStyle = Style()

                style(finalStyle)

                builder.append(finalStyle.generatePropertyCss("      $indent", sortProperties, minified))

                if (!minified) {
                  builder.append("    $indent")
                }
                builder.append("}")
                if (!minified) {
                  builder.append("\n")
                }
              }

              if (!minified) {
                builder.append("  $indent")
              }
              builder.append("}")
              if (!minified) {
                builder.append("\n")
              }
            }
          }
        }

        builder.append(css)
        //builder.append("}\n\n")

        blocks.add(CssBlock(
          "$namespace$name".trim(),
          builder.toString()
        ))
      }

      blocks.addAll(finalStyle.generateCssBlocks(
        "$namespace$name".trim(),
        indent,
        minified = minified,
        allowCommaInSelector = allowCommaInSelector,
        warnOnRedeclaration = warnOnRedeclaration,
        sortProperties = sortProperties
      ))
    }

    if (this is ConditionalStyle) {
      this.media.let { mq ->
        mq.keys.sorted().forEach { mediaName ->
          val css = mq[mediaName]

          css?.let { css ->
            val mediaStyle = ConditionalStyle()

            css(mediaStyle)

            blocks.add(CssBlock(
              "$indent@media $mediaName".trim(),
              mediaStyle.generateCss(
                "  $indent",
                minified = minified,
                allowCommaInSelector = allowCommaInSelector,
                warnOnRedeclaration = warnOnRedeclaration,
                sortProperties = sortProperties
              )
            ))
          }
        }
      }

      this.supports.let { mq ->
        mq.keys.sorted().forEach { mediaName ->
          val css = mq[mediaName]

          css?.let { css ->
            val mediaStyle = ConditionalStyle()

            css(mediaStyle)

            blocks.add(CssBlock(
              "$indent@supports $mediaName".trim(),
              mediaStyle.generateCss(
                "  $indent",
                minified = minified,
                allowCommaInSelector = allowCommaInSelector,
                warnOnRedeclaration = warnOnRedeclaration,
                sortProperties = sortProperties
              )
            ))
          }
        }
      }
    }

    return blocks
  }
}

interface DescriptionProvider {
  fun description(): String
}

class ValueDescriptionProvider(
  val value: String
) : DescriptionProvider {

  override fun description() = value

}

fun txt(name: String): DescriptionProvider = ValueDescriptionProvider(name)
fun id(name: String): DescriptionProvider = ValueDescriptionProvider("#$name")
fun cls(name: String): DescriptionProvider = ValueDescriptionProvider(".$name")
fun attr(name: String): DescriptionProvider = ValueDescriptionProvider("[$name]")
fun attrEquals(name: String, value: String): DescriptionProvider = ValueDescriptionProvider("[$name=$value]")
fun attrContains(name: String, value: String): DescriptionProvider = ValueDescriptionProvider("[$name*=$value]")
fun attrEntriesContain(name: String, value: String): DescriptionProvider = ValueDescriptionProvider("[$name~=$value]")
fun attrEndsWith(name: String, value: String): DescriptionProvider = ValueDescriptionProvider("[$name$=$value]")
fun attrStartsWith(name: String, value: String): DescriptionProvider = ValueDescriptionProvider("[$name^=$value]")

fun id(name: DescriptionProvider) = ValueDescriptionProvider("#${name.description()}")
fun cls(name: DescriptionProvider): DescriptionProvider = ValueDescriptionProvider(".${name.description()}")
fun attr(name: DescriptionProvider): DescriptionProvider = ValueDescriptionProvider("[${name.description()}]")
fun attrEquals(name: DescriptionProvider, value: String): DescriptionProvider = ValueDescriptionProvider("[${name.description()}=$value]")
fun attrContains(name: DescriptionProvider, value: String): DescriptionProvider =
  ValueDescriptionProvider("[${name.description()}*=$value]")

fun attrEntriesContain(name: DescriptionProvider, value: String): DescriptionProvider =
  ValueDescriptionProvider("[${name.description()}~=$value]")

fun attrEndsWith(name: DescriptionProvider, value: String): DescriptionProvider =
  ValueDescriptionProvider("[${name.description()}$=$value]")

fun attrStartsWith(name: DescriptionProvider, value: String): DescriptionProvider =
  ValueDescriptionProvider("[${name.description()}^=$value]")

@CssTagMarker
open class InlineStyle : CssGenerator() {

  private val validators = mapOf<String, List<Validator>>(
    "background-position" to listOf(InitialInheritSingleValue()),
    "background-size" to listOf(MaxCountValidator(2)),
    "border-radius" to listOf(
      MaxCountValidator(4),
      InitialInheritSingleValue()
    ),

    "animation-iteration-mode" to listOf(MaxCountValidator(4)),
    "animation-timing-function" to listOf(MaxCountValidator(4)),
    "border-image-repeat" to listOf(MaxCountValidator(2)),
    "border-image-slice" to listOf(MaxCountValidator(4)),
    "border-spacing" to listOf(MaxCountValidator(4)),
    "border-style" to listOf(MaxCountValidator(4))
  )

  override fun getValidator(name: String) = validators[name]

  private fun addStyle(selector: String, style: Css) {
    definitions[selector] = definitions[selector] ?: mutableListOf()
    definitions[selector]?.add(style)
  }

  fun active(style: Css) {
    addStyle(":active", style)
  }

  fun focus(style: Css) {
    addStyle(":focus", style)
  }

  fun focusWithin(style: Css) {
    addStyle(":focus-within", style)
  }

  fun hover(style: Css) {
    addStyle(":hover", style)
  }

  fun visited(style: Css) {
    addStyle(":visited", style)
  }

  fun plain(name: String, value: String) {
    props[name] = prp(value)
  }

  fun plain(name: String, value: CssProperty) {
    props[name] = prp(value)
  }

  fun alignContent(value: AlignContent) {
    props["align-content"] = prp(value)
  }

  fun alignItems(alignItems: AlignItems) {
    props["align-items"] = prp(alignItems)
  }

  fun all(all: All) {
    props["all"] = prp(all)
  }

  fun alignSelf(alignSelf: AlignSelf) {
    props["align-self"] = prp(alignSelf)
  }

  fun animation(text: String) {
    props["animation"] = prp(text)
  }

  fun animationDelay(delay: DelayDuration) {
    props["animation-delay"] = prp(delay)
  }

  fun animationDirection(direction: AnimationDirection) {
    props["animation-direction"] = prp(direction)
  }

  fun animationDuration(duration: DelayDuration) {
    props["animation-duration"] = prp(duration)
  }

  fun animationFillMode(fillMode: AnimationFillMode) {
    props["animation-fill-mode"] = prp(fillMode)
  }

  fun animationIterationMode(vararg iterationMode: Count) {
    props["animation-iteration-mode"] = prp(*iterationMode)
  }

  fun animationFrame(frame: AnimationFrame) {
    props["animation-frame"] = prp(frame)
  }

  fun animationName(vararg name: String) {
    props["animation-name"] = prp(*name)
  }

  fun animationPlayState(vararg state: AnimationPlayState) {
    props["animation-play-state"] = prp(*state)
  }

  fun animationTimingFunction(vararg timingFunction: TimingFunction) {
    props["animation-timing-function"] = prp(*timingFunction)
  }

  fun backfaceVisibility(backfaceVisibility: BackfaceVisibility) {
    props[""] = prp(backfaceVisibility)
  }

  fun background(background: String) {
    props["background"] = prp(background)
  }

  fun backgroundAttachment(attachment: BackgroundAttachment) {
    props["background-attachment"] = prp(attachment)
  }

  fun backgroundBlendMode(blendMode: BackgroundBlendMode) {
    props["background-blend-mode"] = prp(blendMode)
  }

  fun backgroundClip(clip: ClipOrigin) {
    props["background-clip"] = prp(clip)
  }

  fun backgroundColor(color: Color) {
    props["background-color"] = prp(color)
  }

  fun backgroundImage(image: Image) {
    props["background-image"] = prp(image)
  }

  fun backgroundImage(value: String) {
    props["background-image"] = prp(value)
  }

  fun backgroundOrigin(origin: ClipOrigin) {
    props["background-origin"] = prp(origin)
  }

  fun backgroundPosition(position: BackgroundPosition) {
    props["background-position"] = prp(position)
  }

  fun backgroundRepeat(repeat: BackgroundRepeat) {
    props["background-repeat"] = prp(repeat)
  }

  fun backgroundSize(vararg size: BackgroundSize) {
    props["background-size"] = prp(*size)
  }

  fun border(border: String) {
    props["border"] = prp(border)
  }

  fun border(
    width: Measurement,
    style: BorderStyle,
    color: Color
  ) {
    props["border"] = prp(width, style, color)
  }

  fun borderBottom(borderBottom: String) {
    props["border-bottom"] = prp(borderBottom)
  }

  fun borderBottomColor(color: Color) {
    props["border-bottom-color"] = prp(color)
  }

  fun borderBottomLeftRadius(vararg radius: Measurement) {
    props["border-bottom-left-radius"] = prp(*radius)
  }

  fun borderBottomRightRadius(vararg radius: Measurement) {
    props["border-bottom-right-radius"] = prp(*radius)
  }

  fun borderBottomStyle(style: BorderStyle) {
    props["border-bottom-style"] = prp(style)
  }

  fun borderBottomWidth(width: BorderWidth) {
    props["border-bottom-width"] = prp(width)
  }

  fun borderBottomWidth(width: Measurement) {
    props["border-bottom-width"] = prp(width)
  }

  fun borderCollapse(collapse: BorderCollapse) {
    props["border-collapse"] = prp(collapse)
  }

  fun borderColor(vararg color: Color) {
    props["border-color"] = prp(*color)
  }

  fun borderImage(image: String) {
    props["border-image"] = prp(image)
  }

  fun borderImageOutset(imageOutset: Length) {
    props["border-image-outset"] = prp(imageOutset)
  }

  fun borderImageRepeat(vararg repeat: ImageRepeat) {
    props["border-image-repeat"] = prp(*repeat)
  }

  fun borderImageSlice(vararg slice: ImageSlice) {
    props["border-image-slice"] = prp(*slice)
  }

  fun borderImageSource(vararg source: ImageSource) {
    props["border-image-source"] = prp(*source)
  }

  fun borderImageWidth(vararg width: BorderImageWidth) {
    props["border-image-width"] = prp(*width)
  }

  fun borderLeft(left: String) {
    props["border-left"] = prp(left)
  }

  fun borderLeftColor(color: Color) {
    props["border-left-color"] = prp(color)
  }

  fun borderLeftStyle(style: BorderStyle) {
    props["border-left-style"] = prp(style)
  }

  fun borderLeftWidth(width: BorderWidth) {
    props["border-left-width"] = prp(width)
  }

  fun borderLeftWidth(width: Measurement) {
    props["border-left-width"] = prp(width)
  }

  fun borderRadius(radius: Measurement) {
    props["border-radius"] = prp(radius)
  }

  fun borderRadius(
    topLeftBottomRight: Measurement,
    topRightBottomLeft: Measurement
  ) {
    props["border-radius"] = listOf(
      topLeftBottomRight, topRightBottomLeft
    )
  }

  fun borderRadius(
    topLeft: Measurement,
    topRightBottomLeft: Measurement,
    bottomRight: Measurement
  ) {
    props["border-radius"] = listOf(
      topLeft, topRightBottomLeft, bottomRight
    )
  }

  fun borderRadius(
    topLeft: Measurement,
    topRight: Measurement,
    bottomRight: Measurement,
    bottomLeft: Measurement
  ) {
    props["border-radius"] = listOf(
      topLeft, topRight, bottomRight, bottomLeft
    )
  }

  fun borderRight(border: String) {
    props["border-right"] = prp(border)
  }

  fun borderRightColor(color: Color) {
    props["border-right-color"] = prp(color)
  }

  fun borderRightStyle(style: BorderStyle) {
    props["border-right-style"] = prp(style)
  }

  fun borderRightWidth(width: BorderWidth) {
    props["border-right-width"] = prp(width)
  }

  fun borderRightWidth(width: Measurement) {
    props["border-right-width"] = prp(width)
  }

  fun borderSpacing(vararg spacing: BorderSpacing) {
    props["border-spacing"] = prp(*spacing)
  }

  fun borderStyle(vararg style: BorderStyle) {
    props["border-style"] = prp(*style)
  }

  fun borderTop(border: String) {
    props["border-top"] = prp(border)
  }

  fun borderTopColor(color: Color) {
    props["border-top-color"] = prp(color)
  }

  fun borderTopLeftRadius(radius: Measurement) {
    props["border-top-left-radius"] = prp(radius)
  }

  fun borderTopRightRadius(radius: Measurement) {
    props["border-top-right-radius"] = prp(radius)
  }

  fun borderTopStyle(style: BorderStyle) {
    props["border-top-style"] = prp(style)
  }

  fun borderTopWidth(width: BorderWidth) {
    props["border-top-width"] = prp(width)
  }

  fun borderTopWidth(width: Measurement) {
    props["border-top-width"] = prp(width)
  }

  fun borderWidth(width: Measurement) {
    props["border-width"] = prp(width)
  }

  fun borderWidth(width: BorderWidth) {
    props["border-width"] = prp(width)
  }

  fun bottom(measurement: Measurement) {
    props["bottom"] = prp(measurement)
  }

  fun boxDecorationBreak(brk: BoxDecorationBreak) {
    props["box-decoration-break"] = prp(brk)
  }

  fun boxShadow(shadow: BoxShadow) {
    props["box-shadow"] = prp(shadow)
  }

  fun boxSizing(sizing: BoxSizing) {
    props["box-sizing"] = prp(sizing)
  }

  fun breakAfter(brk: Break) {
    props["break-after"] = prp(brk)
  }

  fun breakBefore(brk: Break) {
    props["break-before"] = prp(brk)
  }

  fun breakInside(brk: Break) {
    props["break-inside"] = prp(brk)
  }

  fun captionSide(side: CaptionSide) {
    props["caption-side"] = prp(side)
  }

  fun caretColor(color: Color) {
    props["caret-color"] = prp(color)
  }

  fun clear(clear: Clear) {
    props["clear"] = prp(clear)
  }

  fun clip(clip: Clip) {
    props["clip"] = prp(clip)
  }

  fun clipPath(path: ClipPath) {
    props["clip-path"] = prp(path)
  }

  fun color(color: Color) {
    props["color"] = listOf(color)
  }

  fun columnCount(count: Count) {
    props["column-count"] = prp(count)
  }

  fun columnFill(fill: Fill) {
    props["column-fill"] = prp(fill)
  }

  fun columnGap(gap: Measurement) {
    props["column-gap"] = prp(gap)
  }

  fun columnRule(rule: String) {
    props["column-rule"] = prp(rule)
  }

  fun columnRuleColor(color: Color) {
    props["column-rule-color"] = prp(color)
  }

  fun columnRuleStyle(style: BorderStyle) {
    props["column-rule-style"] = prp(style)
  }

  fun columnRuleWidth(width: Measurement) {
    props["column-rule-width"] = prp(width)
  }

  fun columnSpan(span: Span) {
    props["column-span"] = prp(span)
  }

  fun columnWidth(width: Measurement) {
    props["column-width"] = prp(width)
  }

  fun column(column: String) {
    props["column"] = prp(column)
  }

  fun content(content: Content) {
    props["content"] = prp(content)
  }

  fun content(content: String) {
    props["content"] = prp(content)
  }

  fun counterIncrement(increment: String) {
    props["counter-increment"] = prp(increment)
  }

  fun counterReset(reset: String) {
    props["counter-reset"] = prp(reset)
  }

  fun cursor(cursor: String) {
    props["cursor"] = prp(cursor)
  }

  fun direction(direction: Direction) {
    props["direction"] = prp(direction)
  }

  fun display(display: Display) {
    props["display"] = prp(display)
  }

  fun emptyCells(cells: EmptyCells) {
    props["empty-cells"] = prp(cells)
  }

  fun filter(filter: String) {
    props["filter"] = prp(filter)
  }

  fun flex(flex: String) {
    props["flex"] = prp(flex)
  }

  fun flexBasis(basis: Measurement) {
    props["flex-basis"] = prp(basis)
  }

  fun flexDirection(direction: FlexDirection) {
    props["flex-direction"] = prp(direction)
  }

  fun flexFlow(flow: String) {
    props["flex-flow"] = prp(flow)
  }

  fun flexGrow(grow: FlexGrowShrink) {
    props["flex-grow"] = prp(grow)
  }

  fun flexShrink(shrink: FlexGrowShrink) {
    props["flex-shrink"] = prp(shrink)
  }

  fun flexWrap(wrap: FlexWrap) {
    props["flex-wrap"] = prp(wrap)
  }

  fun float(cssFloat: CssFloat) {
    props["float"] = prp(cssFloat)
  }

  fun font(font: String) {
    props["font"] = prp(font)
  }

  fun fontFamily(font: String) {
    props["font-family"] = prp(font)
  }

  fun fontFeatureSettings(vararg setting: String) {
    props["font-feature-settings"] = prp(*setting)
  }

  fun fontKerning(kerning: FontKerning) {
    props["font-kerking"] = prp(kerning)
  }

  fun fontSize(size: FontSize) {
    props["font-size"] = prp(size)
  }

  fun fontSize(size: Measurement) {
    props["font-size"] = prp(size)
  }

  fun fontSizeAdjust(number: Double) {
    props["font-size-adjust"] = prp(CssProperty("$number"))
  }

  fun fontSizeAdjust(adjust: FontSizeAdjust) {
    props["font-size-adjust"] = prp(adjust)
  }

  fun fontStretch(stretch: FontStretch) {
    props["font-stretch"] = prp(stretch)
  }

  fun fontStyle(style: FontStyle) {
    props["font-style"] = prp(style)
  }

  fun fontVariant(variant: FontVariant) {
    props["font-variant"] = prp(variant)
  }

  fun fontVariantCaps(caps: FontVariantCaps) {
    props["font-variant-caps"] = prp(caps)
  }

  fun fontWeight(weight: FontWeight) {
    props["font-weight"] = prp(weight)
  }

  fun grid(grid: String) {
    props["grid"] = prp(grid)
  }

  fun gridArea(area: String) {
    props["grid-area"] = prp(area)
  }

  fun gridAutoColumns(columns: GridAuto) {
    props["grid-auto-columns"] = prp(columns)
  }

  fun gridAutoFlow(flow: GridFlow) {
    props["grid-auto-flow"] = prp(flow)
  }

  fun gridAutoRows(autoRows: GridAuto) {
    props["grid-auto-rows"] = prp(autoRows)
  }

  fun gridAutoRows(size: Measurement) {
    props["grid-auto-rows"] = prp(size)
  }

  fun gridColumn(start: GridValue, end: GridValue) {
    props["grid-column"] = prp(CssProperty("${start.css()}/${end.css()}"))
  }

  fun gridColumnEnd(end: GridValue) {
    props["grid-column-end"] = prp(end)
  }

  fun gridColumnGap(gap: GridValue) {
    props["grid-column-gap"] = prp(gap)
  }

  fun gridColumnStart(start: GridValue) {
    props["grid-column-start"] = prp(start)
  }

  fun gridGap(
    rowGap: Measurement = 0.px,
    columnGap: Measurement = 0.px
  ) {
    props["grid-gap"] = prp(rowGap, columnGap)
  }

  fun gridRow(start: GridValue, end: GridValue) {
    props["grid-row"] = prp(CssProperty("${start.css()}/${end.css()}"))
  }

  fun gridRowEnd(end: GridValue) {
    props["grid-row-end"] = prp(end)
  }

  fun gridRowGap(gap: GridValue) {
    props["grid-row-end"] = prp(gap)
  }

  fun gridRowStart(start: GridValue) {
    props["grid-row-start"] = prp(start)
  }

  fun gridTemplate(template: String) {
    props["grid-template"] = prp(template)
  }

  fun gridTemplateAreas(template: String) {
    props["grid-template-areas"] = prp(template)
  }

  @Deprecated(
    "Fixed type, use gridTemplateColumns instead",
    ReplaceWith("gridTemplateColumns(columns)")
  )
  fun gridTemplateColumn(vararg columns: TemplateRowColumn) {
    props["grid-template-columns"] = prp(*columns)
  }

  fun gridTemplateColumns(vararg columns: TemplateRowColumn) {
    props["grid-template-columns"] = prp(*columns)
  }

  fun gridTemplateColumns(vararg columns: Measurement) {
    props["grid-template-columns"] = prp(*columns)
  }

  fun gridTemplateRows(vararg rows: TemplateRowColumn) {
    props["grid-template-rows"] = prp(*rows)
  }

  fun gridTemplateRows(vararg rows: Measurement) {
    props["grid-template-rows"] = prp(*rows)
  }

  fun hangingPunctuation(punctuation: Isolation) {
    props["hanging-punctuation"] = prp(punctuation)
  }

  fun height(height: Measurement) {
    props["height"] = prp(height)
  }

  fun hyphens(hyphens: Hyphens) {
    props["hyphens"] = prp(hyphens)
  }

  fun isolation(isolation: Isolation) {
    props["isolation"] = prp(isolation)
  }

  fun justifyContent(content: JustifyContent) {
    props["justify-content"] = prp(content)
  }

  fun left(left: Measurement) {
    props["left"] = prp(left)
  }

  fun letterSpacing(length: Measurement) {
    props["letter-spacing"] = prp(length)
  }

  fun letterSpacing(spacing: LetterSpacing) {
    props["letter-spacing"] = prp(spacing)
  }

  fun lineHeight(number: Double) {
    props["line-height"] = prp("$number")
  }

  fun lineHeight(measurement: Measurement) {
    props["line-height"] = prp(measurement)
  }

  fun lineHeight(height: LineHeight) {
    props["line-height"] = prp(height)
  }

  fun listStyle(style: String) {
    props["list-style"] = prp(style)
  }

  fun listStyleImage(url: String) {
    props["list-style-image"] = prp("url('$url')")
  }

  fun listStylePosition(position: ListStylePosition) {
    props["list-style-position"] = prp(position)
  }

  fun listStyleType(position: ListStyleType) {
    props["list-style-type"] = prp(position)
  }

  fun margin(all: Measurement) {
    props["margin"] = prp(all)
  }

  fun margin(
    topBottom: Measurement,
    leftRight: Measurement
  ) {
    props["margin"] = prp(topBottom, leftRight)
  }

  fun margin(top: Measurement, right: Measurement, bottom: Measurement, left: Measurement) {
    props["margin"] = prp(top, right, bottom, left)
  }

  fun marginBottom(bottom: Measurement) {
    props["margin-bottom"] = prp(bottom)
  }

  fun marginLeft(left: Measurement) {
    props["margin-left"] = prp(left)
  }

  fun marginRight(right: Measurement) {
    props["margin-right"] = prp(right)
  }

  fun marginTop(top: Measurement) {
    props["margin-top"] = prp(top)
  }

  fun maxHeight(height: Measurement) {
    props["max-height"] = prp(height)
  }

  fun maxWidth(width: Measurement) {
    props["max-width"] = prp(width)
  }

  fun minHeight(height: Measurement) {
    props["min-height"] = prp(height)
  }

  fun minWidth(width: Measurement) {
    props["min-width"] = prp(width)
  }

  fun mixBlendMode(blendMode: MixBlendMode) {
    props["mix-blend-mode"] = prp(blendMode)
  }

  fun objectFit(fit: ObjectFit) {
    props["object-fit"] = prp(fit)
  }

  fun objectPosition(position: String) {
    props["object-position"] = prp(position)
  }

  fun opacity(opacity: Double) {
    props["opacity"] = prp(opacity.toString())
  }

  fun opacity(opacity: InitialInherit) {
    props["opacity"] = prp(opacity.toString())
  }

  fun order(order: Int) {
    props["order"] = prp(order.toString())
  }

  fun order(order: InitialInherit) {
    props["order"] = prp(order)
  }

  fun outline(outline: String) {
    props["outline"] = prp(outline)
  }

  fun outlineColor(color: Color) {
    props["outline-color"] = prp(color)
  }

  fun outlineOffset(offset: Measurement) {
    props["outline-offset"] = prp(offset)
  }

  fun outlineStyle(style: BorderStyle) {
    props["outline-style"] = prp(style)
  }

  fun outlineWidth(width: OutlineWidth) {
    props["outline-width"] = prp(width)
  }

  fun outlineWidth(width: Measurement) {
    props["outline-width"] = prp(width)
  }

  fun overflow(overflow: Overflow) {
    props["overflow"] = prp(overflow)
  }

  fun overflowX(overflow: Overflow) {
    props["overflow-x"] = prp(overflow)
  }

  fun overflowY(overflow: Overflow) {
    props["overflow-y"] = prp(overflow)
  }

  fun padding(padding: Measurement) {
    props["padding"] = prp(padding)
  }

  fun padding(vertical: Measurement, horizontal: Measurement) {
    props["padding"] = prp(vertical, horizontal)
  }

  fun padding(top: Measurement, right: Measurement, bottom: Measurement, left: Measurement) {
    props["padding"] = prp(top, right, bottom, left)
  }

  fun padding(padding: InitialInherit) {
    props["padding"] = prp(padding)
  }

  fun paddingBottom(padding: Measurement) {
    props["padding-bottom"] = prp(padding)
  }

  fun paddingBottom(padding: InitialInherit) {
    props["padding-bottom"] = prp(padding)
  }

  fun paddingLeft(padding: Measurement) {
    props["padding-left"] = prp(padding)
  }

  fun paddingLeft(padding: InitialInherit) {
    props["padding-left"] = prp(padding)
  }

  fun paddingRight(padding: Measurement) {
    props["padding-right"] = prp(padding)
  }

  fun paddingRight(padding: InitialInherit) {
    props["padding-right"] = prp(padding)
  }

  fun paddingTop(padding: Measurement) {
    props["padding-top"] = prp(padding)
  }

  fun paddingTop(padding: InitialInherit) {
    props["padding-top"] = prp(padding)
  }

  fun pageBreakAfter(pageBreak: PageBreak) {
    props["page-break-after"] = prp(pageBreak)
  }

  fun pageBreakBefore(pageBreak: PageBreak) {
    props["page-break-before"] = prp(pageBreak)
  }

  fun pageBreakInside(pageBreak: PageBreak) {
    props["page-break-inside"] = prp(pageBreak)
  }

  fun perspective(length: Measurement) {
    props["perspective"] = prp(length)
  }

  fun perspective(perspective: Perspective) {
    props["perspective"] = prp(perspective)
  }

  fun perspectiveOrigin(po: String) {
    props["perspective-origin"] = prp(po)
  }

  fun pointerEvents(pe: PointerEvents) {
    props["pointer-events"] = prp(pe)
  }

  fun position(poition: Position) {
    props["position"] = prp(poition)
  }

  fun quotes(value: String) {
    props["quotes"] = prp(value)
  }

  fun resize(resize: Resize) {
    props["resize"] = prp(resize)
  }

  fun right(right: Measurement) {
    props["right"] = prp(right)
  }

  fun scrollBehavior(sb: ScrollBehavior) {
    props["scroll-behavior"] = prp(sb)
  }

  fun tabSize(number: Int) {
    props["tab-size"] = prp(number.toString())
  }

  fun tabSize(length: Measurement) {
    props["tab-size"] = prp(length)
  }

  fun tabSize(ts: InitialInherit) {
    props["tab-size"] = prp(ts)
  }

  fun tableLayout(tl: TableLayout) {
    props["table-layout"] = prp(tl)
  }

  fun textAlign(ta: TextAlign) {
    props["text-align"] = prp(ta)
  }

  fun textAlignLast(tal: TextAlignLast) {
    props["text-align-last"] = prp(tal)
  }

  fun textDecoration(decoration: String) {
    props["text-decoration"] = prp(decoration)
  }

  fun textDecorationColor(color: Color) {
    props["text-decoration-color"] = prp(color)
  }

  fun textDecorationLine(tdc: TextDecorationLine) {
    props["text-decoration-line"] = prp(tdc)
  }

  fun textDecorationStyle(tds: TextDecorationStyle) {
    props["text-decoration-style"] = prp(tds)
  }

  fun textIndent(length: Measurement) {
    props["text-indent"] = prp(length)
  }

  fun textIndent(indent: InitialInherit) {
    props["text-indent"] = prp(indent)
  }

  fun textJustify(tj: TextJustify) {
    props["text-justify"] = prp(tj)
  }

  fun textOverflow(to: String) {
    props["text-overflow"] = prp(to)
  }

  fun textShadow(ts: String) {
    props["text-shadow"] = prp(ts)
  }

  fun textTransform(tt: TextTransform) {
    props["text-transform"] = prp(tt)
  }

  fun top(top: Measurement) {
    props["top"] = prp(top)
  }

  fun transform(transform: Transform) {
    props["transform"] = prp(transform)
  }

  fun transformOrigin(origin: String) {
    props["transform-origin"] = prp(origin)
  }

  fun transformStyle(style: TransformStyle) {
    props["transform-style"] = prp(style)
  }

  fun transition(transition: String) {
    props["transition"] = prp(transition)
  }

  fun transitionDelay(timeInSeconds: Double) {
    props["transition-delay"] = prp("${timeInSeconds}s")
  }

  fun transitionDelay(timeInMillis: Int) {
    props["transition-delay"] = prp("${timeInMillis}ms")
  }

  fun transitionDelay(delay: DelayDuration) {
    props["transition-delay"] = prp(delay)
  }

  fun transitionDuration(timeInSeconds: Double) {
    props["transition-duration"] = prp("${timeInSeconds}s")
  }

  fun transitionDuration(timeInMillis: Int) {
    props["transition-duration"] = prp("${timeInMillis}ms")
  }

  fun transitionDuration(td: DelayDuration) {
    props["transition-duration"] = prp(td)
  }

  fun transitionProperty(property: String) {
    props["transition-property"] = prp(property)
  }

  fun transitionTimingFunction(function: TimingFunction) {
    props["transition-timing-function"] = prp(function)
  }

  fun unicodeBidi(ub: UnicodeBidi) {
    props["unicode-bidi"] = prp(ub)
  }

  fun userSelect(us: UserSelect) {
    props["user-select"] = prp(us)
  }

  fun verticalAlign(length: Measurement) {
    props["vertical-align"] = prp(length)
  }

  fun verticalAlign(va: VerticalAlign) {
    props["vertical-align"] = prp(va)
  }

  fun visibility(visibility: Visibility) {
    props["visibility"] = prp(visibility)
  }

  fun whiteSpace(whiteSpace: WhiteSpace) {
    props["white-space"] = prp(whiteSpace)
  }

  fun width(width: Measurement) {
    props["width"] = prp(width)
  }

  fun wordBreak(wordBreak: WordBreak) {
    props["word-break"] = prp(wordBreak)
  }

  fun wordSpacing(wordSpacing: Measurement) {
    props["word-spacing"] = prp(wordSpacing)
  }

  fun wordSpacing(wordSpacing: WordSpacing) {
    props["word-spacing"] = prp(wordSpacing)
  }

  fun wordWrap(wordWrap: WordWrap) {
    props["word-wrap"] = prp(wordWrap)
  }

  fun writingMode(writingMode: WritingMode) {
    props["writing-mode"] = prp(writingMode)
  }

  fun zIndex(zIndex: Int) {
    props["z-index"] = prp(zIndex.toString())
  }

  fun zIndex(zIndex: ZIndex) {
    props["z-index"] = prp(zIndex)
  }
}

@CssTagMarker
open class Style : InlineStyle() {
  var fontFace: FontFace? = null
  var keyFrames: MutableMap<String, KeyFrames> = mutableMapOf()

  private fun addStyle(selector: String, style: Css) {
    definitions[selector] = definitions[selector] ?: mutableListOf()
    definitions[selector]?.add(style)
  }

  /**
   * like the scss &
   */
  fun and(vararg selectors: DescriptionProvider, style: Css) {
    for (selector in selectors) {
      addStyle(selector.description(), style)
    }
  }

  fun and(vararg selectors: String, style: Css) {
    for (selector in selectors) {
      addStyle(selector, style)
    }
  }

  fun select(vararg selectors: DescriptionProvider, style: Css) {
    for (selector in selectors) {
      addStyle(" ${selector.description()}", style)
    }
  }

  fun select(vararg selectors: String, style: Css) {
    for (selector in selectors) {
      addStyle(" $selector", style)
    }
  }

  fun descendant(vararg descNames: DescriptionProvider, style: Css) {
    for (descName in descNames) {
      addStyle(" ${descName.description()}", style)
    }
  }

  fun descendant(vararg descNames: String, style: Css) {
    for (descName in descNames) {
      addStyle(" $descName", style)
    }
  }

  fun child(vararg childNames: DescriptionProvider, style: Css) {
    for (childName in childNames) {
      addStyle(" > ${childName.description()}", style)
    }
  }

  fun child(vararg childNames: String, style: Css) {
    for (childName in childNames) {
      addStyle(" > $childName", style)
    }
  }

  fun sibling(vararg childNames: DescriptionProvider, style: Css) {
    for (childName in childNames) {
      addStyle(" ~ ${childName.description()}", style)
    }
  }

  fun sibling(vararg childNames: String, style: Css) {
    for (childName in childNames) {
      addStyle(" ~ $childName", style)
    }
  }

  fun adjSibling(vararg childNames: DescriptionProvider, style: Css) {
    for (childName in childNames) {
      addStyle(" + ${childName.description()}", style)
    }
  }

  fun adjSibling(vararg childNames: String, style: Css) {
    for (childName in childNames) {
      addStyle(" + $childName", style)
    }
  }

  fun firstChild(style: Css) {
    addStyle(":first-child", style)
  }

  fun lastChild(style: Css) {
    addStyle(":last-child", style)
  }

  fun pseudoElement(selector: DescriptionProvider, style: Css) {
    addStyle(":${selector.description()}", style)
  }

  fun pseudoChild(selector: DescriptionProvider, style: Css) {
    addStyle("::${selector.description()}", style)
  }

  fun not(name: DescriptionProvider): DescriptionProvider = ValueDescriptionProvider(":not(${name.description()})")
  @Deprecated("Use select(not(...)) instead.")
  fun not(selector: DescriptionProvider, style: Css) {
    addStyle(":not(${selector.description()})", style)
  }

  fun fontFace(face: FontFace.() -> Unit) {
    fontFace = FontFace()

    face.invoke(fontFace!!)
  }

  fun import(style: Css) {
    style(this)
  }

  fun keyFrames(animationName: String, frames: KeyFrames.() -> Unit) {
    val frameCss = KeyFrames()

    frames.invoke(frameCss)

    keyFrames[animationName] = frameCss
  }
}

@CssTagMarker
open class ConditionalStyle : Style() {
  var media: MutableMap<String, ConditionalCss> = mutableMapOf()
  var supports: MutableMap<String, ConditionalCss> = mutableMapOf()

  fun media(definition: String, style: ConditionalCss) {
    media[definition] = style
  }

  fun supports(query: String, style: ConditionalCss) {
    supports[query] = style
  }
}
