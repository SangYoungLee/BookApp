buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        Plugins.Root.run {
            classpath(androidGradlePlugin)
            classpath(gradlePlugin)
            classpath(serializationPlugin)
            classpath(hiltAndroidPlugin)
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}