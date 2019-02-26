package com.captis.loginmodule.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class VerifyMobileModel {

    @SerializedName("status")
    @Expose
    var status: Int = 0
    @SerializedName("verificationCode")
    @Expose
    var verificationCode: String = ""
    @SerializedName("isSuccess")
    @Expose
    var isSuccess: Boolean = false
    @SerializedName("message")
    @Expose
    var message: String = ""

}