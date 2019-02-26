package com.captis.loginmodule

import com.captis.auth.AuthManager
import com.captis.basemodule.callbacks.PostAPIResultCallback
import com.captis.basemodule.models.CommonResponseModel
import com.captis.loginmodule.models.ForgotPasswordModel
import com.captis.loginmodule.models.LoginModel
import com.captis.loginmodule.models.VerifyCodeModel
import com.captis.loginmodule.models.VerifyMobileModel
import com.captis.loginmodule.parameters.*
import com.captis.models.RegisterModel
import com.captis.retrofit.ApiClient
import com.captis.retrofit.ApiClientWithoutHeader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginApiMethods() {

    companion object {

        var mLoginApiInterface: LoginApiInterface = ApiClientWithoutHeader.client.create(LoginApiInterface::class.java)

        fun register(
            mPostAPIResultCallback: PostAPIResultCallback<RegisterModel>,
            registerParameter: RegisterParameter
        ) {
            mLoginApiInterface.register(registerParameter)
                .enqueue(object : Callback<RegisterModel> {
                    override fun onResponse(call: Call<RegisterModel>, response: Response<RegisterModel>) {
                        mPostAPIResultCallback.onResponse(response)
                    }

                    override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                        mPostAPIResultCallback.onFailure()
                    }
                })
        }

        fun login(
            mPostAPIResultCallback: PostAPIResultCallback<LoginModel>,
            loginParameter: LoginParameter
        ) {
            mLoginApiInterface.login(loginParameter)
                .enqueue(object : Callback<LoginModel> {
                    override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                        mPostAPIResultCallback.onResponse(response)
                    }

                    override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                        mPostAPIResultCallback.onFailure()
                    }
                })
        }

        fun verifyMobile(
            mPostAPIResultCallback: PostAPIResultCallback<VerifyMobileModel>,
            verifyMobileParameter: VerifyMobileParameter, authManager: AuthManager
        ) {
            val auth_key = authManager.getAccessToken()
            val service = ApiClient.createService(LoginApiInterface::class.java, auth_key)

            service.verifyMobile(verifyMobileParameter)
                .enqueue(object : Callback<VerifyMobileModel> {
                    override fun onResponse(call: Call<VerifyMobileModel>, response: Response<VerifyMobileModel>) {
                        mPostAPIResultCallback.onResponse(response)
                    }

                    override fun onFailure(call: Call<VerifyMobileModel>, t: Throwable) {
                        mPostAPIResultCallback.onFailure()
                    }
                })
        }

        fun verifyCode(
            mPostAPIResultCallback: PostAPIResultCallback<VerifyCodeModel>,
            verifyCodeParameter: VerifyCodeParameter, authManager: AuthManager
        ) {
            val auth_key = authManager.getAccessToken()
            val service = ApiClient.createService(LoginApiInterface::class.java, auth_key)

            service.verifyCode(verifyCodeParameter)
                .enqueue(object : Callback<VerifyCodeModel> {
                    override fun onResponse(call: Call<VerifyCodeModel>, response: Response<VerifyCodeModel>) {
                        mPostAPIResultCallback.onResponse(response)
                    }

                    override fun onFailure(call: Call<VerifyCodeModel>, t: Throwable) {
                        mPostAPIResultCallback.onFailure()
                    }
                })
        }

        fun forgotPassword(
            mPostAPIResultCallback: PostAPIResultCallback<CommonResponseModel>,
            forgotPasswordParameter: ForgotPasswordParameter
        ) {
            mLoginApiInterface.forgotPassword(forgotPasswordParameter)
                .enqueue(object : Callback<CommonResponseModel> {
                    override fun onResponse(call: Call<CommonResponseModel>, response: Response<CommonResponseModel>) {
                        mPostAPIResultCallback.onResponse(response)
                    }

                    override fun onFailure(call: Call<CommonResponseModel>, t: Throwable) {
                        mPostAPIResultCallback.onFailure()
                    }
                })
        }

        fun resetPassword(
            mPostAPIResultCallback: PostAPIResultCallback<CommonResponseModel>, email: String, newPassword: String,
            confirmPassword: String, token: String, otp: String
        ) {
            mLoginApiInterface.resetPassword(email, newPassword, confirmPassword, token, otp)
                .enqueue(object : Callback<CommonResponseModel> {
                    override fun onResponse(call: Call<CommonResponseModel>, response: Response<CommonResponseModel>) {
                        mPostAPIResultCallback.onResponse(response)
                    }

                    override fun onFailure(call: Call<CommonResponseModel>, t: Throwable) {
                        mPostAPIResultCallback.onFailure()
                    }
                })
        }

        fun setSecurityPin(
            mPostAPIResultCallback: PostAPIResultCallback<CommonResponseModel>,
            securityPin: String, authManager: AuthManager
        ) {

            val auth_key = authManager.getAccessToken()
            val service = ApiClient.createService(LoginApiInterface::class.java, auth_key)

            service.setSecurityPin(securityPin, securityPin)
                .enqueue(object : Callback<CommonResponseModel> {
                    override fun onResponse(call: Call<CommonResponseModel>, response: Response<CommonResponseModel>) {
                        mPostAPIResultCallback.onResponse(response)
                    }

                    override fun onFailure(call: Call<CommonResponseModel>, t: Throwable) {
                        mPostAPIResultCallback.onFailure()
                    }
                })
        }
    }

}