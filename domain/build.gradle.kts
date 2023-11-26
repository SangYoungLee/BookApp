plugins {
    `java-library`
    id(Plugins.Module.kotlin)
    id(Plugins.Module.kotlinKapt)
    id(Plugins.Module.kotlinSerialization)
}

java {
    sourceCompatibility = AppConfig.javaVersion
    targetCompatibility = AppConfig.javaVersion
}

dependencies {
    Dep.Coroutine.run {
        implementation(core)
        implementation(test)
    }
    implementation(Dep.Java.inject)
    implementation(Dep.Kotlin.serialization)

    testImplementation(Dep.JUnit.junit)
    testImplementation(Dep.Mockito.mockitoKotlin)
}