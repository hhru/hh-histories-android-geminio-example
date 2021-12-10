import ru.hh.buildsrc.*

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = AppConfig.compileSdk
}

dependencies {
    // RxJava
    implementation(Libs.Rx.rxJava)
    implementation(Libs.Rx.rxAndroid)

    // Network
    implementation(Libs.Network.retrofit)
    implementation(Libs.Network.retrofitKotlinxConverter)
    implementation(Libs.Network.gson)
    implementation(project(":core"))

    // UI
    implementation(Libs.Core.appCompat)
    implementation(Libs.Core.recyclerView)

    // MVI
    implementation(Libs.Mvi.core)
    implementation(Libs.Mvi.binder)

    // Toothpick
    kapt(Libs.Toothpick.compiler)
    implementation(Libs.Toothpick.core)
    implementation(Libs.Toothpick.smoothieSupport)
    implementation(Libs.Toothpick.viewmodelKtp)

    // Glide
    implementation(Libs.GlideLibraries.core)

    implementation(Libs.Paging.core)
    implementation(Libs.Paging.rx)
}
