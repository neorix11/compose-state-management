pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "ComposeStateManagement"
include(":redux")
include(":orbit")
include(":bloc")
include(":mavericks")

enableFeaturePreview("VERSION_CATALOGS")
