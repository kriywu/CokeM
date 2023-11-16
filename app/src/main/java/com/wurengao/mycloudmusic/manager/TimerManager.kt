package com.wurengao.mycloudmusic.manager

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created by wurengao on 2023/10/18
 * @author wurengao@bytedance.com
 */

class TimerManager(futureInMills : Long, tickIntervalMills : Long) : LifecycleEventObserver {
    private val TAG = "TimerManager"
    private val _count = MutableLiveData<Long>()
    val count: LiveData<Long>
        get() = _count


    private val timer: CountDownTimer by lazy {
        object : CountDownTimer(futureInMills, tickIntervalMills) {
            // D  onTick: 2894
            // D  onTick: 1893
            // D  onTick: 888
            override fun onTick(p0: Long) {
                Log.d(TAG, "onTick: $p0" )
                _count.value = p0
            }
            override fun onFinish() {
                _count.value = 0
            }
        }
    }

    private fun start() {
        Log.d(TAG, "start: ")
        timer.start()
    }

    private fun stop() {
        timer.cancel()
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START -> start()
            Lifecycle.Event.ON_STOP -> stop()
            else -> {}
        }
    }
}