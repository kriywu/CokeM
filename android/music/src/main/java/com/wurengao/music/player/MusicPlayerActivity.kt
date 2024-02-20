package com.wurengao.music.player

import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.wurengao.common.abs.BaseActivity
import com.wurengao.common.ext.glogd
import com.wurengao.common.ext.longToast
import com.wurengao.common.ext.show
import com.wurengao.common.ext.toast
import com.wurengao.common.model.Music
import com.wurengao.music.R
import com.wurengao.music.manager.MusicListManager
import org.w3c.dom.Text

class MusicPlayerActivity : BaseActivity() {
    private val titleView: TextView by lazy { findViewById(R.id.nav_title) }
    private val subtitleView: TextView by lazy { findViewById(R.id.nav_subtitle) }
    private val cdView: FrameLayout by lazy { findViewById(R.id.cd) }
    private val previousView: View by lazy { findViewById(R.id.previous) }
    private val playView: View by lazy { findViewById(R.id.play) }
    private val nextView: View by lazy { findViewById(R.id.next) }
    private val musicListView: View by lazy { findViewById(R.id.list_button) }
    private val progressView: SeekBar by lazy { findViewById(R.id.progress) }
    private val vm: MusicPlayerViewModel by lazy {
        ViewModelProvider(this@MusicPlayerActivity)[MusicPlayerViewModel::class.java]
    }

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
        fun startActivity(from: Context) {
            val intent = Intent(from, MusicPlayerActivity::class.java)
            from.startActivity(intent)
        }
    }


    override fun initListener() {
        previousView.setOnClickListener { vm.previous() }

        nextView.setOnClickListener { vm.next() }

        playView.setOnClickListener { vm.playOrPause() }

        musicListView.setOnClickListener {
            "click hhhh ${vm.list().size}".toast()
        }

        vm.title.observe(this) {
            titleView.text = it
        }

        vm.message.observe(this) {
            subtitleView.text = it
        }

        vm.process.observe(this) {
            progressView.progress = it.toInt()
        }

        vm.icon.observe(this) {
            cdAvatar.show(it)
        }
    }

    override fun initView() {
        QMUIStatusBarHelper.translucent(this)
    }

    override fun initData() {
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)

        cdViewAnimator.start()

        MusicListManager.currentMusic()?.let {
            cdAvatar.show(it.icon)
        }


    }

    override fun onResume() {
        super.onResume()
        vm.onResume()
    }
}