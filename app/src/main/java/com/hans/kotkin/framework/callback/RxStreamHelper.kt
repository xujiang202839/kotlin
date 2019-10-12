package com.hans.kotkin.framework.callback

import com.hans.kotkin.base.ResponseBase
import com.medtap.network.library.commen.ApiException
import com.medtap.network.library.commen.CustomException
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.components.support.RxFragment
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 *@创建者 xu
 *@创建时间 2019/10/11
 *@描述
 */
object RxStreamHelper {
    /**
     * RxLifecycle绑定生命周期
     */
    fun <T, E> ioMain(observable: Observable<ResponseBase<T>>, lifecycleProvider: LifecycleProvider<E>): Observable<T> {
        // 请求绑定生命周期，防止内存泄漏，同时返回回调之后页面已销毁造成的空指针错误
        if (lifecycleProvider is RxAppCompatActivity) {
            val rxAppCompatActivity = lifecycleProvider as RxAppCompatActivity
            observable.compose(rxAppCompatActivity.bindUntilEvent(ActivityEvent.DESTROY))
        } else if (lifecycleProvider is RxFragment) {
            val rxFragment = lifecycleProvider as RxFragment
            observable.compose(rxFragment.bindUntilEvent(FragmentEvent.DESTROY))
        }

        return observable
            //解析data层，剔除 code /msg
            .compose(HandleResult())
            //出错统一处理
            .onErrorResumeNext(Function { throwable -> Observable.error(CustomException.handleException(throwable))
            })
    }

    private class HandleResult<T> : ObservableTransformer<ResponseBase<T>, T> {
        override fun apply(upstream: Observable<ResponseBase<T>>): ObservableSource<T> {
            return upstream.flatMap { responseBase ->
                if (responseBase.code == 200) Observable.just(responseBase.content!!)
                else Observable.error(ApiException(responseBase.code!!, responseBase.message!!))
            }
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}
