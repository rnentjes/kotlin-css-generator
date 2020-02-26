plugins {
    kotlin("multiplatform") version "1.3.70-eap-184"
}

group = "nl.astraeus"
version = "0.1.0-SNAPSHOT"

repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
}

apply(plugin = "kotlin-dce-js")

kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */
    jvm()
    js {
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))

                implementation("io.github.microutils:kotlin-logging-common:1.7.8")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                //implementation(kotlin("test-annotations-common"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(kotlin("stdlib-js"))

                implementation("io.github.microutils:kotlin-logging-js:1.7.8")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
                //implementation(kotlin("test-annotations-js"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))

                implementation("org.slf4j:slf4j-api:1.7.29")
                implementation("org.slf4j:slf4j-simple:1.7.29")
                implementation("io.github.microutils:kotlin-logging:1.7.8")
            }
        }
    }
}
