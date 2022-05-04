plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

        implementation(google.accompanist.nav)

        implementation(androidx.appcompat)
        implementation(google.material)
        implementation(coil)

        testImplementation(junit)
        androidTestImplementation(androidx.test.ext)
        androidTestImplementation(androidx.test.espresso)
    }

    implementation(project(":data"))
}