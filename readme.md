# Css generator like less/sass in kotlin multiplatform

This library is for generating css from a kotlin dsl.
It can be used as an alternative to less/sass or as a runtime library to generate css on-the-fly. 

Tools like less and sass are often used as a build step and take some time.
This library is meant to be fast enough to generate the css on the fly either from the server or directly in the browser.

## Usage

Include in build.gradle.kts:

```kotlin
  repositories {
    mavenCentral()
  }

  val commonMain by getting {
    dependencies {
      api("nl.astraeus:kotlin-css-generator:1.0.9")
    }
  }
```

Examples:

## Nesting / colors / variables

```kotlin
    val color = hsla(0, 50, 50, 1.0)
    val backgroundColor = Color.white

    val css = style {
      select(cls("button")) {
        padding(5.px)
        
        select("a") {
          color(color)
          backgroundColor(backgroundColor)

          hover {
            color(color.lighten(10))
            backgroundColor(backgroundColor.darken(10))
          }
        }
      }
    }
```

To generate the css call get generateCss function:

```kotlin
    val cssString: String = css.generateCss()
```

Result:

```css
.button {
    padding:                      5px;
}

.button a {
    color:                        hsla(0, 50%, 50%, 1.0);
    background-color:             white;
}

.button a:hover {
    color:                        hsla(0, 50%, 55%, 1.0);
    background-color:             rgba(229, 229, 229, 1.0);
}
```

There are several options when generating the css, for example minified:


```kotlin
    val cssString: String = css.generateCss(minified = true)
```

Result:

```css
.button{padding:5px;}.buttona{color:hsla(0,50%,50%,1.0);background-color:white;}.buttona:hover{color:hsla(0,50%,55%,1.0);background-color:rgba(229,229,229,1.0);}
```

## Mixins

As it's all just kotlin code, includes and mixins etc. are just functions calls.

```kotlin
   fun Style.borderStyles(borderWidth: Measurement = 2.px) {
      borderWidth(borderWidth)
      borderColor(Color.aquamarine)
      borderStyle(BorderStyle.solid)
    }

    val css = style {
      select(txt("a"), cls("button")) {
        borderStyles()

        color(Color.white)
      }

      select(cls("btn-primary")) {
        borderStyles(3.px)
        color(Color.blue)
      }
    }
```

Result:

```css
a {
    border-width:                 2px;
    border-color:                 aquamarine;
    border-style:                 solid;
    color:                        white;
}

.button {
    border-width:                 2px;
    border-color:                 aquamarine;
    border-style:                 solid;
    color:                        white;
}

.btn-primary {
    border-width:                 3px;
    border-color:                 aquamarine;
    border-style:                 solid;
    color:                        blue;
}
```

Giving the option combineEqualBlocks to the generateCss call will combine the a and .button blocks with the following result:

```css
a,
.button {
  border-width:                 2px;
  border-color:                 aquamarine;
  border-style:                 solid;
  color:                        white;
}

.btn-primary {
  border-width:                 3px;
  border-color:                 aquamarine;
  border-style:                 solid;
  color:                        blue;
}
```

## Measurements

Sizes and widths are given in measurements, there are extension variables to help with these:

```kotlin
  select("body") {
    fontSize(1.2.em)
    borderWidth(3.px)
    width(75.prc)
  }
```

Result:

```css
body {
  font-size:                    1.2em;
  border-width:                 3px;
  width:                        75%;
}
```
