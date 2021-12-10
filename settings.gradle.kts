dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://dl.google.com/dl/android/maven2/index.html")
        maven("https://jitpack.io")
    }
}
rootProject.name = "demo_app"
include(":app")
include(":core")
include(":blank")
include(":gallery")
