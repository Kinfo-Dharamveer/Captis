package com.captis

import android.app.Application
import com.captis.di.AppComponent
import com.captis.di.ApplicationModule
import com.captis.di.DaggerAppComponent

open class MyApplication: Application() {
    private var sAppComponent: AppComponent? = null

    fun getAppComponent(): AppComponent? {
        if (sAppComponent == null) {
            buildAppComponent()
        }
        return sAppComponent
    }

    override fun onCreate() {
        super.onCreate()
        buildAppComponent()
    }

    private fun buildAppComponent() {
        sAppComponent = DaggerAppComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}