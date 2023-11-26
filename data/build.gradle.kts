plugins {
    id(Plugins.Module.androidLibrary)
    id(Plugins.Module.kotlinAndroid)
    id(Plugins.Module.kotlinSerialization)
    id(Plugins.Module.hiltAndroid)
    id(Plugins.Module.kotlinKapt)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }

    compileOptions {
        sourceCompatibility = AppConfig.javaVersion
        targetCompatibility = AppConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = AppConfig.javaVersion.toString()
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(Dep.Kotlin.serialization)
    implementation(Dep.Coroutine.core)

    Dep.Hilt.apply {
        implementation(android)
        kapt(androidCompiler)
    }
}