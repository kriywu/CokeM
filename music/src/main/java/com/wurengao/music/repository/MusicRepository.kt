package com.wurengao.music.repository

import com.wurengao.common.model.ListResponse
import com.wurengao.common.model.Music
import com.wurengao.music.api.MusicService

/**
 * Created by wurengao on 2023/12/22
 * @author wurengao@bytedance.com
 */

class MusicRepository(
    private var service: MusicService
) {
    suspend fun songs(): ListResponse<Music> {
        return service.songs()
    }
}