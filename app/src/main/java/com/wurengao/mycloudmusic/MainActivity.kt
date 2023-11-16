package com.wurengao.mycloudmusic

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.view.forEachIndexed
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wurengao.feed.FeedFragment
import com.wurengao.music.MusicFragment
import com.wurengao.profile.ProfileFragment

class MainActivity : com.wurengao.common.abs.BaseActivity() {
    private  val TAG = "MainActivity"
    override fun initListener() {
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = findViewById<ViewPager2>(R.id.vp_content)
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)


        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return 3
            }

            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> MusicFragment()
                    1 -> FeedFragment()
                    else -> ProfileFragment()
                }
            }
        }
        viewPager.offscreenPageLimit = 3
        viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {


            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                navigation.selectedItemId = navigation.menu.getItem(position).itemId
            }
        })

        navigation.setOnItemSelectedListener {
            navigation.menu.forEachIndexed { index, item ->
                if (item == it) {
                    viewPager.setCurrentItem(index)
                }
            }
            Log.d(TAG, "setOnItemSelectedListener: ${it.order}")
            return@setOnItemSelectedListener true
        }

    }

    companion object {
        fun startActivity(from: com.wurengao.common.abs.BaseActivity) {
            val intent = Intent(from, MainActivity::class.java)
            from.startActivity(intent)
        }
    }
}