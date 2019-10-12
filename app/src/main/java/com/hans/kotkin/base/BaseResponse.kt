package com.hans.kotkin.base

/**
 *@创建者 xu
 *@创建时间 2019/10/8
 *@描述
 */
data class ResponseBase<T>(
    val code: Int,
    val message: String,
    val content: T
)