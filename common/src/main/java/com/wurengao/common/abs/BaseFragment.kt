package com.wurengao.common.abs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment


abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    abstract fun initView(view: View)

    abstract fun initData()

    abstract fun initListener()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initData()
        initListener()
    }
}