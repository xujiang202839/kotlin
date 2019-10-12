package com.hans.kotkin.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 *@创建者 xu
 *@创建时间 2019/10/11
 *@描述
 */
abstract class BaseActivity : RxAppCompatActivity(), BaseView {

    private var mContentView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initExtra(intent.extras)
        setRootLayout(bindLayout())
        initView(savedInstanceState, mContentView)
        doWork()
    }

    @SuppressLint("ResourceType")
    override fun setRootLayout(@LayoutRes layoutId: Int) {
        if (layoutId <= 0) return
        mContentView = LayoutInflater.from(this).inflate(layoutId, null)
        setContentView(mContentView)
    }
}