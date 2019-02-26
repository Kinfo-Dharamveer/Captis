package com.captis.loginmodule.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.captis.MyApplication
import com.captis.R
import com.captis.auth.AuthManager
import com.captis.basemodule.activities.BaseActivity
import com.captis.basemodule.callbacks.PostAPIResultCallback
import com.captis.basemodule.models.CommonResponseModel
import com.captis.loginmodule.LoginApiMethods
import com.captis.loginmodule.parameters.ForgotPasswordParameter
import com.captis.utilities.CommonUtil
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Response
import javax.inject.Inject

class ForgotPasswordActivity : BaseActivity(), PostAPIResultCallback<CommonResponseModel> {

    @Inject
    lateinit var authManager: AuthManager

    lateinit var mPostApiResultCallback: PostAPIResultCallback<CommonResponseModel>

    lateinit var forgotPasswordParameter: ForgotPasswordParameter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        initView()
    }

    private fun initView() {
        (application as MyApplication).getAppComponent()?.inject(this)

        tv_toolbar_heading.text = resources.getString(R.string.forgot_password)
        mPostApiResultCallback = this
    }

    fun onResetPasswordClick(view: View) {
        if (CommonUtil.isConnectingToInternet(this)) {
            if (CommonUtil.checkEmptyString(et_email)) {
                CommonUtil.showSnackbar(main_layout, "Please enter email")
                return
            }

            CommonUtil.showProgress(this)
            forgotPasswordParameter = ForgotPasswordParameter()
            forgotPasswordParameter.email = CommonUtil.fieldValue(et_email)

            LoginApiMethods.forgotPassword(mPostApiResultCallback, forgotPasswordParameter)
        } else {
            CommonUtil.showSnackbar(main_layout, resources.getString(R.string.check_internet))
        }
    }

    fun onBackToLoginClick(view: View) {
        finish()
    }

    override fun onResponse(response: Response<CommonResponseModel>) {
        CommonUtil.hideProgress()
        if (response.body() != null) {
            if (response.body()!!.isSuccess) {
                CommonUtil.showShortToast(this, response.body()!!.message)
                startActivity(Intent(this, LoginActivity::class.java))
                finishAffinity()
            } else {
                CommonUtil.showSnackbar(main_layout, response.body()!!.message)
            }
        } else {
            CommonUtil.showSnackbar(main_layout, resources.getString(R.string.something_wrong))
        }
    }

    override fun onFailure() {
        CommonUtil.hideProgress()
        CommonUtil.showSnackbar(main_layout, resources.getString(R.string.something_wrong))
    }

    fun onBackClick(view:View){
        finish()
    }

}