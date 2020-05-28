package com.hans.kotkin.framework.okhttp

import com.hans.kotkin.MyApplication
import okhttp3.HttpUrl
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
        var request = chain.request()
        request = addParams(request)
        /*val url = request.url().newBuilder().build()
         var request: Request? = null
        request = when (MyApplication.authorization.isEmpty()) {
            true -> request.newBuilder().method(request.method(), request.body())
                .header("type", "12")
                .url(url)
                .build()
            false -> request.newBuilder()
                .method(request.method(), request.body())
                .header("Authorization", MyApplication.authorization)
                .header("type", "12")
                .url(url)
                .build()
        }*/
        return chain.proceed(request)
    }

    private fun addParams(request: Request): Request {
        val builder = request.newBuilder()
        //增加token
        when (MyApplication.authorization.isEmpty()) {
            true -> builder.addHeader("Authorization", MyApplication.authorization)
                .addHeader("type", "12")
            false -> builder.addHeader("type", "12")
        }
        when (MyApplication.authorization == "ewr") {
            true -> {
                val path = request.url().toString()
                if (path.contains("butler")) {
                    val replace = path.replace("butler", "president")
                    val httpUrl = HttpUrl.parse(replace)!!.newBuilder().build()
                    return builder.url(httpUrl).build()
                }
            }
        }
        return builder.build()
    }
}