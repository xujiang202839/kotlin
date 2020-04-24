package com.hans.kotkin.framework.okhttp

import com.hans.kotkin.MyApplication
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 *@创建者 xu
 *@创建时间 2019/10/10
 *@描述
 */
class ParameterInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val url = original.url().newBuilder().build()
        var request: Request? = null
        when (MyApplication.authorization!!.isEmpty()) {
            true -> request = original.newBuilder().method(original.method(), original.body())
                .header("terminaltype", "12")
                .url(url)
                .build()
            false -> request = original.newBuilder()
                .method(original.method(), original.body())
                .header("Authorization", MyApplication.authorization)
                .header("terminaltype", "12")
                .url(url)
                .build()
        }
        return chain.proceed(request)
    }
}