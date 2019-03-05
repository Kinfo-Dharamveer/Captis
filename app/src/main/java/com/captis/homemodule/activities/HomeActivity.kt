package com.captis.homemodule.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.captis.MyApplication
import com.captis.R
import com.captis.auth.AuthManager
import com.captis.basemodule.activities.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var authManager: AuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initView()
    }

    fun initView() {
        (application as MyApplication).getAppComponent()?.inject(this)

        val navigation = findViewById<View>(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        tv_toolbar_heading.text = resources.getString(R.string.trending)
//        loadFragment(HealthFeedFragment())
    }

    private val mOnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.trending -> {
                    tv_toolbar_heading.text = resources.getString(R.string.trending_feed)
//                   loadFragment(HealthFeedFragment())
                    return true
                }
                R.id.following -> {
                    tv_toolbar_heading.text = resources.getString(R.string.following_feed)
//                    loadFragment(DailyPlannerFragment())
                    return true
                }
                R.id.search -> {
                    tv_toolbar_heading.text = resources.getString(R.string.search)
//                    loadFragment(HealthRecordsFragment())
                    return true
                }
                R.id.notifications -> {
                    tv_toolbar_heading.text = resources.getString(R.string.notifications)
//                    loadFragment(ConsultationsFragment())
                    return true
                }
                R.id.profile -> {
                    tv_toolbar_heading.text = resources.getString(R.string.profile)
//                    loadFragment(CalendarFragment())
                    return true
                }
            }
            return false
        }
    }

    // load fragment
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        // transaction.addToBackStack(null)
        transaction.commit()
    }

    fun onBackClick(view: View) {
        onBackPressed()
    }

    override fun onBackPressed() {

        AlertDialog.Builder(this)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle("Closing Application")
            .setMessage("Are you sure you want to close this activity?")
            .setPositiveButton("Yes") { dialog, which ->
                if (supportFragmentManager.getBackStackEntryCount() > 0) {
                    supportFragmentManager.popBackStack();
                } else {
                    super.onBackPressed();
                }
            }
            .setNegativeButton("No", null)
            .show()
    }

}