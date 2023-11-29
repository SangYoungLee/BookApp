buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
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