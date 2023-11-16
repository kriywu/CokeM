package com.wurengao.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wurengao.common.abs.BaseFragment

/**
 * Created by wurengao on 2023/11/16
 * @author wurengao@bytedance.com
 */

class ProfileFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_contaienr, null)
    }
    override fun initView(view: View) {

    }

    override fun initData() {

    }

    override fun initListener() {

    }


}