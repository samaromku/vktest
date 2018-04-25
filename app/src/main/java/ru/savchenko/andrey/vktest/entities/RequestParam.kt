package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class RequestParam(
        @SerializedName("key")
        @Expose
        val key: String? = null,
        @SerializedName("value")
        @Expose
        val value: String? = null
)