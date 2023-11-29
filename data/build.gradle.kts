import java.util.Properties
import java.io.FileInputStream

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

        val localProperties = Properties().apply {
            load(FileInputStream(rootProject.file("local.properties")))
        }
        buildConfigField("String", "baseUrl", "\"${localProperties.getProperty("baseUrl")}\"")
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

    Dep.Hilt.run {
        implementation(android)
        kapt(androidCompiler)
    }

    Dep.Ktor.run {
        implementation(core)
        implementation(cio)
        implementation(contentNegotiation)
        implementation(serialization)
        implementation(logging)
    }
}