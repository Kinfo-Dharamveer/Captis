package com.captis.loginmodule.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class VerifyCodeModel {

    @SerializedName("status")
    @Expose
    var status: Int = 0
    @SerializedName("isSuccess")
    @Expose
    var isSuccess: Boolean = false
    @SerializedName("message")
    @Expose
    var message: String = ""

}