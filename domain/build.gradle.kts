plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlinx-serialization")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {

    with(libs) {
        implementation(serialization)
        implementation(coroutines.core)

    }

    implementation("dev.icerock.moko:parcelize:0.8.0")
}