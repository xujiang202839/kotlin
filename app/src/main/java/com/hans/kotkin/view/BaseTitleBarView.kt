package com.hans.kotkin.view

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.hans.kotkin.R
import kotlinx.android.synthetic.main.activity_base_title_tar.view.*

/**
 *@创建者 xu
 *@创建时间 2020/5/27
 *@描述
 */
class BaseTitleBarView : LinearLayout {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) :
            super(context, attrs, defStyleAttr) {
        LayoutInflater.from(context).inflate(R.layout.activity_base_title_tar, this)
        val activity = getContext() as Activity
        iv_back.setOnClickListener(View.OnClickListener {
            activity.finish()
        })
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.BaseTitleBarView)
        val title = typedArray.getString(R.styleable.BaseTitleBarView_titleBar)
        val textBar = typedArray.getString(R.styleable.BaseTitleBarView_textBar)
        val textColor = typedArray.getColor(
            R.styleable.BaseTitleBarView_textColorBar,
            context.resources.getColor(R.color.black_333333)
        )
        val button = typedArray.getResourceId(R.styleable.BaseTitleBarView_buttonBar, 0)
        val back = typedArray.getBoolean(R.styleable.BaseTitleBarView_backBar, true)
        initView(title, button, back, textBar, textColor)
        typedArray.recycle()
    }

    private fun initView(
        title: String?,
        button: Int,
        back: Boolean,
        textBar: String?,
        textColor: Int
    ) {
        if (!back) iv_back.visibility = View.GONE
        if (title != null && title.isNotEmpty()) tv_title.text = title
    }
}