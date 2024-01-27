package com.wurengao.common

import android.app.Application

/**
 * Created by wurengao on 2023/12/22
 * @author wurengao@bytedance.com
 */

class BaseAppContext : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: BaseAppContext
    }
}