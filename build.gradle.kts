@file:OptIn(ExperimentalWasmDsl::class)

import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform") version "2.1.10"
    id("com.vanniktech.maven.publish") version "0.31.0"
    signing
    id("org.jetbrains.dokka") version "2.0.0"
}

group = "nl.astraeus"
version = "1.1.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js(IR) {
        browser {
/*            testTask {
                // work around, browser test is broken atm
                enabled = false
            }*/
        }
    }

    wasmJs {
        //moduleName = project.name
        browser()

        mavenPublication {
            groupId = group as String
            pom { name = "${project.name}-wasm-js" }
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val jsMain by getting
        val wasmJsMain by getting
    }
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing {
    repositories {
        mavenLocal()
        maven {
            name = "gitea"
            setUrl("https://gitea.astraeus.nl/api/packages/rnentjes/maven")

            credentials() {
                val giteaUsername: kotlin.String? by project
                val giteaPassword: kotlin.String? by project

                username = giteaUsername
                password = giteaPassword
            }
        }
    }
}

signing {
    sign(publishing.publications)
}


tasks.withType<AbstractPublishToMaven> {
    dependsOn(tasks.withType<Sign>())
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(group.toString(), name, version.toString())

    pom {
        name = "kotlin-css-generator"
        description = "Kotlin css generator"
        inceptionYear = "2020"
        url = "https://github.com/rnentjes/kotlin-css-generator"
        licenses {
            license {
                name = "MIT"
                url = "https://opensource.org/licenses/MIT"
            }
        }
        developers {
            developer {
                id = "rnentjes"
                name = "Rien Nentjes"
                email = "info@nentjes.com"
            }
        }
        scm {
            url = "https://github.com/rnentjes/kotlin-css-generator"
        }
    }
}
