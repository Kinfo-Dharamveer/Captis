package com.captis.loginmodule.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.captis.MyApplication
import com.captis.R
import com.captis.auth.AuthManager
import com.captis.basemodule.activities.BaseActivity
import javax.inject.Inject

class SplashScreenActivity : BaseActivity(){

    @Inject
    lateinit var authManager: AuthManager

    lateinit var mHandler: Handler
    private val SPLASH_DELAY: Long = 2000

    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            setLoginIntent()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        initView()
    }

    private fun initView() {
        (application as MyApplication).getAppComponent()?.inject(this)

        mHandler = Handler()

            mHandler.postDelayed(mRunnable, SPLASH_DELAY)

    }

    public override fun onDestroy() {
        mHandler.removeCallbacks(mRunnable)
        super.onDestroy()
    }

    fun setLoginIntent() {
        val intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}