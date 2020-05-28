package com.hans.kotkin.`object`

import android.util.Log

/**
 *@创建者 xu
 *@创建时间 2020/5/27
 *@描述
 */
class DemoObject2 {

    companion object {
        private const val OBJECT_TAG = "DemoObject2"
        fun b() {
            Log.d(OBJECT_TAG, "此时 object2 表示 声明静态内部类")
        }
    }


    /*属性*/
    private var title: String = "true"

    constructor(title: String) {
        Log.d("DemoObject2", title)
        this.title = title
    }

    /**
     * 初始化代码块
     */
    init {
        Log.d("DemoObject2", title)
    }

    object MyObject {
        fun a() {
            Log.d("DemoObject2", "此时 object2 表示 声明静态内部类")
        }
    }
}