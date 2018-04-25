package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class CopyHistory(
        @SerializedName("id")
        @Expose
        val id: Int = 0,
        @SerializedName("owner_id")
        @Expose
        val ownerId: Int = 0,
        @SerializedName("from_id")
        @Expose
        val fromId: Int = 0,
        @SerializedName("date")
        @Expose
        val date: Int = 0,
        @SerializedName("post_type")
        @Expose
        val postType: String? = null,
        @SerializedName("text")
        @Expose
        val text: String? = null,
        @SerializedName("attachments")
        @Expose
        val attachments: List<Attachment_>? = null,
        @SerializedName("post_source")
        @Expose
        val postSource: PostSource_? = null
) {

}