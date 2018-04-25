package ru.savchenko.andrey.vktest.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 25.04.18.
 */
data class Error(
        @SerializedName("error_code")
        @Expose
        val errorCode: Int = 0,
        @SerializedName("error_msg")
        @Expose
        val errorMsg: String? = null,
        @SerializedName("request_params")
        @Expose
        val requestParams: List<RequestParam>? = null
)