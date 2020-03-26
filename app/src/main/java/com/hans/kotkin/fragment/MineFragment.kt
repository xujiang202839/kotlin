package com.hans.kotkin.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.hans.kotkin.R
import com.hans.kotkin.activity.LoginActivity
import com.hans.kotkin.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 *@创建者 xu
 *@创建时间 2020/1/16
 *@描述
 */
class MineFragment : BaseFragment(), View.OnClickListener {
    override fun initExtra(extras: Bundle?) {
    }

    override fun bindLayout(): Int {
        return R.layout.fragment_mine
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {
    }

    override fun doWork() {
        bt_login.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.bt_login -> {
                val intent = Intent(context, LoginActivity::class.java)
                intent.putExtra("name", "跳转登录")
                startActivity(intent)
            }
        }
    }
}