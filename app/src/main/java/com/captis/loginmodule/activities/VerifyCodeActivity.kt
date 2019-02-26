package com.captis.loginmodule.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.captis.MyApplication
import com.captis.R
import com.captis.auth.AuthManager
import com.captis.basemodule.activities.BaseActivity
import com.captis.basemodule.callbacks.PostAPIResultCallback
import com.captis.homemodule.activities.HomeActivity
import com.captis.loginmodule.LoginApiMethods
import com.captis.loginmodule.models.VerifyCodeModel
import com.captis.loginmodule.parameters.VerifyCodeParameter
import com.captis.utilities.CommonUtil
import com.captis.utilities.Constants
import kotlinx.android.synthetic.main.activity_verify_code.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Response
import javax.inject.Inject

class VerifyCodeActivity : BaseActivity(), PostAPIResultCallback<VerifyCodeModel> {

    @Inject
    lateinit var authManager: AuthManager

    lateinit var mPostApiResultCallback: PostAPIResultCallback<VerifyCodeModel>

    lateinit var verifyCodeParameter: VerifyCodeParameter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_code)
        initView()
    }

    private fun initView() {
        (application as MyApplication).getAppComponent()?.inject(this)

        mPostApiResultCallback = this
        tv_toolbar_heading.text = resources.getString(R.string.verify_code)
        et_verification_code.setText(intent.getStringExtra(Constants.KEY_VERIFICATION_CODE))
    }

    fun onVerifyMobileClick(view: View) {
        if (CommonUtil.checkEmptyString(et_verification_code)) {
            CommonUtil.showSnackbar(main_layout, "Please enter code")
            return
        }

        if (CommonUtil.isConnectingToInternet(this)) {

            CommonUtil.showProgress(this)
            verifyCodeParameter = VerifyCodeParameter()

            verifyCodeParameter.verificationCode = CommonUtil.fieldValue(et_verification_code)
            verifyCodeParameter.verificationType = intent.getStringExtra(Constants.KEY_VERIFICATION_TYPE)

            LoginApiMethods.verifyCode(
                mPostApiResultCallback,
                verifyCodeParameter, authManager
            )
        } else {
            CommonUtil.showSnackbar(main_layout, resources.getString(R.string.check_internet))
        }
    }

    fun onVerifyUsingEmailClick(view: View) {
        val intent = Intent(this, VerifyCodeActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onResponse(response: Response<VerifyCodeModel>) {
        CommonUtil.hideProgress()
        if (response.body() != null) {
            if (response.body()!!.isSuccess) {
                CommonUtil.showShortToast(this, response.body()!!.message)
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finishAffinity()
            } else {
                CommonUtil.showShortToast(this, response.body()!!.message)
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