package ru.hh.buildsrc

object Libs {

    object Core {
        private const val core_ktx = "1.3.2"
        private const val app_compat_version = "1.2.0"
        private const val material_version = "1.3.0"
        private const val recyclerViewVersion = "1.1.0"

        const val coreKtx = "androidx.core:core-ktx:$core_ktx"
        const val appCompat = "androidx.appcompat:appcompat:$app_compat_version"
        const val material = "com.google.android.material:material:$material_version"
        const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerViewVersion"
    }

    object Rx {
        private const val rxJavaVersion = "2.2.9"
        private const val rxAndroidVersion = "2.1.1"

        const val rxJava = "io.reactivex.rxjava2:rxjava:$rxJavaVersion"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:$rxAndroidVersion"
    }

    object Network {
        private const val kotlinxSerializationVersion = "1.1.0"
        private const val retrofitKotlinxConverterVersion = "0.8.0"
        private const val retrofitVersion = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val gson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val kotlinxSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion"
        const val retrofitKotlinxConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$retrofitKotlinxConverterVersion"
        const val adapterRxJava2 = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
    }

    object OkHttp {
        private const val okhttp3Version = "4.9.1"

        const val okHttp = "com.squareup.okhttp3:okhttp:${okhttp3Version}"
        const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${okhttp3Version}"
    }

    object Mvi {
        private const val mviCoreVersion = "1.2.6"

        const val core = "com.github.badoo.mvicore:mvicore:$mviCoreVersion"
        const val binder = "com.github.badoo.mvicore:binder:$mviCoreVersion"
    }

    object Toothpick {
        private const val toothpickVersion = "3.1.0"

        const val core = "com.github.stephanenicolas.toothpick:ktp:$toothpickVersion"
        const val viewmodelKtp =
            "com.github.stephanenicolas.toothpick:smoothie-lifecycle-viewmodel-ktp:$toothpickVersion"
        const val smoothieSupport = "com.github.stephanenicolas.toothpick:smoothie-support:$toothpickVersion"
        const val compiler = "com.github.stephanenicolas.toothpick:toothpick-compiler:$toothpickVersion"
    }

    object Paging {
        private const val pagingVersion = "3.0.1"

        const val core = "androidx.paging:paging-runtime:$pagingVersion"
        const val rx = "androidx.paging:paging-rxjava2-ktx:$pagingVersion"
    }

    object GlideLibraries {
        private const val glideVersion = "4.11.0"

        const val core = "com.github.bumptech.glide:glide:$glideVersion"
    }

}
