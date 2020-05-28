package com.hans.kotkin.`object`

import android.util.Log


/**
 *@创建者 xu
 *@创建时间 2020/5/27
 *@描述 用object 修饰的类为静态类，里面的方法和变量都为静态的。
 */
object DemoObject {

  private  const val TAG ="DemoObject"

    fun a(){
        Log.d(TAG,"此时 object 表示 声明静态内部类")
    }
}