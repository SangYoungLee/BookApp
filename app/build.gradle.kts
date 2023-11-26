plugins {
    id(Plugins.Module.androidApplication)
    id(Plugins.Module.kotlinAndroid)
    id(Plugins.Module.kotlinKapt)
    id(Plugins.Module.hiltAndroid)
}

android {
    namespace = AppConfig.applicationId
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
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
    implementation(project(":data"))
    implementation(project(":presentation:search_book"))

    Dep.AndroidX.run {
        implementation(core)
        implementation(appcompat)
    }

    Dep.Activity.run {
        implementation(activity)
        implementation(compose)
    }

    Dep.Compose.run {
        implementation(ui)
        implementation(tool)
        implementation(material)
        implementation(liveData)
    }

    Dep.Hilt.run {
        implementation(android)
        kapt(androidCompiler)
    }

    Dep.Navigation.run {
        implementation(compose)
    }
}