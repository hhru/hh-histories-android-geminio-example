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
    implementation(project(":core"))
    kapt(Libs.Toothpick.compiler)
    implementation(Libs.Toothpick.core)
    implementation(Libs.Network.retrofit)
    implementation(Libs.Network.retrofitKotlinxConverter)
    implementation(Libs.Network.gson)
    implementation(Libs.Rx.rxJava)
    implementation(Libs.Paging.core)
    implementation(Libs.Paging.rx)
    implementation(Libs.Mvi.core)
    implementation(Libs.Mvi.binder)
    implementation(Libs.Rx.rxAndroid)
    implementation(Libs.Core.appCompat)
    implementation(Libs.Core.recyclerView)
    implementation(Libs.Toothpick.smoothieSupport)
    implementation(Libs.Toothpick.viewmodelKtp)
    implementation(Libs.GlideLibraries.core)
}
