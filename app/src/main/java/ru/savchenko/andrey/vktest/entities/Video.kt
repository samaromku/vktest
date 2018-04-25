package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class Video(
        @SerializedName("id")
        @Expose
        val id: Int = 0,
        @SerializedName("owner_id")
        @Expose
        val ownerId: Int = 0,
        @SerializedName("title")
        @Expose
        val title: String? = null,
        @SerializedName("duration")
        @Expose
        val duration: Int = 0,
        @SerializedName("description")
        @Expose
        val description: String? = null,
        @SerializedName("date")
        @Expose
        val date: Int = 0,
        @SerializedName("comments")
        @Expose
        val comments: Int = 0,
        @SerializedName("views")
        @Expose
        val views: Int = 0,
        @SerializedName("photo_130")
        @Expose
        val photo130: String? = null,
        @SerializedName("photo_320")
        @Expose
        val photo320: String? = null,
        @SerializedName("photo_640")
        @Expose
        val photo640: String? = null,
        @SerializedName("access_key")
        @Expose
        val accessKey: String? = null,
        @SerializedName("platform")
        @Expose
        val platform: String? = null,
        @SerializedName("can_edit")
        @Expose
        val canEdit: Int = 0,
        @SerializedName("can_add")
        @Expose
        val canAdd: Int = 0
) {

}