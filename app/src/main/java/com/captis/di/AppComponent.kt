package com.captis.di

import com.captis.homemodule.activities.HomeActivity
import com.captis.loginmodule.activities.*
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface AppComponent {
    fun inject(activity: SplashScreenActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: RegisterActivity)
    fun inject(activity: ForgotPasswordActivity)
    fun inject(activity: ResetPasswordActivity)
    fun inject(activity: VerifyMobileActivity)
    fun inject(activity: VerifyCodeActivity)

    fun inject(activity: HomeActivity)
}