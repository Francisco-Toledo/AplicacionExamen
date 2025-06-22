plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace     = "com.utad.aplicacionexamen"
    compileSdk    = 34               // 34 = Android 14 estable. Si quieres usar 35 preview basta con tener el SDK.

    defaultConfig {
        applicationId       = "com.utad.aplicacionexamen"
        minSdk              = 26    // 31 era innecesariamente alto; 24 ya soporta coroutines y Material 3
        targetSdk           = 34
        versionCode         = 1
        versionName         = "1.0"
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

    buildFeatures {
        viewBinding = true    // <── ✅ ACTIVA ESTO
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
    // ---- AndroidX núcleo ----
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // ---- UI / RecyclerView ----
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")

    // Extensiones KTX para Activity (incluye viewModels delegate)
    implementation ("androidx.activity:activity-ktx:1.9.0")

    // ViewModel + LiveData en versión alineada
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    // ---- Architecture Components ----
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.1")

    // ---- Retrofit + Gson ----
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // ---- Coroutines ----
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")

    // ---- Glide ----
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // ---- Tests ----
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.0")
}
