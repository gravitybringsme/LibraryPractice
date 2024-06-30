plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.neppplus.librarypractice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.neppplus.librarypractice"
        minSdk = 21
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.circleimageview)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)  // CircleImageView 라이브러리 추가
    implementation(libs.photoview) // PhotoView 라이브러리 추가
    implementation(libs.glide) // Glide 라이브러리 추가
    implementation(libs.tedpermissionNormal) // TedPermission Normal 추가
    implementation(libs.tedpermissionCoroutine) // TedPermission Coroutine 추가
    implementation(libs.tedpermissionRx2) // TedPermission RxJava2 추가
    implementation(libs.tedpermissionRx3) // TedPermission RxJava3 추가
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}