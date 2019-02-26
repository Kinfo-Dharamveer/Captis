package com.captis.loginmodule.parameters

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VerifyCodeParameter{

    @SerializedName("verificationCode")
    @Expose
    var verificationCode: String = ""
    @SerializedName("verificationType")
    @Expose
    var verificationType = ""

}