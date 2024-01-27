package com.wurengao.common.model

import android.text.TextUtils
import androidx.room.Ignore

/**
 * Created by wurengao on 2023/12/22
 * @author wurengao@bytedance.com
 */


/**
 * 用户模型
 */
class User : Common() {
    /**
     * 昵称
     */
    var nickname: String? = null

    /**
     * 头像
     */
    var icon: String? = null

    /**
     * 手机号
     */
    @Ignore
    lateinit var phone: String

    /**
     * 用户的密码,登录，注册向服务端传递
     */
    @Ignore
    lateinit var password: String

    /**
     * 性别
     * 0：保密，10：男，20：女
     * 可以定义为枚举
     * 但枚举性能没有int好
     * 但int没有一些编译验证
     * Android中有替代方式
     * 这里用不到就不讲解了
     */
    @Ignore
    var gender = 0

    /**
     * 生日
     * 格式为：yyyy-MM-dd
     */
    @Ignore
    var birthday: String? = null

    /**
     * 描述
     */
    @Ignore
    var detail: String? = null

    /**
     * QQ第三方登录后Id
     */
    @Ignore
    var qqId: String? = null

    /**
     * 格式化后的性别
     *
     * @return
     */
    val genderFormat: String
        get() = when (gender) {
            10 -> "男"
            20 -> "女"
            else ->                 //0
                "保密"
        }

    fun birthdayFormat(): String? {
        return if (TextUtils.isEmpty(birthday)) {
            ""
        } else birthday
    }

    /**
     * 格式化后的描述
     *
     * @return
     */
    val detailFormat: String?
        get() = if (TextUtils.isEmpty(detail)) {
            "这个人很懒，没有填写个人介绍!"
        } else detail


}