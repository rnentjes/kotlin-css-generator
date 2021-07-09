plugins {
    kotlin("multiplatform") version "1.4.32"
    `maven-publish`
}

group = "nl.astraeus"
version = "0.4.28"

repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    mavenLocal()
    mavenCentral()
}

kotlin {
    jvm()
    js(BOTH) {
        browser {
            testTask {
                useKarma {
                    useFirefox()
                    //useChrome()
                }
            }
        }
    }

    sourceSets {
        val commonMain by getting {}
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}

publishing {
    repositories {
        maven {
            name = "releases"
            // change to point to your repo, e.g. http://my.org/repo
            url = uri("http://nexus.astraeus.nl/nexus/content/repositories/releases")
            credentials {
                val nexusUsername: String by project
                val nexusPassword: String by project

                username = nexusUsername
                password = nexusPassword
            }
        }
        maven {
            name = "snapshots"
            // change to point to your repo, e.g. http://my.org/repo
            url = uri("http://nexus.astraeus.nl/nexus/content/repositories/snapshots")
            credentials {
                val nexusUsername: String by project
                val nexusPassword: String by project

                username = nexusUsername
                password = nexusPassword
            }
        }
    }
/*
    publications {
        val kotlinMultiplatform by getting {
            artifactId = "kotlin-css-generator"
        }
    }
*/
}
