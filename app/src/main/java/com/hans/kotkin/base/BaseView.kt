package com.hans.kotkin.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable

/**
 *@创建者 xu
 *@创建时间 2019/10/12
 *@描述
 */
interface BaseView {

    fun initExtra(@Nullable extras: Bundle?);

    fun bindLayout(): Int;

    fun setRootLayout(@LayoutRes layoutId: Int)

    fun initView(@Nullable savedInstanceState: Bundle?, @Nullable contentView: View?);

    fun doWork()
}