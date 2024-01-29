package com.wurengao.music.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.wurengao.common.ext.glogd
import com.wurengao.common.ext.show
import com.wurengao.common.model.ListResponse
import com.wurengao.common.model.Music
import com.wurengao.music.R
import com.wurengao.music.manager.MusicListManager
import com.wurengao.music.player.MusicPlayerActivity

class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView by lazy { itemView.findViewById(R.id.title) }
    val messageView: TextView by lazy { itemView.findViewById(R.id.message) }
    val iconView: ImageView by lazy { itemView.findViewById(R.id.icon) }
}

class MusicListAdapter : RecyclerView.Adapter<MusicViewHolder>() {

    private var listData: List<Music> = ArrayList<Music>()

    public fun updateData(data: List<Music>) {
        listData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val listItemView = LayoutInflater.from(parent.context).inflate(R.layout.music_list_item, parent, false)
        val holder = MusicViewHolder(listItemView);
        return holder
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        glogd("onBindViewHolder")
        val data = listData[position]
        holder.titleView.text = data.title
        holder.messageView.text = data.singer.nickname
        holder.iconView.show(data.icon)
        holder.itemView.setOnClickListener {
            MusicListManager.setData(listData)
            MusicListManager.play(data)
            MusicPlayerActivity.startActivity(it.context)
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}