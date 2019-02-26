package com.captis.auth

import android.content.SharedPreferences
import com.captis.utilities.Constants
import dagger.Module

import javax.inject.Inject

@Module
class AuthManager @Inject
constructor(private val mPreference: SharedPreferences) {

    fun clearPrefernces() {
        mPreference.edit().clear().apply()
    }

    fun setUserId(userId: Int) {
        mPreference.edit().putInt(Constants.KEY_ID, userId).apply()
    }

    fun getUserId(): Int {
        return mPreference.getInt(Constants.KEY_ID, 0)
    }

    fun setUserName(userName: String) {
        mPreference.edit().putString(Constants.KEY_USERNAME, userName).apply()
    }

    fun getUserName(): String {
        return mPreference.getString(Constants.KEY_USERNAME, "") ?: ""
    }

    fun setName(name: String) {
        mPreference.edit().putString(Constants.KEY_NAME, name).apply()
    }

    fun getName(): String {
        return mPreference.getString(Constants.KEY_NAME, "") ?: ""
    }

    fun setImage(image: String) {
        mPreference.edit().putString(Constants.KEY_IMAGE, image).apply()
    }

    fun getImage(): String {
        return mPreference.getString(Constants.KEY_IMAGE, "") ?: ""
    }

    fun setWebsite(website: String) {
        mPreference.edit().putString(Constants.KEY_WEBSITE, website).apply()
    }

    fun getWebsite(): String {
        return mPreference.getString(Constants.KEY_WEBSITE, "") ?: ""
    }

    fun setBio(bio: String) {
        mPreference.edit().putString(Constants.KEY_BIO, bio).apply()
    }

    fun getBio(): String {
        return mPreference.getString(Constants.KEY_BIO, "") ?: ""
    }

    fun setMobile(mobile: String) {
        mPreference.edit().putString(Constants.KEY_MOBILE, mobile).apply()
    }

    fun getMobile(): String {
        return mPreference.getString(Constants.KEY_MOBILE, "") ?: ""
    }

    fun setGender(gender: String) {
        mPreference.edit().putString(Constants.KEY_GENDER, gender).apply()
    }

    fun getGender(): String {
        return mPreference.getString(Constants.KEY_GENDER, "") ?: ""
    }

    fun setEmail(email: String) {
        mPreference.edit().putString(Constants.KEY_EMAIL, email).apply()
    }

    fun getEmail(): String {
        return mPreference.getString(Constants.KEY_EMAIL, "") ?: ""
    }

    fun setVerificationCode(verificationCode: String) {
        mPreference.edit().putString(Constants.KEY_VERIFICATION_CODE, verificationCode).apply()
    }

    fun getVerificationCode(): String {
        return mPreference.getString(Constants.KEY_VERIFICATION_CODE, "") ?: ""
    }

    fun setVerificationType(verificationType: String) {
        mPreference.edit().putString(Constants.KEY_VERIFICATION_TYPE, verificationType).apply()
    }

    fun getVerificationType(): String {
        return mPreference.getString(Constants.KEY_VERIFICATION_TYPE, "") ?: ""
    }

    fun setIsVerified(isVerified: Boolean) {
        mPreference.edit().putBoolean(Constants.KEY_ISVERFIFIED, isVerified).apply()
    }

    fun isVerified(): Boolean {
        return mPreference.getBoolean(Constants.KEY_ISVERFIFIED, false)
    }

    fun setAccessToken(token: String) {
        mPreference.edit().putString(Constants.KEY_TOKEN, token).apply()
    }

    fun getAccessToken(): String {
        return mPreference.getString(Constants.KEY_TOKEN, "") ?: ""
    }

    companion object {
        private val TAG = AuthManager::class.java.simpleName
    }

}
