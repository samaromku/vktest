package ru.savchenko.andrey.vktest.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Andrey on 24.04.2018.
 */
object NetworkHandler {
    private val BASE_HOST_INNER = "https://api.vk.com"

    fun getService(): VkService {
        val client: OkHttpClient = OkHttpClient
                .Builder()
                .addInterceptor(HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

        //real server
        return Retrofit.Builder()
                .baseUrl(BASE_HOST_INNER)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(VkService::class.java)
    }

}