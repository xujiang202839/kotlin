package com.hans.kotkin.framework.errorcode

/**
 *@创建者 xu
 *@创建时间 2019/10/11
 *@描述
 */
class Error() {
    companion object {
        const val UNAUTHORIZED = 401 //  未授权的请求
        const val FORBIDDEN = 403//禁止访问
        const val NOT_FOUND = 404//服务器地址未找到
        const val REQUEST_TIMEOUT = 408//请求超时
        const val INTERNAL_SERVER_ERROR = 500//服务器出错
        const val BAD_GATEWAY = 502//无效的请求
        const val SERVICE_UNAVAILABLE = 503//服务器不可用
        const val GATEWAY_TIMEOUT = 504//网关响应超时
        const val ACCESS_DENIED = 302//网络错误
        const val HANDEL_ERROR = 417//接口处理失败

        /**
         * 未知错误
         */
        const val UNKNOWN = 1000
        /**
         * 解析错误
         */
        const val PARSE_ERROR = 1001
        /**
         * 网络错误
         */
        const val NETWORK_ERROR = 1002
        /**
         * 协议出错
         */
        const val HTTP_ERROR = 1003

        /**
         * 证书出错
         */
        const val SSL_ERROR = 1005

        /**
         * 连接超时
         */
        const val TIMEOUT_ERROR = 1006

        /**
         * 证书未找到
         */
        const val SSL_NOT_FOUND = 1007

        /**
         * 出现空值
         */
        const val NULL = -100

        /**
         * 格式错误
         */
        const val FORMAT_ERROR = 1008
    }
}