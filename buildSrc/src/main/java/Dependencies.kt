object Dep {
    object AndroidX {
        const val core = "androidx.core:core-ktx:1.9.0"
        const val appcompat = "androidx.appcompat:appcompat:1.3.0"
    }

    object Activity {
        private const val version = "1.6.1"
        const val activity = "androidx.activity:activity-ktx:$version"
        const val compose = "androidx.activity:activity-compose:$version"
    }

    object Compose {
        const val version = "1.3.3"
        const val compilerVersion = "1.4.7"

        const val ui = "androidx.compose.ui:ui:$version"
        const val tool = "androidx.compose.ui:ui-tooling-preview:$version"
        const val material = "androidx.compose.material:material:1.3.1"
        const val liveData = "androidx.compose.runtime:runtime-livedata:$version"
    }

    object Lifecycle {
        private const val lifecycleVersion = "2.6.1"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
    }

    object Kotlin {
        const val version = "1.8.21"

        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1"
    }

    object Coroutine {
        private const val version = "1.7.1"

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    object Java {
        const val inject = "javax.inject:javax.inject:1"
    }

    object Hilt {
        const val version = "2.44"

        const val android = "com.google.dagger:hilt-android:$version"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:$version"
    }

    object Navigation {
        private const val version = "2.5.3"

        const val compose = "androidx.navigation:navigation-compose:$version"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Coil {
        private const val version = "2.4.0"

        const val compose = "io.coil-kt:coil-compose:$version"
    }

    object Ktor {
        private const val version = "2.3.2"

        const val core = "io.ktor:ktor-client-core:$version"
        const val cio = "io.ktor:ktor-client-cio:$version"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
    }

    object JUnit {
        const val junit = "junit:junit:4.13.2"
        const val junitExt = "androidx.test.ext:junit:1.1.5"
    }

    object Mockito {
        const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:4.1.0"
    }

    object Espresso {
        const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
    }
}