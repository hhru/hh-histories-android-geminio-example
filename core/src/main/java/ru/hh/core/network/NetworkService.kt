package ru.hh.core.network

import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://api.pexels.com"

    private val loginInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient().newBuilder()
        .addInterceptor(BasicAuthInterceptor())
        .addInterceptor(loginInterceptor)
        .build()

    fun <T> createApi(clazz: Class<T>): T {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(clazz)
    }

    fun createImageUrl(baseUrl: String) =
        GlideUrl(baseUrl, LazyHeaders.Builder().addHeader("Authorization", PEXELS_API_KEY).build())
}


internal class BasicAuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticateRequest = request.newBuilder().addHeader("Authorization", PEXELS_API_KEY).build()
        return chain.proceed(authenticateRequest)
    }
}
