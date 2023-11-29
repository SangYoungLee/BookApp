plugins {
    id(Plugins.Module.androidLibrary)
    id(Plugins.Module.kotlinAndroid)
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
    implementation(Dep.Lifecycle.viewModel)
    implementation(Dep.Coroutine.core)

    Dep.Compose.run {
        implementation(ui)
        implementation(toolingPreview)
        debugImplementation(tooling)
        implementation(material)
    }
}