package ru.savchenko.andrey.vktest.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.savchenko.andrey.vktest.entities.VKResponse

/**
 * Created by Andrey on 24.04.2018.
 */
interface VkService {
    @GET("/method/wall.get")
    fun getNews(@Query("access_token") token: String,
                @Query("v") version: String,
                @Query("owner_id")ownerId:String): Single<VKResponse>
}