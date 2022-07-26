plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.demo.orbit"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    with(libs) {
        //core
        implementation(bundles.androidx.compose)
        implementation(androidx.coreKtx)
        implementation(androidx.activityCompose)
        implementation(bundles.coroutines)

        //navigation
        implementation(androidx.composeUi.nav)

        //di
        implementation(bundles.koin)

        //utility
        implementation(coil)
        implementation(google.accompanist.nav)

        //mvi
        implementation(mvi.orbit.viewmodel)

        implementation(bundles.ktor)

        //test
        testImplementation(junit)
        androidTestImplementation(androidx.test.ext)
        androidTestImplementation(androidx.test.espresso)
        androidTestImplementation(androidx.test.compose.ui)
        debugImplementation(androidx.composeUi.tooling)
    }

    implementation(project(":data"))
    implementation(project(":composables"))
}