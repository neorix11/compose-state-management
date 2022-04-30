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
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}