package com.captis.loginmodule

import com.captis.basemodule.models.CommonResponseModel
import com.captis.loginmodule.models.ForgotPasswordModel
import com.captis.loginmodule.models.LoginModel
import com.captis.loginmodule.models.VerifyCodeModel
import com.captis.loginmodule.models.VerifyMobileModel
import com.captis.loginmodule.parameters.*
import com.captis.models.RegisterModel
import retrofit2.Call
import retrofit2.http.*

interface LoginApiInterface {

    @POST("register")
    fun register(
        @Body registerParameter: RegisterParameter
    ): Call<RegisterModel>

    @POST("login")
    fun login(
        @Body loginParameter: LoginParameter
    ): Call<LoginModel>

    @POST("api/verifyMobile")
    fun verifyMobile(
        @Body verifyMobileParameter:VerifyMobileParameter
    ): Call<VerifyMobileModel>

    @POST("api/verifyCode")
    fun verifyCode(
        @Body verifyCodeParameter: VerifyCodeParameter
    ): Call<VerifyCodeModel>

    @POST("forgotPassword")
    fun forgotPassword(
        @Body forgotPasswordParameter: ForgotPasswordParameter
    ): Call<CommonResponseModel>

    @FormUrlEncoded
    @POST("api/Account/ResetPassword")
    fun resetPassword(
        @Field("Email") email: String, @Field("NewPassword") newPassword: String, @Field("ConfirmPassword") confirmPassword: String,
        @Field("Token") token: String, @Field("OTP") otp: String
    ): Call<CommonResponseModel>

    @FormUrlEncoded
    @POST("api/Account/SetSecurityPin")
    fun setSecurityPin(
        @Field("Pin") pin: String, @Field("ConfirmPin") confirmPin: String
    ): Call<CommonResponseModel>
}
