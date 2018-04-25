package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class Reposts(
        @SerializedName("count")
        @Expose
        val count: Int = 0,
        @SerializedName("user_reposted")
        @Expose
        val userReposted: Int = 0

) {

}