plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.compose")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
}

android {
    compileSdk = 36
    namespace = "com.aplussoft.composebottomnavigation"
    defaultConfig {
        applicationId = "com.aplussoft.composebottomnavigation"
        minSdk = 30
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }


    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.6.8"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_17
        sourceCompatibility = JavaVersion.VERSION_17
    }
    buildToolsVersion = "36.0.0"
}

dependencies {
    implementation("androidx.compose.material3:material3:1.4.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.10.0")
    implementation("androidx.compose.material:material-icons-extended:1.7.8")
    implementation("androidx.compose.ui:ui:1.10.0")
    implementation("androidx.activity:activity-compose:1.12.1")
    implementation("androidx.compose.runtime:runtime:1.10.0")

    //navigation
    implementation("androidx.navigation:navigation-compose:2.9.6")
    // kotlin serialization json
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
    implementation("androidx.test.ext:junit-ktx:1.3.0")
    testImplementation(kotlin("test"))
}
