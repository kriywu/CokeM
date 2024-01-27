package com.wurengao.common.model

/**
 * Created by wurengao on 2023/12/22
 * @author wurengao@bytedance.com
 */

/**
 * 通用网络请求响应模型
 */
open class BaseResponse {
    /**
     * 状态码
     * 等于0表示成功
     */
    var status = 0

    /**
     * 出错的提示信息
     * 发生了错误不一定有
     */
    var message: String? = null

    override fun toString(): String {
        return "BaseResponse(status=$status, message=$message)"
    }

    fun isSuccess(): Boolean {
        return status == 0
    }
}


/**
 * 详情网络请求解析类
 *
 *
 * 继承BaseResponse
 * 定义了一个泛型T
 */
class DetailResponse<T>(
    /**
     * 真实数据
     * 类似是泛型
     */
    var data: T
) : BaseResponse()


/**
 * 解析列表网络请求
 */
class ListResponse<T>(
    val data: Meta<T>? = null
) : BaseResponse()



/**
 * 解析列表网络请求
 */
class Meta<T> {
    /**
     * 有多少条
     */
    var total: Int = 0

    /**
     * 有多少页
     */
    var pages: Int = 0

    /**
     * 当前每页显示多少条
     */
    var size: Int = 0

    /**
     * 当前页
     */
    var page: Int = 0

    /**
     * 下一页
     */
    var next: Int? = null

    var data: List<T>? = null

    companion object {
        /**
         * 获取下一页
         *
         * @param data
         * @return
         */
        fun nextPage(data: Meta<*>?): Int {
            return if (data == null || data.next == null) {
                1
            } else data.next!!
        }
    }
}