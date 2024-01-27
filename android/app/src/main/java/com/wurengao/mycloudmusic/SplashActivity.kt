package com.wurengao.mycloudmusic

import android.os.Bundle
import android.view.View
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.wurengao.mycloudmusic.databinding.ActivitySplashBinding
import com.wurengao.mycloudmusic.manager.TimerManager
import java.util.Calendar

class SplashActivity : com.wurengao.common.abs.BaseActivity() {
    private lateinit var viewBinding: ActivitySplashBinding
    private val isAD = false
    private val adDuration = 3000L
    private val adInterval = 1000L

    private val timerManager by lazy {
        TimerManager(adDuration, adInterval)
    }


    private fun startMainActivity() {
        MainActivity.startActivity(this@SplashActivity)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }


    override fun initView() {
        QMUIStatusBarHelper.translucent(this)
        QMUIStatusBarHelper.setStatusBarLightMode(this)
        showNextPage()
    }

    override fun initData() {
        val year = Calendar.getInstance()[Calendar.YEAR]
        viewBinding.copyright.text = getString(R.string.copyright, year)
    }

    override fun initListener() {
        viewBinding.btnADController.setOnClickListener {
            startMainActivity()
        }
    }

    private fun showNextPage() {
        if (!isAD) {
            startMainActivity()
            return
        }
        viewBinding.adPage.visibility = View.VISIBLE
        timerManager.count.observe(this) {
            viewBinding.btnADController.text = getString(R.string.skip, it/1000 + 1)
            if (it == 0L) startMainActivity()
        }
        lifecycle.addObserver(timerManager)
    }
}