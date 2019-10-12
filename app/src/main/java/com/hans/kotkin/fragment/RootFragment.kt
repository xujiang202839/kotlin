package com.hans.kotkin.fragment

import android.os.Bundle
import android.view.View
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
        fun newInstance(): RootFragment {
            val args = Bundle()
            val fragment = RootFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun initExtra(extras: Bundle?) {}

    override fun bindLayout(): Int {
        return R.layout.fragment_root
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {
        BarUtils.setStatusBarColor(rootFragmentFakeStatusBar, ColorUtils.getColor(R.color.colorPrimary))
    }

    override fun doWork() {
    }
}