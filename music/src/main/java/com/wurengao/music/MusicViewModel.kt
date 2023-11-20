package com.wurengao.music

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by wurengao on 2023/11/20
 * @author wurengao@bytedance.com
 */

class MusicViewModel : ViewModel() {

    private val musics: MutableLiveData<String> by lazy {
        val temp = MutableLiveData<String>("")
        loadMusics {
            temp.postValue(it)
        }
        temp
    }

    fun getMusics() : LiveData<String> {
        return musics
    }

    private fun loadMusics(callback: (data: String)->Unit) {
        // mock get network data

        Thread{
            Thread.sleep(3000)
            val data = "from network"
            callback(data)
        }.start()
    }
}