package com.hans.kotkin.beans

/**
 *@创建者 xu
 *@创建时间 2019/10/8
 *@描述
 */
data class UserBean(
    val access_token: String,
    val expires_in: Int,
    val isRepairman: Int,
    val refresh_token: String,
    val scope: String,
    val token_type: String,
    val type: Int
)