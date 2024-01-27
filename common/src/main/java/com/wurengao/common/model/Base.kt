package com.wurengao.common.model

import androidx.room.PrimaryKey

/**
 * Created by wurengao on 2023/12/22
 * @author wurengao@bytedance.com
 */
open class Base


/**
 * 所有模型Id父类
 */
open class BaseId : Base() {
    @PrimaryKey
    lateinit var id: String
}


/**
 * 所有模型父类
 */
open class Common : BaseId() {
    /**
     * 创建时间
     */
    var createdAt: String? = null

    /**
     * 更新时间
     */
    var updatedAt: String? = null
}