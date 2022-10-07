package com.viona.omo.data.response.base

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    var code: Int? = null,

    @SerializedName("status")
    val status: Boolean = false,

    @SerializedName("message")
    val message: String? = null
)