package com.wurengao.common.abs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wurengao.common.ext.gloge
import com.wurengao.common.ext.longToast
import com.wurengao.common.vm.BaseViewModel
import kotlin.math.log

/**
 * Created by wurengao on 2023/10/16
 * @author wurengao@bytedance.com
 */

abstract class BaseActivity : AppCompatActivity() {

    fun startActivity(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initView()
        initData()
        initListener()
    }

    abstract fun initListener()

    abstract fun initView();

    abstract fun initData();


    fun initViewModel(vm: BaseViewModel) {
        vm.failedResponse.observe(this@BaseActivity) {
            gloge(it.message ?: "")
            it.message.longToast()
        }

        vm.exception.observe(this@BaseActivity) {
            gloge(it.message ?: "")
            it.message.longToast()
        }
    }
}