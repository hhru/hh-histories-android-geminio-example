import ru.hh.buildsrc.*

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
    }
}

dependencies {
    // RxJava
    implementation(Libs.Rx.rxJava)
    implementation(Libs.Rx.rxAndroid)

    // Network
    implementation(Libs.OkHttp.okHttp)
    implementation(Libs.OkHttp.okHttpLoggingInterceptor)
    implementation(Libs.Network.kotlinxSerializationJson)
    implementation(Libs.Network.retrofit)
    implementation(Libs.Network.retrofitKotlinxConverter)
    implementation(Libs.Network.adapterRxJava2)
    implementation(Libs.Network.gson)

    // UI
    implementation(Libs.Core.appCompat)

    // di
    implementation(Libs.Toothpick.core)

    implementation(Libs.GlideLibraries.core)
}
