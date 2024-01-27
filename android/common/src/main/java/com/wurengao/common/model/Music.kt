package com.wurengao.common.model

/**
 * Created by wurengao on 2023/12/22
 * @author wurengao@bytedance.com
 */

/**
 * 单曲模型
 */
class Music : Common() {
    /**
     * 标题
     */
    var title: String? = null

    /**
     * 封面
     */
    var icon: String? = null

    /**
     * 音乐地址
     */
    var uri: String? = null

    /**
     * 点击数
     */
    var clicksCount = 0

    /**
     * 评论数
     */
    var commentsCount = 0

    /**
     * 创建该音乐的人
     */
    lateinit var user: User

    /**
     * 歌手
     */
    lateinit var singer: User
    //region 播放后才有值
    /**
     * 总进度
     * 单位:毫秒
     */
    var duration = 0

    /**
     * 播放进度
     */
    var progress = 0
    //endregion
    /**
     * 歌手Id
     *
     *
     * 在sqlite，mysql这样的数据库中
     * 字段名建议用下划线
     * 而不是驼峰命名
     *
     *
     * 用来将歌手对象拆分到多个字段，方便在一张表存储，和查询
     */
    lateinit var singerId: String

    /**
     * 歌手名称
     */
    var singerNickname: String? = null

    /**
     * 歌手头像
     * 可选值
     */
    var singerIcon: String? = null
    fun localConvert() {
        val user = User()
        user.id = singerId
        user.nickname = singerNickname
        user.icon = singerIcon
        singer = user
    }

    fun convertLocal() {
        singerId = singer!!.id
        singerNickname = singer!!.nickname
        singerIcon = singer!!.icon
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Music

        if (title != other.title) return false
        if (icon != other.icon) return false
        if (uri != other.uri) return false
        if (clicksCount != other.clicksCount) return false
        if (commentsCount != other.commentsCount) return false
        if (user != other.user) return false
        if (singer != other.singer) return false
        if (duration != other.duration) return false
        if (progress != other.progress) return false
        if (singerId != other.singerId) return false
        if (singerNickname != other.singerNickname) return false
        if (singerIcon != other.singerIcon) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title?.hashCode() ?: 0
        result = 31 * result + (icon?.hashCode() ?: 0)
        result = 31 * result + (uri?.hashCode() ?: 0)
        result = 31 * result + clicksCount
        result = 31 * result + commentsCount
        result = 31 * result + user.hashCode()
        result = 31 * result + singer.hashCode()
        result = 31 * result + duration
        result = 31 * result + progress
        result = 31 * result + singerId.hashCode()
        result = 31 * result + (singerNickname?.hashCode() ?: 0)
        result = 31 * result + (singerIcon?.hashCode() ?: 0)
        return result
    }


}