package com.wurengao.mycloudmusic.mainpage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wurengao.feed.FeedFragment
import com.wurengao.music.MusicFragment
import com.wurengao.profile.ProfileFragment

/**
 * Created by wurengao on 2023/11/20
 * @author wurengao@bytedance.com
 */

class MainPageViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
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