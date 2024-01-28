package com.wurengao.music.player

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wurengao.common.abs.BaseActivity
import com.wurengao.music.R

class MusicPlayerActivity : BaseActivity() {


    companion object {
        fun startActivity(from: Context) {
            val intent = Intent(from, MusicPlayerActivity::class.java)
            from.startActivity(intent)
        }
    }


    override fun initListener() {
//        TODO("Not yet implemented")
    }

    override fun initView() {
//        TODO("Not yet implemented")
    }

    override fun initData() {
//        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)
    }
}