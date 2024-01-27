package com.wurengao.music

import android.content.Context
import android.os.Bundle
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
import com.wurengao.common.model.ListResponse
import com.wurengao.common.model.Music
import com.wurengao.common.net.NetworkModule
import com.wurengao.music.api.MusicService
import com.wurengao.music.repository.MusicRepository

/**
 * Created by wurengao on 2023/11/16
 * @author wurengao@bytedance.com
 */


class MusicViewHolder(itemView: View) : ViewHolder(itemView) {
    val titleView: TextView by lazy { itemView.findViewById(R.id.title) }
    val messageView: TextView by lazy { itemView.findViewById(R.id.message) }

}

class MusicListAdapter(private val listData: LiveData<ListResponse<Music>>): RecyclerView.Adapter<MusicViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val listItemView = LayoutInflater.from(parent.context).inflate(R.layout.music_list_item, parent, false)
        val holder = MusicViewHolder(listItemView);
        return holder
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.titleView.text = listData.value?.data?.data?.get(position)?.title ?: "un"
        holder.messageView.text = listData.value?.data?.data?.get(position)?.singer.toString() ?: "un"
    }

    override fun getItemCount(): Int {
        return listData.value?.data?.data?.size ?: 0
    }

}

class MusicFragment : BaseFragment() {

    private val vm: MusicViewModel by lazy {
        val service = NetworkModule.provideRetrofit().create(MusicService::class.java)
        val repository = MusicRepository(service)
        ViewModelProvider(this@MusicFragment, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MusicViewModel(repository) as T
            }
        })[MusicViewModel::class.java]
    }

    private val listData: LiveData<ListResponse<Music>> by lazy { vm.songs() }



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
        listView.adapter = MusicListAdapter(listData)
    }

    override fun initData() {
        listData.observe(this) {
            listView.adapter?.notifyDataSetChanged()
        }
    }

    override fun initListener() {

    }

}