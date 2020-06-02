package com.hans.kotkin.interfaces

import android.util.Log

/**
 *@创建者 xu
 *@创建时间 2020/5/27
 *@描述 自定义接口测试
 */
interface MyInterface {
    //const 关键字用来修饰常量，且只能修饰 val，不能修饰var
    companion object {
        //var TAG: String? = MyInterface::class.simpleName
        //常量
        const val TAG = "MyInterface"
        fun test() {
            Log.d(TAG, "静态代码块引用方法")
        }
    }
    //companion object StaticParams

    fun bar()

    fun foo() {
        Log.d(TAG, "从接口中实现该方法")
    }
}