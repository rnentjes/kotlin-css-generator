import java.util.*

plugins {
  `maven-publish`
  signing
}

repositories {
  mavenCentral()
}

project.extra.set("PUBLISH_GROUP_ID", "nl.astraeus")
project.extra.set("PUBLISH_VERSION", "1.0.0")
project.extra.set("PUBLISH_ARTIFACT_ID", "kotlin-css-generator")

apply(from = "${rootProject.projectDir}/build.gradle.kts")

// Stub secrets to let the project sync and build without the publication values set up
extra["signing.keyId"] = null
extra["signing.password"] = null
extra["signing.secretKeyRingFile"] = null
extra["ossrhUsername"] = null
extra["ossrhPassword"] = null

// Grabbing secrets from local.properties file or from environment variables, which could be used on CI
val secretPropsFile = project.rootProject.file("local.properties")
if (secretPropsFile.exists()) {
  secretPropsFile.reader().use {
    Properties().apply {
      load(it)
    }
  }.onEach { (name, value) ->
    extra[name.toString()] = value
  }
} else {
  extra["signing.keyId"] = System.getenv("SIGNING_KEY_ID")
  extra["signing.password"] = System.getenv("SIGNING_PASSWORD")
  extra["signing.secretKeyRingFile"] = System.getenv("SIGNING_SECRET_KEY_RING_FILE")
  extra["ossrhUsername"] = System.getenv("OSSRH_USERNAME")
  extra["ossrhPassword"] = System.getenv("OSSRH_PASSWORD")
}

val javadocJar by tasks.registering(Jar::class) {
  archiveClassifier.set("javadoc")
}

fun getExtraString(name: String) = extra[name]?.toString()

publishing {
  // Configure maven central repository
  repositories {
    maven {
      name = "sonatype"
      setUrl("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
      credentials {
        username = getExtraString("ossrhUsername")
        password = getExtraString("ossrhPassword")
      }
    }
  }

  // Configure all publications
  publications.withType<MavenPublication> {

    // Stub javadoc.jar artifact
    artifact(javadocJar.get())

    // Provide artifacts information requited by Maven Central
    pom {
      name.set("kotlin-css-generator")
      description.set("Kotlin css generator")
      url.set("https://github.com/rnentjes/kotlin-css-generator")

      licenses {
        license {
          name.set("MIT")
          url.set("https://opensource.org/licenses/MIT")
        }
      }
      developers {
        developer {
          id.set("rnentjes")
          name.set("Rien Nentjes")
          email.set("info@nentjes.com")
        }
      }
      scm {
        url.set("https://github.com/rnentjes/kotlin-css-generator")
      }
    }
  }
}

// Signing artifacts. Signing.* extra properties values will be used

signing {
  sign(publishing.publications)
}
