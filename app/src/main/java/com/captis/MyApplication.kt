package com.captis

import android.app.Application
import com.captis.di.AppComponent
import com.captis.di.ApplicationModule
import com.captis.di.DaggerAppComponent
import com.captis.xboxmodule.utilitiesmicrosoft.LiveAuthClient
import com.captis.xboxmodule.utilitiesmicrosoft.LiveConnectClient
import com.captis.xboxmodule.utilitiesmicrosoft.LiveConnectSession

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

    private var mAuthClient: LiveAuthClient? = null
    private var mConnectClient: LiveConnectClient? = null
    private var mSession: LiveConnectSession? = null

    fun getAuthClient(): LiveAuthClient? {
        return mAuthClient
    }

    fun getConnectClient(): LiveConnectClient? {
        return mConnectClient
    }

    fun getSession(): LiveConnectSession? {
        return mSession
    }

    fun setAuthClient(authClient: LiveAuthClient) {
        mAuthClient = authClient
    }

    fun setConnectClient(connectClient: LiveConnectClient) {
        mConnectClient = connectClient
    }

    fun setSession(session: LiveConnectSession) {
        mSession = session
    }
}