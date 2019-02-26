package com.captis.loginmodule.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginModel {

    @SerializedName("results")
    @Expose
    var results: List<Result> = emptyList()
    @SerializedName("status")
    @Expose
    var status: Int = 0
    @SerializedName("isSuccess")
    @Expose
    var isSuccess: Boolean = false
    @SerializedName("message")
    @Expose
    var message: String = ""

    inner class Result {

        @SerializedName("id")
        @Expose
        var id: Int? = null
        @SerializedName("userName")
        @Expose
        var userName: String = ""
        @SerializedName("name")
        @Expose
        var name: String = ""
        @SerializedName("image")
        @Expose
        var image: String = ""
        @SerializedName("webSite")
        @Expose
        var webSite: String = ""
        @SerializedName("bio")
        @Expose
        var bio: String = ""
        @SerializedName("mobile")
        @Expose
        var mobile: String = ""
        @SerializedName("gender")
        @Expose
        var gender: String = ""
        @SerializedName("email")
        @Expose
        var email: String = ""
        @SerializedName("isNotification")
        @Expose
        var isNotification: String = ""
        @SerializedName("verificationType")
        @Expose
        var verificationType: String = ""
        @SerializedName("verificationCode")
        @Expose
        var verificationCode: String = ""
        @SerializedName("isVerified")
        @Expose
        var isVerified: String = ""
        @SerializedName("created")
        @Expose
        var created: String = ""
        @SerializedName("updated")
        @Expose
        var updated: String = ""
        @SerializedName("token")
        @Expose
        var token: String = ""
    }

}
