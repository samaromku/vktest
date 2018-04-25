package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class VKResponse(
        @SerializedName("response")
        @Expose
        val response: Response? = null,
        @SerializedName("error")
        @Expose
        val error: Error? = null
)