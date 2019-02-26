package com.captis.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class RegisterModel {

    @SerializedName("status")
    @Expose
    var status: Int = 0
    @SerializedName("results")
    @Expose
    var result: Result = Result()
    @SerializedName("isSuccess")
    @Expose
    var isSuccess: Boolean = false
    @SerializedName("message")
    @Expose
    var message: String = ""

    inner class Result {

        @SerializedName("id")
        @Expose
        var id: Int = 0
        @SerializedName("token")
        @Expose
        var token: String = ""

    }

}