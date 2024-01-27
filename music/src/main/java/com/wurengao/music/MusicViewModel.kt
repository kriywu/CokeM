package com.wurengao.music

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wurengao.music.repository.MusicRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

/**
 * Created by wurengao on 2023/11/20
 * @author wurengao@bytedance.com
 */

class MusicViewModel(
    private var repository: MusicRepository
) : ViewModel() {
    /**
     * 音乐列表
     */
    fun songs() = flow {
        val data = repository.songs()
        if (data.isSuccess()) {
            emit(data)
        }
    }.catch {
    }.asLiveData()
}