package com.captis.loginmodule.parameters

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ForgotPasswordParameter{

    @SerializedName("email")
    @Expose
    var email: String = ""

}