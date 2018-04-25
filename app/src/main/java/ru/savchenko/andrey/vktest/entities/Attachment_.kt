package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class Attachment_(
        @SerializedName("type")
        @Expose
        val type: String? = null,
        @SerializedName("photo")
        @Expose
        val photo: Photo_? = null,
        @SerializedName("doc")
        @Expose
        val doc: Doc? = null,
        @SerializedName("video")
        @Expose
        val video: Video__? = null
) {

}