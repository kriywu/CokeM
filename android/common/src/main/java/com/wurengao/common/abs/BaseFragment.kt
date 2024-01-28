package com.wurengao.common.abs

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wurengao.common.vm.BaseViewModel


abstract class BaseFragment : Fragment() {
    protected val TAG = "BaseFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "${this.javaClass.simpleName} onCreate: ")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "${this.javaClass.simpleName} onAttach: ")
    }

    abstract fun initView(view: View)

    abstract fun initData()

    abstract fun initListener()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "${this.javaClass.simpleName} onCreateView: ")
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "${this.javaClass.simpleName} onViewCreated: ")
        initView(view)
        initData()
        initListener()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "${this.javaClass.simpleName} onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "${this.javaClass.simpleName} onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "${this.javaClass.simpleName} onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "${this.javaClass.simpleName} onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "${this.javaClass.simpleName} onDestroyView: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "${this.javaClass.simpleName} onDetach: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "${this.javaClass.simpleName} onDestroy: ")
    }

    fun initViewModel(viewModel: BaseViewModel) {
        (activity as? BaseActivity)?.initViewModel(viewModel)
    }
}