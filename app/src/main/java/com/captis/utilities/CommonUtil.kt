package com.captis.utilities

import android.app.AlertDialog
import android.content.Context
import com.google.android.material.snackbar.Snackbar
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.captis.auth.AuthManager
import com.captis.progressutil.SpotsDialog
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.Logger

class CommonUtil {
    companion object {
        var progress: AlertDialog? = null

        fun showSnackbar(view: View, message: String) {
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
        }

        fun showShortToast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun showLog(tag: String, message: String) {
            val Log = Logger.getLogger(tag)
            Log.warning(message)
        }

        fun checkValidEmail(value: EditText): Boolean {
            return Constants.EMAIL_ADDRESS_PATTERN.matcher(value.text.toString().trim()).matches()
        }

        fun checkEmptyString(value: EditText): Boolean {
            return value.text.toString().trim().equals("")
        }

        fun checkPasswordLength(value: EditText): Boolean {
            return value.text.toString().trim().length < 6
        }

        fun fieldValue(field: EditText): String {
            return field.text.trim().toString()
        }

        fun isConnectingToInternet(context: Context): Boolean {
            val connectionDetector = ConnectionDetector(context)
            return connectionDetector.isConnectingToInternet()
        }

        fun showProgress(context: Context) {
            progress = SpotsDialog.Builder()
                .setContext(context)
                .setMessage("Please wait....")
                .build()

            progress?.show()
        }

        fun hideProgress() {
            progress?.dismiss()
        }

        fun convertDateFormat(rawDate: String): String {

            var date: Date? = null
            var output = ""

            val df = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss", Locale.ENGLISH)
            val sdf = SimpleDateFormat("EEE, MMM d, ''yy hh:mm a", Locale.ENGLISH)

            try {
                //Conversion of input String to date
                date = df.parse(rawDate)
                output = sdf.format(date)

            } catch (e: Exception) {
                e.printStackTrace()
            }

            return output
        }

    }
}