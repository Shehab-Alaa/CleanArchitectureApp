plugins {
    id(GradlePlugins.javaLib)
    id(GradlePlugins.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies {

    // Test
    testImplementation(JUnit.jUnit)
    testImplementation(Coroutines.coroutinesTest)
}