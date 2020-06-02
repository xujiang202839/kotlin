package com.hans.kotkin.beans

/**
 *@创建者 xu
 *@创建时间 2020/6/2
 *@描述
 */
class Person {
    var lastName: String = "jiang"
        get() = field.toUpperCase() // 将变量赋值后转换为大写
        set

    var no: Int = 100
        get() = field    // 后端变量
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }

    //非空属性必须在定义的时候初始化,kotlin提供了一种可以延迟初始化的方案,使用 lateinit 关键字描述属性：
    lateinit var userBean: UserBean
}