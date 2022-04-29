buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.plugin.gradle)
        classpath("com.android.tools.build:gradle:7.1.3")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}