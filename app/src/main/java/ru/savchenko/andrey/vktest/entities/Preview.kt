package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class Preview(
        @SerializedName("photo")
        @Expose
        val photo: Photo__? = null,
        @SerializedName("video")
        @Expose
        val video: Video_? = null
) 