package com.wurengao.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wurengao.common.abs.BaseFragment
import com.wurengao.common.net.NetworkModule
import com.wurengao.music.api.MusicService
import com.wurengao.music.repository.MusicRepository

/**
 * Created by wurengao on 2023/11/16
 * @author wurengao@bytedance.com
 */

class MusicFragment : BaseFragment() {

    private lateinit var vm: MusicViewModel
    private lateinit var tv: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.music_container, container)
    }

    override fun initView(view: View) {
        tv = view.findViewById<TextView>(R.id.tv_test)

    }

    override fun initData() {
//        vm = ViewModelProvider(this).get(MusicViewModel::class.java)
//        vm.getMusics().observe(this) {
//            Log.d(TAG, "observe: $it")
//            if (TextUtils.isEmpty(it)) {
//                tv.text = "loading"
//            } else {
//                tv.text = it
//            }
//        }

        val service = NetworkModule.provideRetrofit().create(MusicService::class.java)
        val repository = MusicRepository(service)

        vm = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MusicViewModel(repository) as T
            }
        }).get(MusicViewModel::class.java)
    }

    override fun initListener() {

    }

}