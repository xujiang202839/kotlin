package com.hans.kotkin.framework

import com.frank.wallet.net.LoggingInterceptorLogger
import com.hans.kotkin.framework.okhttp.ParameterInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *@创建者 xu
 *@创建时间 2019/10/9
 *@描述
 */
class RetrofitManager {

    /**
     * 双重校验锁式（Double Check)
     * 延迟属性
     *lazy 在第一次被调用时就被初始化，以后调用该属性会返回之前的结果
     */
    companion object {
        val instance: RetrofitManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitManager();
        }
        const val TIME_SET: Long = 10
    }

    /**
     * 线程安全的懒汉式
     */
    /*companion object {
        private var instance: RetrofitManager? = null
            get() {
                if (field == null) {
                    field = RetrofitManager()
                }
                return field
            }

        @Synchronized
        fun get(): RetrofitManager {
            return instance!!
        }
    }*/

    private var retrofit: Retrofit? = null
    private var apiService: ApiService? = null

    /**
     * 初始化
     */
    init {
        //日志拦截器
        val httpLoggingInterceptor = HttpLoggingInterceptor(LoggingInterceptorLogger())
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        //OkHttp对象
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(TIME_SET, TimeUnit.SECONDS)
            .writeTimeout(TIME_SET, TimeUnit.SECONDS)
            .connectTimeout(TIME_SET, TimeUnit.SECONDS)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .addInterceptor(ParameterInterceptor())
            .build()
        //创建Retrofit对象
        retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun <T> create(server: Class<T>): T {
        return retrofit!!.create(server)
    }

    //创建请求接口类
    fun create(): ApiService {
        return if (apiService == null) retrofit!!.create(ApiService::class.java) else apiService!!
    }
}