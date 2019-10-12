package com.hans.kotkin

import android.app.Application
import android.util.Log
import com.hans.kotkin.utils.SPUtils

/**
 *@创建者 xu
 *@创建时间 2019/10/10
 *@描述
 */
class MyApplication : Application() {

    companion object {
        var instance: MyApplication? = null
        var authorization: String ? = ""
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        init()
    }

    private fun init() {
        authorization = SPUtils.getString("authorization")
    }
}