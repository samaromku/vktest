package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import android.provider.MediaStore.Video


/**
 * Created by savchenko on 25.04.18.
 */
data class Attachment(
        @SerializedName("type")
        @Expose
        val type: String? = null,
        @SerializedName("video")
        @Expose
        val video: Video? = null,
        @SerializedName("photo")
        @Expose
        val photo: Photo? = null
) {

}