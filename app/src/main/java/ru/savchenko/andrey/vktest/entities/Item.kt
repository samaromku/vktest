package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
class Item(
        @SerializedName("id")
        @Expose
        val id: Int = 0,
        @SerializedName("from_id")
        @Expose
        val fromId: Int = 0,
        @SerializedName("owner_id")
        @Expose
        val ownerId: Int = 0,
        @SerializedName("date")
        @Expose
        val date: Int = 0,
        @SerializedName("post_type")
        @Expose
        val postType: String? = null,
        @SerializedName("text")
        @Expose
        val text: String? = null,
        @SerializedName("can_delete")
        @Expose
        val canDelete: Int = 0,
        @SerializedName("can_pin")
        @Expose
        val canPin: Int = 0,
        @SerializedName("attachments")
        @Expose
        val attachments: List<Attachment>? = null,
        @SerializedName("post_source")
        @Expose
        val postSource: PostSource? = null,
        @SerializedName("comments")
        @Expose
        val comments: Comments? = null,
        @SerializedName("likes")
        @Expose
        val likes: Likes? = null,
        @SerializedName("reposts")
        @Expose
        val reposts: Reposts? = null,
        @SerializedName("views")
        @Expose
        val views: Views? = null,
        @SerializedName("copy_history")
        @Expose
        val copyHistory: List<CopyHistory>? = null
)