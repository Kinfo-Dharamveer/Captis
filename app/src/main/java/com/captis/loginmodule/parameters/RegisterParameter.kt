package com.captis.loginmodule.parameters

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterParameter{

    @SerializedName("username")
    @Expose
    var username: String = ""
    @SerializedName("email")
    @Expose
    var email = ""
    @SerializedName("password")
    @Expose
    var password = ""

}