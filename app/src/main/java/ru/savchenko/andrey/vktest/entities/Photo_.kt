package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class Photo_(
        @SerializedName("id")
        @Expose
        val id: Int = 0,
        @SerializedName("album_id")
        @Expose
        val albumId: Int = 0,
        @SerializedName("owner_id")
        @Expose
        val ownerId: Int = 0,
        @SerializedName("user_id")
        @Expose
        val userId: Int = 0,
        @SerializedName("photo_75")
        @Expose
        val photo75: String? = null,
        @SerializedName("photo_130")
        @Expose
        val photo130: String? = null,
        @SerializedName("photo_604")
        @Expose
        val photo604: String? = null,
        @SerializedName("width")
        @Expose
        val width: Int = 0,
        @SerializedName("height")
        @Expose
        val height: Int = 0,
        @SerializedName("text")
        @Expose
        val text: String? = null,
        @SerializedName("date")
        @Expose
        val date: Int = 0,
        @SerializedName("post_id")
        @Expose
        val postId: Int = 0,
        @SerializedName("access_key")
        @Expose
        val accessKey: String? = null,
        @SerializedName("photo_807")
        @Expose
        val photo807: String? = null,
        @SerializedName("photo_1280")
        @Expose
        val photo1280: String? = null
) {

}