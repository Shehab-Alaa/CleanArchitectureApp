// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter() // Warning: this repository is going to shut down soon
        mavenCentral()
    }
    dependencies {
        classpath(kotlin(module = "gradle-plugin", version = Versions.kotlin))
        classpath (BuildPlugins.androidPlugin)
        classpath (BuildPlugins.kotlinPlugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter() // Warning: this repository is going to shut down soon
        mavenCentral()
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}