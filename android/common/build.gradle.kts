// 使用系统的插件
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
// 引入外部脚本
apply(from= "../common.gradle")

android {
    namespace = "com.wurengao.common"
}
dependencies {
    implementation("androidx.core:core-ktx:1.12.0")

    // api 传递依赖， implementation 内部依赖
    api("com.google.code.gson:gson:2.9.0")

    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:converter-gson:2.9.0")

    api("com.squareup.okhttp3:okhttp:4.9.3")
    api("com.squareup.okhttp3:logging-interceptor:4.9.3")

    api("androidx.fragment:fragment-ktx:1.6.2")
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    //region room数据库
    //https://developer.android.google.cn/topic/libraries/architecture/room
    api("androidx.room:room-runtime:2.4.3")
    api("androidx.room:room-ktx:2.4.3")
    testApi("androidx.room:room-testing:2.4.3")// optional - Test helpers
    api("androidx.room:room-paging:2.4.3")// optional - Paging 3 Integration
    //endregion
}
