plugins {
    id(GradlePlugins.androidLib)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinKapt)
}

android {
    compileSdk = Android.targetSdk

    defaultConfig {
        minSdk = Android.minSdk
        targetSdk = Android.targetSdk

        testInstrumentationRunner = InstrumentationRunner.instrumentationRunner
        consumerProguardFiles(ConsumerRules.pro)
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

}


dependencies {

    // Core
    implementation(AndroidX.core)
    implementation(AndroidX.appCompat)
    implementation(Libs.material)

    // Modules
    implementation(project(Modules.domain))

    // Test
    testImplementation(JUnit.jUnit)
    testImplementation(AndroidX.coreAndroidTest)
    testImplementation(Mockk.mockk)
    androidTestImplementation(Mockk.mockkAndroid)
    androidTestImplementation(AndroidX.jUnitExtension)

    // Koin
    implementation(Koin.koinAndroid)
    implementation(Koin.androidScope)
    implementation(Koin.androidViewModel)

    // Retrofit2
    implementation(Retrofit2.retrofit)
    implementation(Retrofit2.gsonConverter)
    implementation(Retrofit2.okLogging)
    implementation(Retrofit2.gson)

    // Coroutines
    implementation(Coroutines.kotlinCoroutines)
    implementation(Coroutines.coroutinesAdapter)
}