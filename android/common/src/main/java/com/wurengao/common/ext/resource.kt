package com.wurengao.common.ext

import com.wurengao.common.config.Config

/**
 * 资源工具类
 */
object ResourceUtil {
    /**
     * 将相对资源转为绝对路径
     *
     * @param data 放到自己服务端的资源以files开头，其他资源都在阿里云oss
     * @return
     */
    fun resourceUri(data: String): String {
        if (data.startsWith("http") || data.startsWith("file://"))
            return data

        if (data.startsWith("/"))
            return "file://${data}"

        return Config.RESOURCE_ENDPOINT.format(data)
    }
}