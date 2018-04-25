package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class PostSource_(
        @SerializedName("type")
        @Expose
        val type: String? = null,
        @SerializedName("platform")
        @Expose
        val platform: String? = null
) {

}
