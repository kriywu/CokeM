package com.wurengao.music.manager

import com.wurengao.common.ext.glogd
import com.wurengao.common.model.Music


enum class PLAY_MODE {
    LOOP,
    RANDOM,
    ORDER,
}

enum class PLAY_CONTROLLER {
    PRE,
    NEXT,
}
object MusicListManager {
    private var currentPlayMusic:Music? = null
    private var currentPlayMusicIndex: Int = -1
    private var list: List<Music> = emptyList()
    private var mode: PLAY_MODE = PLAY_MODE.ORDER


    fun setData(data: List<Music>) {
        list = data
    }

    fun list() = list


    fun previousPlay(): Music? {
        return play(PLAY_CONTROLLER.PRE)
    }

    fun nextPlay(): Music? {
        return play(PLAY_CONTROLLER.NEXT)
    }

    fun play(music: Music) {
        currentPlayMusic = music
    }

    private fun play(action: PLAY_CONTROLLER): Music? {
        return when(mode) {
            PLAY_MODE.LOOP -> currentPlayMusic
            PLAY_MODE.RANDOM -> currentPlayMusic
            PLAY_MODE.ORDER -> {
                currentPlayMusicIndex = when(action) {
                    PLAY_CONTROLLER.PRE -> (currentPlayMusicIndex + 1) % list.size
                    PLAY_CONTROLLER.NEXT -> (currentPlayMusicIndex - 1 + list.size) % list.size
                }
                glogd("$currentPlayMusicIndex")
                currentPlayMusic = list[currentPlayMusicIndex]
                currentPlayMusic
            }
        }
    }


    fun currentMusic() :Music? {
        return currentPlayMusic
    }

}