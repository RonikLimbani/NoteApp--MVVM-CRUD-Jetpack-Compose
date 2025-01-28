plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt.android)

}

android {
    namespace = "com.ronik.noteapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ronik.noteapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.ronik.noteapp.HiltTestRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
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
    //Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Local unit tests
//    testImplementation "androidx.test:core:1.4.0"
//    testImplementation "androidx.arch.core:core-testing:2.1.0"
    testImplementation (libs.jetbrains.kotlinx.coroutines.test)
    testImplementation (libs.truth)
    testImplementation (libs.mockwebserver)
    testImplementation (libs.mockk)

    // Instrumentation tests
    androidTestImplementation (libs.hilt.android.testing)
    kaptAndroidTest (libs.hilt.android.compiler)
    androidTestImplementation (libs.junit)
    androidTestImplementation (libs.jetbrains.kotlinx.coroutines.test)
    androidTestImplementation (libs.androidx.core.testing)
    androidTestImplementation (libs.truth)
    androidTestImplementation (libs.core.ktx)
    androidTestImplementation (libs.mockwebserver)
    androidTestImplementation (libs.mockk.android)
    androidTestImplementation (libs.androidx.runner)

    androidTestImplementation ("com.linkedin.dexmaker:dexmaker-mockito:2.28.4")



    // Compose dependencies
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)

    // Coroutines
    implementation(libs.kotlinx.coroutines.android)

    //Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
//    kapt("androidx.hilt:hilt-compiler:1.2.0")
    implementation(libs.androidx.hilt.navigation.compose)

    // Room
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)
}