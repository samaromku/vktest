package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by savchenko on 25.04.18.
 */
data class Comments (
        @SerializedName("count")
        @Expose
        val count: Int = 0,
        @SerializedName("groups_can_post")
        @Expose
        val groupsCanPost: Boolean = false,
        @SerializedName("can_post")
        @Expose
        val canPost: Int = 0
)