package com.wurengao.music

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.wurengao.common.BaseAppContext
import com.wurengao.common.ext.gloge
import com.wurengao.common.vm.BaseViewModel
import com.wurengao.music.repository.MusicRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.lang.NullPointerException

/**
 * Created by wurengao on 2023/11/20
 * @author wurengao@bytedance.com
 */

class MusicViewModel(
    private var repository: MusicRepository
) : BaseViewModel() {
    /**
     * 音乐列表
     */
    fun songs() = flow {
        val data = repository.songs()
        if (data.isSuccess()) {
            emit(data.data)
        } else {
            failedResponse.value = data
        }
    }.catch {
        exception.value = it
    }.asLiveData( )
}