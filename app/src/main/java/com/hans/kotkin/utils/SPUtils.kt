package com.hans.kotkin.utils

import android.content.Context
import android.content.SharedPreferences
import com.hans.kotkin.MyApplication

/**
 *@创建者 xu
 *@创建时间 2019/10/10
 *@描述
 */
object SPUtils {

    private const val name = "APP_Config"

    //lazy 在第一次被调用时就被初始化，以后调用该属性会返回之前的结果。
    private val prefs: SharedPreferences by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        MyApplication.instance!!.getSharedPreferences(name, Context.MODE_PRIVATE)
    }

    /**
     * 存放SharedPreferences
     * @param name 键
     * @param value 值
     */
    fun saveValue(name: String, value: Any) = with(prefs.edit()) {
        when (value) {
            is Int -> putInt(name, value)
            is Float -> putFloat(name, value)
            is Long -> putLong(name, value)
            is Boolean -> putBoolean(name, value)
            is String -> putString(name, value)
            else -> throw IllegalArgumentException("SharedPreference can't be save this type")
        }.apply()
    }

    /**
     * 获取SharedPreferences
     * @param name 键
     * @param default 值
     */
    fun getValue(name: String, default: Any): Any? = with(prefs) {
        return when (default) {
            is Int -> getInt(name, default)
            is Float -> getFloat(name, default)
            is Long -> getLong(name, default)
            is Boolean -> getBoolean(name, default)
            is String -> getString(name, default)
            else -> throw IllegalArgumentException("SharedPreference can't be get this type")
        }
    }

    fun getString(key: String, default: String = ""): String {
        return getValue(key, default) as String
    }

    fun getInt(key: String, default: Int = 0): Int {
        return getValue(key, default) as Int
    }

    fun getLong(key: String, default: Long = 0): Long {
        return getValue(key, default) as Long
    }

    fun getBoolean(key: String, default: Boolean = false): Boolean {
        return getValue(key, default) as Boolean
    }

    fun getFloat(key: String, default: Float = 0f): Float {
        return getValue(key, default) as Float
    }

    /**
     * 清除
     */
    fun clear() {
        prefs.edit().clear().apply()
    }

    /**
     * 删除某Key的值
     */
    fun remove(key: String) {
        prefs.edit().remove(key).apply()
    }
}