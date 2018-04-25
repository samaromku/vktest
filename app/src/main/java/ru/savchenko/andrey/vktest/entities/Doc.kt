package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class Doc(
        @SerializedName("id")
        @Expose
        val id: Int = 0,
        @SerializedName("owner_id")
        @Expose
        val ownerId: Int = 0,
        @SerializedName("title")
        @Expose
        val title: String? = null,
        @SerializedName("size")
        @Expose
        val size: Int = 0,
        @SerializedName("ext")
        @Expose
        val ext: String? = null,
        @SerializedName("url")
        @Expose
        val url: String? = null,
        @SerializedName("date")
        @Expose
        val date: Int = 0,
        @SerializedName("type")
        @Expose
        val type: Int = 0,
        @SerializedName("preview")
        @Expose
        val preview: Preview? = null,
        @SerializedName("access_key")
        @Expose
        val accessKey: String? = null
) {


}