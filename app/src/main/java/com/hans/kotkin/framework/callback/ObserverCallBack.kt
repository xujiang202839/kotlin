package com.hans.kotkin.framework.callback

import com.medtap.network.library.commen.ApiException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * subscribe的时候使用这个接口
 */

abstract class ObserverCallBack<T> : Observer<T> {

    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        // 可在此处加上dialog
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    abstract fun onSuccess(t: T?)

    override fun onError(e: Throwable) {
        if (e is ApiException)
            onError(e.code!!, e.msg)
        else
            onError(0, e.message)
    }

    /**
     * 统一处理失败，比如登录失效等
     *
     * @param code
     * @param msg
     */
    open fun onError(code: Int, msg: String?) {}
}