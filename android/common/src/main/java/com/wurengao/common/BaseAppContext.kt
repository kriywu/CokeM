package com.wurengao.common

import android.app.Application

/**
 * Created by wurengao on 2023/12/22
 * @author wurengao@bytedance.com
 */

class BaseAppContext : Application() {


    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    companion object {

        const val TAG = "GlobalTAG"

        lateinit var instance: BaseAppContext
    }
}