package com.wurengao.common.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wurengao.common.model.BaseResponse

abstract class BaseViewModel: ViewModel() {

    open val exception = MutableLiveData<Throwable>()

    open val failedResponse = MutableLiveData<BaseResponse>()

}