import org.gradle.api.JavaVersion

object AppConfig {
    const val compileSdk = 33
    const val buildTools = "33.0.1"

    const val minSdk = 24
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0.0"

    val javaVersion = JavaVersion.VERSION_17

    const val applicationId = "com.syapp.bookapp"
}