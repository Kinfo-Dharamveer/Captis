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
import com.captis.loginmodule.parameters.RegisterParameter
import com.captis.models.RegisterModel
import com.captis.utilities.CommonUtil
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Response
import javax.inject.Inject

class RegisterActivity : BaseActivity(), PostAPIResultCallback<RegisterModel> {

    @Inject
    lateinit var authManager: AuthManager

    lateinit var mPostApiResultCallback: PostAPIResultCallback<RegisterModel>

    lateinit var registerParameter: RegisterParameter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initView()
    }

    private fun initView() {
        (application as MyApplication).getAppComponent()?.inject(this)
        tv_toolbar_heading.text = resources.getString(R.string.register)
        mPostApiResultCallback = this
    }

    fun onSubmitClick(view: View) {
        if (CommonUtil.isConnectingToInternet(this)) {
            if (isValid()) {
                CommonUtil.showProgress(this)

                registerParameter = RegisterParameter()
                registerParameter.username = CommonUtil.fieldValue(et_user_name)
                registerParameter.email = CommonUtil.fieldValue(et_email)
                registerParameter.password = CommonUtil.fieldValue(et_password)


                LoginApiMethods.register(
                    mPostApiResultCallback,
                    registerParameter
                )
            }
        } else {
            CommonUtil.showSnackbar(main_layout, resources.getString(R.string.check_internet))
        }
    }

    fun isValid(): Boolean {

        if (CommonUtil.checkEmptyString(et_user_name)) {
            CommonUtil.showSnackbar(main_layout, "Please enter user name")
            return false
        } else if (CommonUtil.checkEmptyString(et_email)) {
            CommonUtil.showSnackbar(main_layout, "Please enter email")
            return false
        } else if (!CommonUtil.checkValidEmail(et_email)) {
            CommonUtil.showSnackbar(main_layout, "Please enter valid email")
            return false
        } else if (CommonUtil.checkEmptyString(et_password)) {
            CommonUtil.showSnackbar(main_layout, "Please enter password")
            return false
        } else if (CommonUtil.checkEmptyString(et_confirm_password)) {
            CommonUtil.showSnackbar(main_layout, "Please enter confirm password")
            return false
        } else if (!CommonUtil.fieldValue(et_password).equals(CommonUtil.fieldValue(et_confirm_password))) {
            CommonUtil.showSnackbar(main_layout, "Passwords don't match")
            return false
        }

        return true
    }

    override fun onResponse(response: Response<RegisterModel>) {
        CommonUtil.hideProgress()
        if (response.body() != null) {
            if (response.body()!!.isSuccess) {
                CommonUtil.showShortToast(this, response.body()!!.message)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
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