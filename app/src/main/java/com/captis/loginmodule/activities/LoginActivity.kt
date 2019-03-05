package com.captis.loginmodule.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.captis.MyApplication
import com.captis.R
import com.captis.auth.AuthManager
import com.captis.basemodule.activities.BaseActivity
import com.captis.basemodule.callbacks.PostAPIResultCallback
import com.captis.homemodule.activities.HomeActivity
import com.captis.loginmodule.LoginApiMethods
import com.captis.loginmodule.parameters.LoginParameter
import com.captis.loginmodule.models.LoginModel
import com.captis.utilities.CommonUtil
import com.captis.xboxmodule.SignInActivity
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Response
import javax.inject.Inject

class LoginActivity : BaseActivity(), PostAPIResultCallback<LoginModel> {

    @Inject
    lateinit var authManager: AuthManager

    lateinit var dialog: AlertDialog

    lateinit var mPostApiResultCallback: PostAPIResultCallback<LoginModel>

    lateinit var loginParameter: LoginParameter

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    private fun initView() {
        (application as MyApplication).getAppComponent()?.inject(this)

        mPostApiResultCallback = this
    }

    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    fun onLoginClick(view: View) {
        if (CommonUtil.isConnectingToInternet(this)) {
            if (isValid()) {
                CommonUtil.showProgress(this)
                loginParameter = LoginParameter()
                loginParameter.username = CommonUtil.fieldValue(et_user_name)
                loginParameter.password = CommonUtil.fieldValue(et_password)

                LoginApiMethods.login(
                    mPostApiResultCallback, loginParameter
                )
            }
        } else {
            CommonUtil.showSnackbar(main_layout, resources.getString(R.string.check_internet))
        }
    }

    fun isValid(): Boolean {

        if (CommonUtil.checkEmptyString(et_user_name)) {
            CommonUtil.showSnackbar(main_layout, "Please enter username")
            return false
        } else if (CommonUtil.checkEmptyString(et_user_name)) {
            CommonUtil.showSnackbar(main_layout, "Please enter password")
            return false
        }

        return true
    }

    fun onForgetPasswordClick(view: View) {
        val intent = Intent(this, ForgotPasswordActivity::class.java)
        startActivity(intent)
    }

    fun onSignUpClick(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    override fun onResponse(response: Response<LoginModel>) {
        CommonUtil.hideProgress()
        if (response.body() != null) {
            if (response.body()!!.isSuccess) {
                CommonUtil.showSnackbar(main_layout, response.body()!!.message)
                if (response.body()!!.results.get(0).verificationType.equals("")) {
                    authManager.setAccessToken(response.body()!!.results.get(0).token)
                    startActivity(Intent(this, VerifyMobileActivity::class.java))
                } else {
                    authManager.setIsLoggedIn(true)
                    startActivity(Intent(this, SignInActivity::class.java))
                    finishAffinity()
                }
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

    companion object {
        private val TAG = "LoginActivity==>"
    }
}
