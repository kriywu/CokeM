package com.wurengao.music.player

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import coil.load
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.wurengao.common.abs.BaseActivity
import com.wurengao.common.ext.glogd
import com.wurengao.common.ext.show
import com.wurengao.common.model.Music
import com.wurengao.music.R

class MusicPlayerActivity : BaseActivity() {

    private val cdView: FrameLayout by lazy { findViewById(R.id.cd) }
    private val music: Music by lazy { intent.getParcelableExtra("music")!! }

    private val cdViewAnimator: ValueAnimator by lazy {
        ValueAnimator.ofFloat(0f, 360f).apply {
            duration = 10 * 1000
            addUpdateListener { cdView.rotation = it.animatedValue as Float }
            repeatCount = -1
        }
    }

    private val cdAvatar: ImageView by lazy {
        findViewById(R.id.cd_avatar)
    }


    companion object {
        fun startActivity(from: Context, music: Music) {
            val intent = Intent(from, MusicPlayerActivity::class.java)
            glogd(music.icon ?: "null")
            intent.putExtra("music", music)
            from.startActivity(intent)
        }
    }


    override fun initListener() {
//        TODO("Not yet implemented")
    }

    override fun initView() {
        QMUIStatusBarHelper.translucent(this)
    }

    override fun initData() {
//        TODO("Not yet implemented")
    }

    @SuppressLint("Recycle")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)

        cdViewAnimator.start()

        cdAvatar.show(music.icon)
    }
}