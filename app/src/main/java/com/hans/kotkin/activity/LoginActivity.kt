package com.hans.kotkin.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.ColorUtils
import com.hans.kotkin.R
import com.hans.kotkin.`object`.DemoObject
import com.hans.kotkin.`object`.DemoObject2
import com.hans.kotkin.base.BaseActivity
import com.hans.kotkin.interfaces.MyInterface
import com.hans.kotkin.utils.SPUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), View.OnClickListener, MyInterface {

    private var name: String? = null

    private var list: MutableList<String> = ArrayList()

    override fun initExtra(extras: Bundle?) {
        name = extras?.getString("name")
    }

    override fun bindLayout(): Int {
        return R.layout.activity_login
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {
        //状态栏背景颜色
        BarUtils.setStatusBarColor(this, ColorUtils.getColor(R.color.tran))
        //状态字体颜色
        BarUtils.setStatusBarLightMode(this, true);
    }

    override fun doWork() {
        tv_text.text = name
        bt_click.setOnClickListener(this)

        SPUtils.saveValue("authorization","xujiang")

        /*list.add("1")
        list.add("2")
        list.add("3")
        list!!.map { item ->
            {
                Log.d("item", item);
            }
        }

        list?.forEach {
            Log.d("item", it);
        }*/

        for (x in 1..5) {
            Log.d("item", "$x");
        }

        for (x in 1..10 step 2) {
        }


        /* val items = listOf("apple", "banana", "kiwifruit")
         for (index in items.indices) {
             println("item at $index is ${items[index]}")
         }*/

    }

    override fun onClick(p0: View?) {
        foo()
        MyInterface.Companion.test()
        bar()
        DemoObject.a()
        DemoObject2("传参数")
        DemoObject2.MyObject.a()

        val string = SPUtils.getString("authorization")
        tv_text.text = string
    }

    override fun bar() {
        Log.d(MyInterface.Companion.TAG,"子类继承实现方法")
    }
}
