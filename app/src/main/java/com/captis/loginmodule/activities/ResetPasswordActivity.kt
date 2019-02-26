package com.captis.loginmodule.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.captis.MyApplication
import com.captis.R
import com.captis.auth.AuthManager
import com.captis.loginmodule.LoginApiMethods
import com.captis.basemodule.activities.BaseActivity
import com.captis.basemodule.callbacks.PostAPIResultCallback
import com.captis.basemodule.models.CommonResponseModel
import com.captis.utilities.CommonUtil
import com.captis.utilities.Constants
import kotlinx.android.synthetic.main.activity_reset_activity.*
import retrofit2.Response
import javax.inject.Inject

class ResetPasswordActivity : BaseActivity(), PostAPIResultCallback<CommonResponseModel> {

    @Inject
    lateinit var authManager: AuthManager

    lateinit var mPostApiResultCallback: PostAPIResultCallback<CommonResponseModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_activity)
        initView()
    }

    private fun initView() {
        (application as MyApplication).getAppComponent()?.inject(this)
        mPostApiResultCallback = this
    }

    fun onSubmitClick(view: View) {
        if (CommonUtil.isConnectingToInternet(this)) {
            if (isValid()) {
                CommonUtil.showProgress(this)
                LoginApiMethods.resetPassword(
                    mPostApiResultCallback, intent.getStringExtra(Constants.KEY_EMAIL),
                    CommonUtil.fieldValue(et_new_password), CommonUtil.fieldValue(et_confirm_password),
                    intent.getStringExtra(Constants.KEY_CODE), CommonUtil.fieldValue(et_otp)
                )
            }
        } else {
            CommonUtil.showSnackbar(main_layout, resources.getString(R.string.check_internet))
        }
    }

    private fun isValid(): Boolean {
        if (CommonUtil.checkEmptyString(et_otp)) {
            CommonUtil.showSnackbar(main_layout, "Please enter OTP")
            return false
        } else if (CommonUtil.checkEmptyString(et_new_password)) {
            CommonUtil.showSnackbar(main_layout, "Please enter new password")
            return false
        } else if (CommonUtil.checkEmptyString(et_confirm_password)) {
            CommonUtil.showSnackbar(main_layout, "Please confirm password")
            return false
        } else if (!CommonUtil.fieldValue(et_new_password).equals(CommonUtil.fieldValue(et_confirm_password))) {
            CommonUtil.showSnackbar(main_layout, "Password don't match")
            return false
        }

        return true
    }

    override fun onResponse(response: Response<CommonResponseModel>) {
        CommonUtil.hideProgress()
//        if (response.body() != null) {
//            if (response.body()!!.success) {
//                CommonUtil.showSnackbar(main_layout, response.body()!!.message)
//                val intent = Intent(this, LoginActivity::class.java)
//                startActivity(intent)
//                finishAffinity()
//            } else {
//                CommonUtil.showSnackbar(main_layout, response.body()!!.message)
//            }
//        } else {
//            CommonUtil.showSnackbar(main_layout, resources.getString(R.string.something_wrong))
//        }
    }

    override fun onFailure() {
        CommonUtil.hideProgress()
        CommonUtil.showSnackbar(main_layout, resources.getString(R.string.something_wrong))
    }

}