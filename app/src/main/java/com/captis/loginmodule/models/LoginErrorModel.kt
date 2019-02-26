package com.captis.loginmodule.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginErrorModel {

    @SerializedName("error")
    @Expose
    var error: String? = null
    @SerializedName("error_description")
    @Expose
    var errorDescription = ""

}
