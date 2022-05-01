buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.plugin.gradle)
        classpath(libs.buildTools)
        classpath(libs.serialization)
        classpath(kotlin("serialization", version = libs.versions.kotlin.get()))
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}