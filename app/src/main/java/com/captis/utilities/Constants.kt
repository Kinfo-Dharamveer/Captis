package com.captis.utilities

import java.util.regex.Pattern

class Constants {

    companion object {
        // SharedPreferenceKeys
        val KEY_ID = "id"
        val KEY_USERNAME = "username"
        val KEY_NAME = "name"
        val KEY_IMAGE = "image"
        val KEY_WEBSITE = "website"
        val KEY_BIO = "bio"
        val KEY_MOBILE = "mobile"
        val KEY_GENDER = "gender"
        val KEY_EMAIL = "email"
        val KEY_VERIFICATION_TYPE = "verificationType"
        val KEY_VERIFICATION_CODE = "verificationCode"
        val KEY_ISVERFIFIED = "isVerified"
        val KEY_CREATED = "created"
        val KEY_UPDATED = "updated"
        val KEY_TOKEN = "token"

        val KEY_CODE = "code"

        val EMAIL_ADDRESS_PATTERN =
            Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    }
}
