dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "BookApp"
include(":app")
include(":domain")
include(":data")
include(":presentation:core")
include(":presentation:search_book")
include(":presentation:detail_book")
