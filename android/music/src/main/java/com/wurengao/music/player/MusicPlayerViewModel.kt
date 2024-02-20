package com.wurengao.music.player

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.wurengao.common.model.Music
import com.wurengao.common.vm.BaseViewModel
import com.wurengao.music.manager.MusicListManager

class MusicPlayerViewModel: BaseViewModel() {

    private val musicListManager: MusicListManager = MusicListManager

    private val _music: MutableLiveData<Music?> = MutableLiveData<Music?>()
    private val _isPlay: MutableLiveData<Boolean> = MutableLiveData(false)

    val music: LiveData<Music?> = _music
    val isPlay: LiveData<Boolean> = _isPlay

    private val _title: MutableLiveData<String> = MutableLiveData()
    val title:LiveData<String> = _title
    private val _message: MutableLiveData<String> = MutableLiveData()
    val message:LiveData<String> = _message
    private val _process: MutableLiveData<Float> = MutableLiveData()
    val process:LiveData<Float> =_process
    private val _icon: MutableLiveData<String> = MutableLiveData()
    val icon:LiveData<String> = _icon

    fun previous() {
        _music.value = musicListManager.previousPlay()
        _process.value = 0f
        notifyDataChange()
    }

    fun next() {
        _music.value = musicListManager.nextPlay()
        _process.value = 0f
        notifyDataChange()
    }

    private fun notifyDataChange() {
        _title.value = _music.value?.title
        _message.value = _music.value?.singer?.nickname
        _icon.value = _music.value?.icon
    }

    fun list() = musicListManager.list()

    fun playOrPause() {

    }

    fun onResume() {
        _music.value = musicListManager.currentMusic()
        notifyDataChange()
    }
}