object Versions {

    const val kotlin = "1.5.20"
    const val androidPlugin = "7.0.4"
    const val core = "1.7.0"
    const val appCompat = "1.4.0"
    const val navigation = "2.3.5"
    const val material = "1.4.0"
    const val constraintLayout = "2.1.2"
    const val jUnit = "4.13.2"
    const val jUnitExtension = "1.1.3"
    const val mockk = "1.10.2"
    const val coreAndroidTest = "2.1.0"
    const val espresso = "3.4.0"
    const val lifecycle = "2.4.0"
    const val retrofit2 = "2.9.0"
    const val okLogging = "4.8.0"
    const val gson = "2.8.6"
    const val coroutines = "1.5.2"
    const val coroutinesAdapter = "0.9.2"
    const val glide = "4.12.0"
    const val intuit = "1.0.6"
    const val timber = "4.7.1"
    const val koin = "2.0.1"
}

object AndroidX{

    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val navigationRunTime = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val jUnitExtension = "androidx.test.ext:junit:${Versions.jUnitExtension}"
    const val coreAndroidTest = "androidx.arch.core:core-testing:${Versions.coreAndroidTest}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Android {

    const val minSdk = 21
    const val targetSdk = 31
    const val applicationId = "com.example.cleanarchitectureapp"
    const val versionCode = 1
    const val versionName = "1.0"
}

object Kotlin {

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
}

object Retrofit2{

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2}"
    const val okLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okLogging}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}

object Modules{

    const val presentation = ":presentation"
    const val domain = ":domain"
    const val data = ":data"
}

object Coroutines{

    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutinesAdapter}"
    const val coroutinesTest =  "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}

object Koin{

    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val androidScope = "org.koin:koin-android-scope:${Versions.koin}"
    const val androidViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
}

object Glide{

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object JUnit{

    const val jUnit = "junit:junit:${Versions.jUnit}"
}

object Mockk{

    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
}

object Libs{

    const val material = "com.google.android.material:material:${Versions.material}"
    const val intuitSdp = "com.intuit.sdp:sdp-android:${Versions.intuit}"
    const val intuitSsp = "com.intuit.ssp:ssp-android:${Versions.intuit}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object GradlePlugins {

    const val android = "android"
    const val androidApplication = "com.android.application"
    const val kotlin = "kotlin"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinParcelize = "kotlin-parcelize"
    const val kotlinKapt = "kotlin-kapt"
    const val javaLib = "java-library"
    const val androidLib = "com.android.library"
}

object BuildPlugins {

    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object BuildType {

    const val debug = "debug"
    const val release = "release"
    const val minifyRelease = false
    const val proguardRelease = "proguard-rules.pro"
    const val minifyDebug = false
    const val proguardDebug = "proguard-rules.pro"
}