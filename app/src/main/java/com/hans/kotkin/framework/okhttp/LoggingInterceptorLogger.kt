package com.frank.wallet.net


import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptorLogger : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Log.d("message", "message==${message}")
    }
}