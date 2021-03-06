package com.captis.loginmodule.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class ForgotPasswordModel(){

    @SerializedName("Success")
    @Expose
    internal var success: Boolean = false
    @SerializedName("Code")
    @Expose
    internal var code: String = ""
    @SerializedName("Message")
    @Expose
    internal var message: String = ""
}