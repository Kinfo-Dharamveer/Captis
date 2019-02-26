package com.captis.homemodule.activities

import android.os.Bundle
import android.view.View
import com.captis.R
import com.captis.basemodule.activities.BaseActivity
import kotlinx.android.synthetic.main.toolbar.*

class HomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        tv_toolbar_heading.text = "Home Screen"
    }

    fun onBackClick(view: View) {
        finishAffinity()
    }
}