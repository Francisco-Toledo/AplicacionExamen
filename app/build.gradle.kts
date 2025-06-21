plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.utad.aplicacionexamen"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.utad.aplicacionexamen"
        minSdk = 31
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.11.02")

    // ConstraintLayout (opcional si usas)
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

    // RecyclerView y CardView
    implementation ("androidx.recyclerview:recyclerview:1.3.22")
    implementation ("androidx.cardview:cardview:1.0.0")

    // ViewModel y LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.02")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.02")

    // Retrofit + Gson
    implementation ("com.squareup.retrofit2:retrofit:2.9.02")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Glide para imágenes
    implementation ("com.github.bumptech.glide:glide:4.16.0")


    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}
