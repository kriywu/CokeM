// 使用系统的插件
plugins {
    id("com.android.library")
}
// 引入外部脚本
apply(from= "../common.gradle")

android {
    namespace = "com.wurengao.common"
}
