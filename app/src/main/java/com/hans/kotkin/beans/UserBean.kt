package com.hans.kotkin.beans

/**
 *@创建者 xu
 *@创建时间 2019/10/8
 *@描述
 */
data class UserBean(
    var access_token: String = "",
    var expires_in: Int,
    var isRepairman: Int,
    var refresh_token: String,
    var scope: String,
    var token_type: String,
    var type: Int,
    var typeInfo: List<NameInfoBean>? = null,
    var userInfo: List<UserInfoBean>? = null
) {
    data class UserInfoBean(
        var name: String? = "",
        var sex: List<SexInfo>? = null
    ) {
        data class SexInfo(
            var sex: Int = 1
        )
    }

    data class NameInfoBean(
        var name: String
    )
}