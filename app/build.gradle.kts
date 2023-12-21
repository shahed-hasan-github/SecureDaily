plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.shoppingapp.securedaily.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.shoppingapp.securedaily.app"
        minSdk = 24
        targetSdk = 33
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

    buildFeatures{
        dataBinding = true
        viewBinding = true
    }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth:22.3.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.google.android.gms:play-services-auth:20.7.0")

    implementation ("com.google.android.gms:play-services-vision:20.1.3")
    implementation ("com.google.firebase:firebase-ml-vision-barcode-model:16.1.2")

    implementation ("com.airbnb.android:lottie:3.7.1")

    implementation ("com.google.android.play:core:1.10.3")
    implementation ("com.google.android.play:core-ktx:1.8.1")

    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation ("com.anjlab.android.iab.v3:library:1.0.44")

    implementation ("com.google.android.gms:play-services-vision:20.1.3")

    implementation ("com.android.support:multidex:1.0.3")

    implementation ("com.google.firebase:firebase-ml-vision-barcode-model:16.1.2")

}
