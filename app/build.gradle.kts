plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    namespace = "com.mehmetpetek.basesampleapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.mehmetpetek.basesampleapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }



    buildTypes {
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }

    productFlavors {
        create("google") {
            dimension = "platform"
        }
        create("live") {
            dimension = "env"
            applicationId = "com.mehmetpetek.basesampleapp"
            resValue("string", "app_name", "BASE SAMPLE COMPOSE APP")
            buildConfigField("String", "BASE_URL", "\"https://api.imgflip.com/\"")
        }
        create("dev") {
            dimension = "env"
            applicationId = "com.mehmetpetek.basesampleapp.beta"
            resValue("string", "app_name", "BASE SAMPLE COMPOSE APP - BETA")
            buildConfigField("String", "BASE_URL", "\"https://api.imgflip.com/\"")
        }
    }
    flavorDimensions += listOf("platform", "env")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.accompanist.navigation.animation)
    implementation(libs.gson.google)
    lintChecks(libs.lint.checks)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.chucker)
    implementation(libs.coil.kt.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}