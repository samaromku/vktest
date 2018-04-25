package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class Response(
        @SerializedName("count")
        @Expose
        var count: Int = 0,
        @SerializedName("items")
        @Expose
        var items: List<Item>? = null
)