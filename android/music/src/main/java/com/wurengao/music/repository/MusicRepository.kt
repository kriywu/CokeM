package com.wurengao.music.repository

import android.util.Log
import com.wurengao.common.BaseAppContext
import com.wurengao.common.ext.glogd
import com.wurengao.common.model.ListResponse
import com.wurengao.common.model.Music
import com.wurengao.music.api.MusicService
import kotlinx.coroutines.delay

/**
 * Created by wurengao on 2023/12/22
 * @author wurengao@bytedance.com
 *
 * 音乐的数据仓库，控制数据加载的数据源，网络、数据
 */

class MusicRepository(
    private var service: MusicService
) {

    suspend fun songs(): ListResponse<Music> {
        glogd("get songs req")
        return service.songs()
    }
}