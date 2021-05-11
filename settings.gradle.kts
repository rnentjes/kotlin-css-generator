pluginManagement {
    repositories {
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }

        mavenCentral()

        maven { setUrl("https://plugins.gradle.org/m2/") }
    }
}

rootProject.name = "kotlin-css-generator"

enableFeaturePreview("GRADLE_METADATA")
