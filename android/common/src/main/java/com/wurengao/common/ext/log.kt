package com.wurengao.common.ext

import android.util.Log
import com.wurengao.common.BaseAppContext


fun glogd(msg: String) = Log.d(BaseAppContext.TAG, msg)

fun gloge(msg: String) = Log.e(BaseAppContext.TAG, msg)