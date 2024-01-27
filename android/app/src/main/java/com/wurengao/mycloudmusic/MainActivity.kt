package com.wurengao.mycloudmusic

import android.content.Intent
import android.os.Bundle
import androidx.core.view.forEachIndexed
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wurengao.common.abs.BaseActivity
import com.wurengao.mycloudmusic.mainpage.MainPageViewPagerAdapter

class MainActivity : BaseActivity() {
    private  val TAG = "MainActivity"

    // view
    private lateinit var viewPager: ViewPager2
    private lateinit var navigation: BottomNavigationView


    override fun initListener() {
    }

    override fun initView() {
        viewPager = findViewById(R.id.vp_content)
        navigation = findViewById(R.id.navigation)
        initPager()
        initNavigation()
    }

    override fun initData() {
    }

    private fun initPager() {
        viewPager.adapter = MainPageViewPagerAdapter(this)
        viewPager.offscreenPageLimit = 1
        viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                navigation.selectedItemId = navigation.menu.getItem(position).itemId
            }
        })
    }

    private fun initNavigation() {
        navigation.setOnItemSelectedListener {
            navigation.menu.forEachIndexed { index, item ->
                if (item == it) {
                    viewPager.currentItem = index
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        fun startActivity(from: com.wurengao.common.abs.BaseActivity) {
            val intent = Intent(from, MainActivity::class.java)
            from.startActivity(intent)
        }
    }
}