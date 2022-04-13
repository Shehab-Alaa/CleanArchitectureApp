plugins {
    id(GradlePlugins.androidApplication)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinKapt)
}

android {
    compileSdk = Android.targetSdk

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = InstrumentationRunner.customTestRunner
    }

    buildTypes {
        getByName(BuildType.release) {
            isMinifyEnabled = BuildType.minifyRelease
            proguardFiles(BuildType.proguardRelease)
        }

        getByName(BuildType.debug) {
            isMinifyEnabled = BuildType.minifyDebug
            proguardFiles(BuildType.proguardDebug)
            isTestCoverageEnabled = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = Kotlin.kotlinJvmTarget
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    // Core
    implementation(Kotlin.kotlin)
    implementation(AndroidX.core)
    implementation(AndroidX.appCompat)
    implementation(Libs.material)
    implementation(AndroidX.constraintLayout)

    // Modules
    implementation(project(Modules.domain))
    implementation(project(Modules.presentation))
    implementation(project(Modules.data))

    // Navigation
    implementation(AndroidX.navigationFragment)
    implementation(AndroidX.navigationUi)

    // Timber
    implementation(Libs.timber)

    // Koin
    implementation(Koin.koinAndroid)
    implementation(Koin.androidScope)
    implementation(Koin.androidViewModel)

    // Data Binding
    kapt(Libs.dataBindingCompiler)

    // Gson Parse
    implementation(Retrofit2.gson)

    // Test
    testImplementation(JUnit.jUnit)
    testImplementation(AndroidX.coreAndroidTest)
    testImplementation(Coroutines.coroutinesTest)
    testImplementation(Mockk.mockk)
    androidTestImplementation(Mockk.mockkAndroid)
    androidTestImplementation(AndroidX.jUnitExtension)
    androidTestImplementation(AndroidX.espresso)
    androidTestImplementation(AndroidX.testRunner)
    androidTestImplementation(AndroidX.testRules)
    debugImplementation(AndroidX.fragmentTest)
}