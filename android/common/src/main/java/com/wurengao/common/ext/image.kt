package com.wurengao.common.ext

import android.widget.ImageView
import coil.load
import com.wurengao.common.R

fun ImageView.show(data: String?) {
    if (data.isNullOrEmpty()) return

    load(ResourceUtil.resourceUri(data)) {
        placeholder(R.drawable.default_avatar)
    }
}