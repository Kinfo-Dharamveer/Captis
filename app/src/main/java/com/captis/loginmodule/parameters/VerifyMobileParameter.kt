package com.captis.loginmodule.parameters

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class VerifyMobileParameter{

    @SerializedName("mobile")
    @Expose
    var mobile: String = ""

}