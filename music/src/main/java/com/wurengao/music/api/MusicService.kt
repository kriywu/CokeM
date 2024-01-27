package com.wurengao.music.api

import com.wurengao.common.model.ListResponse
import com.wurengao.common.model.Music
import retrofit2.http.GET

/**
 * Created by wurengao on 2023/12/22
 * @author wurengao@bytedance.com
 */
interface MusicService {
    @GET("v1/songs")
    suspend fun songs() : ListResponse<Music>
}