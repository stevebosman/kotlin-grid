plugins {
    kotlin("jvm") version "2.1.20"
    id("java-library")
    id("maven-publish")
    kotlin("plugin.lombok") version "2.1.21"
    id("io.freefair.lombok") version "8.13"
}

group = "uk.co.stevebosman"
version = "0.0.8"

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/stevebosman/kotlin-grid")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
