plugins {
    id(GradlePlugins.androidLib)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinKapt)
    id(GradlePlugins.kotlinParcelize)
}

android {
    compileSdkVersion(Android.targetSdk)

    defaultConfig {
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)

        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    // Core
    implementation(AndroidX.core)
    implementation(AndroidX.appCompat)
    implementation(Libs.material)

    // Modules
    implementation(project(Modules.domain))

    // Navigation
    implementation(AndroidX.navigationRunTime)

    // Test
    testImplementation(JUnit.jUnit)
    testImplementation(AndroidX.coreAndroidTest)
    testImplementation(Coroutines.coroutinesTest)
    testImplementation(Mockk.mockk)
    androidTestImplementation(Mockk.mockkAndroid)
    androidTestImplementation(AndroidX.espresso)
    androidTestImplementation(AndroidX.jUnitExtension)

    // ViewModel
    implementation(AndroidX.lifecycleLiveData)
    implementation(AndroidX.lifecycleViewModel)

    // Coroutines
    implementation(Coroutines.kotlinCoroutines)

    // Glide
    implementation(Glide.glide)
    implementation(Glide.glideCompiler)

    // Support diff screen sizes
    implementation(Libs.intuitSdp)
    implementation(Libs.intuitSsp)

    // Timber
    implementation(Libs.timber)

    // Koin
    implementation(Koin.koinAndroid)
    implementation(Koin.androidScope)
    implementation(Koin.androidViewModel)
}