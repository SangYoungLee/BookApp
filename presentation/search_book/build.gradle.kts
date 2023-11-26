plugins {
    id(Plugins.Module.androidLibrary)
    id(Plugins.Module.kotlinAndroid)
    id(Plugins.Module.kotlinKapt)
    id(Plugins.Module.hiltAndroid)
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dep.Compose.compilerVersion
    }
}

dependencies {
    implementation(project(":domain"))
    api(project(":presentation:core"))

    Dep.Compose.run {
        implementation(ui)
        implementation(tool)
        implementation(material)
    }

    Dep.Navigation.run {
        implementation(compose)
        implementation(hiltCompose)
    }

    Dep.Hilt.run {
        implementation(android)
        kapt(androidCompiler)
    }

    implementation(Dep.Coil.compose)
}