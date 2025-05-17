plugins {
    kotlin("jvm") version "2.1.20"
    id("java-library")
    id("maven-publish")
}

group = "uk.co.stevebosman.grid"
version = "0.0.2-SNAPSHOT"


publishing {
    publications {
        val sourcesJar by tasks.registering(Jar::class) {
            from(sourceSets.main.get().allSource)
        }
        register("mavenJava", MavenPublication::class) {
            tasks.named("generateMetadataFileForReleasePublication").configure {
                dependsOn("sourcesJar")
            }
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
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
