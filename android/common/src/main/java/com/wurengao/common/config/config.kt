package com.wurengao.common.config

import com.qmuiteam.qmui.BuildConfig

/**
 * Created by wurengao on 2023/12/22
 * @author wurengao@bytedance.com
 */
object Config {

    /**
     * 是否是调试模式
     */
    val DEBUG = BuildConfig.DEBUG

    /**
     * 端点
     */
    var ENDPOINT = "http://cloud-music-lite-sp.ixuea.com/"

    /**
     * 资源端点
     */
    var RESOURCE_ENDPOINT = "http://course-music-dev.ixuea.com/%s"

    /**
     * 网络缓存目录大小
     * 100M
     */
    const val NETWORK_CACHE_SIZE = (1024 * 1024 * 100).toLong()
}