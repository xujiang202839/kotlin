package com.hans.kotkin.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import com.trello.rxlifecycle2.components.support.RxFragment
import java.lang.NullPointerException


/**
 *@创建者 xu
 *@创建时间 2019/10/12
 *@描述
 */
abstract class BaseFragment : RxFragment(), BaseView {

    companion object {
        const val TAG: String = "BaseFragment";
        const val STATE_SAVE_IS_HIDDEN: String = "STATE_SAVE_IS_HIDDEN";
    }

    private var mActivity: Activity? = null
    private var mInflater: LayoutInflater? = null;
    private var mContentView: View? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mActivity = context as Activity?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
       // Log.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            val isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN)
            val fragmentTransaction = fragmentManager!!.beginTransaction()
            when (isSupportHidden) {
                true -> fragmentTransaction.hide(this)
                false -> fragmentTransaction.show(this)
            }
            fragmentTransaction.commitAllowingStateLoss()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       // Log.d(TAG, "onCreateView: ")
        mInflater = inflater
        setRootLayout(bindLayout())
        return mContentView
    }

    @SuppressLint("ResourceType")
    override fun setRootLayout(@LayoutRes layoutId: Int) {
        if (layoutId <= 0) return
        mContentView = mInflater!!.inflate(layoutId, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       // Log.d(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState)
        initExtra(arguments)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
       // Log.d(TAG, "onActivityCreated: ")
        super.onActivityCreated(savedInstanceState)
        initView(savedInstanceState, mContentView)
        doWork()
    }

    override fun onDestroyView() {
      //  Log.d(TAG, "onDestroyView: ")
        if (mContentView != null) {
            val viewGroup = mContentView!!.parent as ViewGroup
            viewGroup.removeView(mContentView)
        }
        super.onDestroyView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
      //  Log.d(TAG, "onSaveInstanceState: ")
        super.onSaveInstanceState(outState)
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden)
    }

    override fun onDestroy() {
      //  Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }

    fun <T : View> findViewById(@IdRes id: Int): T? {
        if (mContentView == null) throw NullPointerException("ContentView is Null")
        return mContentView!!.findViewById(id)
    }
}
