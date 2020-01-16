package com.hans.kotkin.fragment

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.ColorUtils
import com.hans.kotkin.R
import com.hans.kotkin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_root.*

/**
 *@创建者 xu
 *@创建时间 2019/10/12
 *@描述
 */
class RootFragment : BaseFragment() {

    companion object {
        fun newInstance(title: String): RootFragment {
            val args = Bundle()
            args.putString("title", title)
            val fragment = RootFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private var title: String? = null

    override fun initExtra(extras: Bundle?) {
        title = extras?.getString("title")
    }

    override fun bindLayout(): Int {
        return R.layout.fragment_root
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {
        //状态栏背景颜色
        BarUtils.setStatusBarColor(rootFragmentFakeStatusBar, ColorUtils.getColor(R.color.tran));
        //状态字体颜色
        BarUtils.setStatusBarLightMode(activity as Activity, true);
    }

    override fun doWork() {
        tv_text.text = title
    }
}