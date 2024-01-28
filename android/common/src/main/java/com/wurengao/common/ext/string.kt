package com.wurengao.common.ext

import android.widget.Toast
import com.wurengao.common.BaseAppContext

fun String?.longToast() = Toast.makeText(BaseAppContext.instance, this, Toast.LENGTH_LONG).show()

fun String?.toast() = Toast.makeText(BaseAppContext.instance, this, Toast.LENGTH_SHORT).show()