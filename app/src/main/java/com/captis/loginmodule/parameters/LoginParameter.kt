package com.captis.loginmodule.parameters

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginParameter{

    @SerializedName("username")
    @Expose
    var username: String = ""
    @SerializedName("password")
    @Expose
    var password = ""

}