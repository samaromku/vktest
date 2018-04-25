package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class Size(
        @SerializedName("src")
        @Expose
        val src: String? = null,
        @SerializedName("width")
        @Expose
        val width: Int = 0,
        @SerializedName("height")
        @Expose
        val height: Int = 0,
        @SerializedName("type")
        @Expose
        val type: String? = null
) {
}