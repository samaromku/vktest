package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class Likes(
        @SerializedName("count")
        @Expose
        val count: Int = 0,
        @SerializedName("user_likes")
        @Expose
        val userLikes: Int = 0,
        @SerializedName("can_like")
        @Expose
        val canLike: Int = 0,
        @SerializedName("can_publish")
        @Expose
        val canPublish: Int = 0
) {

}