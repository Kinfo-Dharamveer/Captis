package com.captis.di

import android.content.Context
import android.content.SharedPreferences
import com.captis.auth.AuthManager
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

import android.preference.PreferenceManager.getDefaultSharedPreferences

@Module
class ApplicationModule(private val mContext: Context) {

    @Provides
    @Singleton
    internal fun providesSharedPreferences(): SharedPreferences {
        return getDefaultSharedPreferences(mContext)
    }

    @Provides
    @Singleton
    internal fun provideAuthManager(preferences: SharedPreferences): AuthManager {
        return AuthManager(preferences)
    }
}
