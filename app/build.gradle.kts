plugins {
    id(Plugins.Module.androidApplication)
    id(Plugins.Module.kotlinAndroid)
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

    Dep.AndroidX.apply {
        implementation(core)
        implementation(appcompat)
    }

    Dep.Activity.apply {
        implementation(activity)
        implementation(compose)
    }

    Dep.Compose.apply {
        implementation(ui)
        implementation(tool)
        implementation(material)
        implementation(liveData)
    }
}