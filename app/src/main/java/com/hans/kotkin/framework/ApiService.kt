package com.hans.kotkin.framework

import com.hans.kotkin.base.ResponseBase
import com.hans.kotkin.beans.UserBean
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

/**
 *@创建者 xu
 *@创建时间 2019/10/8
 *@描述 接口声明类
 */
interface ApiService {


    /**
     * 登录
     * @FormUrlEncoded
     */
    @POST("auth/authentication/customer/phone/app")
    fun login(@Body route: RequestBody): Call<ResponseBase<UserBean>>


    /**
     * Any对于java来说,这个value的类型是Object
     *对于kotlin来说,retrofit会把Any识别成 ?
     * 注解@JvmSuppressWildcards
     */
    @JvmSuppressWildcards
    @POST("auth/auth/sendCode")
    fun authSendCode(@Body map: Map<String, Any>): Call<ResponseBase<String>>


    @JvmSuppressWildcards
    @POST("auth/auth/sendCode")
    fun sendCode(@Body map: Map<String, Any>): Observable<ResponseBase<String>>

 /*   @FormUrlEncoded
    @POST("auth/auth/sendCode")
    fun sendCode(@Field("username") phone: String, @Field("type") type: Int): Call<ResponseBase<String>>*/
}