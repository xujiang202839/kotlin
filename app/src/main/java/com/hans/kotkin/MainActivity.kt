package com.hans.kotkin

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.blankj.utilcode.util.FragmentUtils
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hans.kotkin.base.BaseActivity
import com.hans.kotkin.fragment.MineFragment
import com.hans.kotkin.fragment.RootFragment
import com.hans.kotkin.framework.callback.ObserverCallBack
import com.hans.kotkin.framework.callback.RxStreamHelper
import com.hans.kotkin.framework.RetrofitManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), View.OnClickListener {

    private val mFragments = arrayListOf<Fragment>()
    private var curIndex: Int = 0

    override fun initExtra(extras: Bundle?) {
    }

    //1104a89792c95056bc2
    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragmentNavigation0 -> {
                    showCurrentFragment(0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.fragmentNavigation1 -> {
                    showCurrentFragment(1)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.fragmentNavigation2 -> {
                    showCurrentFragment(2)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.fragmentNavigation3 -> {
                    showCurrentFragment(3)
                    return@OnNavigationItemSelectedListener true
                }
                else -> false
            }
        }


    override fun initView(savedInstanceState: Bundle?, contentView: View?) {
        if (savedInstanceState != null) {
            curIndex = savedInstanceState.getInt("curIndex")
        }
        fragmentNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        mFragments.add(RootFragment.newInstance("首页"))
        mFragments.add(RootFragment.newInstance("精彩宽庭"))
        mFragments.add(RootFragment.newInstance("购物车"))
        mFragments.add(MineFragment())
        FragmentUtils.add(
            supportFragmentManager,
            mFragments,
            R.id.fragmentContainer,
            arrayOf("RootFragment0", "RootFragment1", "RootFragment2", "RootFragment3"),
            curIndex
        )
    }

    override fun onBackPressed() {
        if (!FragmentUtils.dispatchBackPress(mFragments[curIndex])) {
            super.onBackPressed()
        }
    }

    private fun showCurrentFragment(index: Int) {
        curIndex = index
        FragmentUtils.showHide(index, mFragments)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("curIndex", curIndex)
    }

    override fun doWork() {

    }

    override fun onClick(view: View?) {
        when (view!!.id) {

        }
    }

    private fun setTitle() {
        val msg: String? = "Kotlin"
        Log.d("main", msg ?: "哈哈")
        Log.d("main", "${msg?.length}")
    }

    private fun sendCode() {
        val hashMap = hashMapOf<String, Any>(
            "username" to "18896917159",
            "type" to 1
        )
        // RetrofitManager.instance.create().sendCode(hashMap)
        RxStreamHelper.ioMain(RetrofitManager.instance.create().sendCode(hashMap), this).subscribe(
            object : ObserverCallBack<String>() {
                override fun onSuccess(t: String?) {

                }
            }
        )

        /* RetrofitManager.instance.create().authSendCode(hashMap)
             .enqueue(object : Callback<ResponseBase<String>> {
                 override fun onFailure(call: Call<ResponseBase<String>>, t: Throwable) {
                     call.cancel()
                     Log.d("onFailure", t.message)
                 }

                 override fun onResponse(
                     call: Call<ResponseBase<String>>,
                     response: Response<ResponseBase<String>>
                 ) {
                     val toString = response.body().toString()
                     if (response.isSuccessful) tv_title.text = response.body()!!.content else Log.d(
                         "onResponse===",
                         toString
                     )
                 }
             })*/
    }
}

