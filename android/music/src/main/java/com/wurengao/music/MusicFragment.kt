package com.wurengao.music

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.wurengao.common.abs.BaseFragment
import com.wurengao.common.ext.glogd
import com.wurengao.common.model.ListResponse
import com.wurengao.common.model.Meta
import com.wurengao.common.model.Music
import com.wurengao.common.net.NetworkModule
import com.wurengao.music.api.MusicService
import com.wurengao.music.list.MusicListAdapter
import com.wurengao.music.repository.MusicRepository

/**
 * Created by wurengao on 2023/11/16
 * @author wurengao@bytedance.com
 */




class MusicFragment : BaseFragment() {

    private val vm: MusicViewModel by lazy {
        val service = NetworkModule.provideRetrofit().create(MusicService::class.java)
        val repository = MusicRepository(service)
        ViewModelProvider(this@MusicFragment, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MusicViewModel(repository) as T
            }
        })[MusicViewModel::class.java].apply { initViewModel(this) }
    }

    private val listData: LiveData<Meta<Music>?> by lazy { vm.songs() }
    private val adapter: MusicListAdapter by lazy { MusicListAdapter() }

    private lateinit var listView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.music_container, container)
    }

    override fun initView(view: View) {
        listView = view.findViewById(R.id.list)
        listView.layoutManager = LinearLayoutManager(this.context)
        listView.adapter = adapter
    }

    override fun initData() {
        listData.observe(this) {
            it?.data?.apply {
                adapter.updateData(this)
                adapter.notifyItemRangeChanged(0, this.size)
            }
        }
    }

    override fun initListener() {

    }

}