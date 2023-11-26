object Plugins {
    object Root {
        const val androidGradlePlugin = "com.android.tools.build:gradle:7.4.0"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Dep.Kotlin.version}"
        const val serializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${Dep.Kotlin.version}"
        const val hiltAndroidPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Dep.Hilt.version}"
    }

    object Module {
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"

        const val kotlin = "kotlin"
        const val kotlinKapt = "kotlin-kapt"
        const val kotlinAndroid = "org.jetbrains.kotlin.android"
        const val kotlinSerialization = "org.jetbrains.kotlin.plugin.serialization"

        const val hiltAndroid = "com.google.dagger.hilt.android"
    }
}