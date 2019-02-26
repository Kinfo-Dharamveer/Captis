package com.captis.loginmodule.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.captis.MyApplication
import com.captis.R
import com.captis.auth.AuthManager
import com.captis.basemodule.activities.BaseActivity
import com.captis.basemodule.callbacks.PostAPIResultCallback
import com.captis.loginmodule.LoginApiMethods
import com.captis.loginmodule.models.VerifyMobileModel
import com.captis.loginmodule.parameters.VerifyMobileParameter
import com.captis.utilities.CommonUtil
import com.captis.utilities.Constants
import kotlinx.android.synthetic.main.activity_verify_mobile.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Response
import javax.inject.Inject

class VerifyMobileActivity : BaseActivity(), PostAPIResultCallback<VerifyMobileModel> {

    @Inject
    lateinit var authManager: AuthManager

    lateinit var mPostApiResultCallback: PostAPIResultCallback<VerifyMobileModel>

    lateinit var verifyMobileParameter: VerifyMobileParameter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_mobile)
        initView()
    }

    private fun initView() {
        (application as MyApplication).getAppComponent()?.inject(this)
        tv_toolbar_heading.text = resources.getString(R.string.verify_mobile)
        mPostApiResultCallback = this
    }

    fun onVerifyMobileClick(view: View) {
        if (CommonUtil.checkEmptyString(et_phone)) {
            CommonUtil.showSnackbar(main_layout, "Please enter phone number")
            return
        }

        if (CommonUtil.isConnectingToInternet(this)) {
            CommonUtil.showProgress(this)

            verifyMobileParameter = VerifyMobileParameter()
            verifyMobileParameter.mobile = CommonUtil.fieldValue(et_phone)

            LoginApiMethods.verifyMobile(
                mPostApiResultCallback,
                verifyMobileParameter, authManager
            )
        } else {
            CommonUtil.showSnackbar(main_layout, resources.getString(R.string.check_internet))
        }
    }

    fun onVerifyUsingEmailClick(view: View) {
        CommonUtil.showSnackbar(main_layout, "In progress")
    }

    override fun onResponse(response: Response<VerifyMobileModel>) {
        CommonUtil.hideProgress()
        if (response.body() != null) {
            if (response.body()!!.isSuccess) {
                CommonUtil.showShortToast(this, response.body()!!.message)
                val intent = Intent(this, VerifyCodeActivity::class.java)
                intent.putExtra(Constants.KEY_VERIFICATION_CODE, response.body()!!.verificationCode)
                intent.putExtra(Constants.KEY_VERIFICATION_TYPE, "mobile")
                startActivity(intent)
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