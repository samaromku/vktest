package ru.savchenko.andrey.vktest.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Andrey on 24.04.2018.
 */
interface VkService {
    @GET("/method//newsfeed.getRecommended/access_token={token}&v=5.74")
    fun getNews(@Path("token")token:String): Call<String>
}