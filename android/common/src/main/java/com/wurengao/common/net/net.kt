package com.wurengao.common.net

import com.wurengao.common.BaseAppContext
import com.wurengao.common.config.Config
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by wurengao on 2023/12/22
 * @author wurengao@bytedance.com
 */


/**
 * 网络相关依赖提供类
 * 例如：OkHttp，retrofit依赖
 */
object NetworkModule {
    /**
     * 提供OkHttpClient
     */
    val okHttpClient by lazy {
        //初始化okhttp
        val okhttpClientBuilder = OkHttpClient.Builder()
        //配置缓存
        val cache = Cache(BaseAppContext.instance.cacheDir, Config.NETWORK_CACHE_SIZE)
        okhttpClientBuilder.cache(cache)
        okhttpClientBuilder.connectTimeout(10, TimeUnit.SECONDS) //连接超时时间
            .writeTimeout(10, TimeUnit.SECONDS) //写，也就是将数据发送到服务端超时时间
            .readTimeout(10, TimeUnit.SECONDS) //读，将服务端的数据下载到本地
        if (Config.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()//创建okhttp日志拦截器
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC //设置日志等级
            okhttpClientBuilder.addInterceptor(loggingInterceptor) //添加到网络框架中
        }
        okhttpClientBuilder.build()
    }

    /**
     * 提供Retrofit实例
     *
     * @param okHttpClient
     * @return
     */
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder() //让retrofit使用okhttp
            .client(okHttpClient) //api地址
            .baseUrl(Config.ENDPOINT) //适配rxjava
//            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            //包括请求参数和响应
            .addConverterFactory(GsonConverterFactory.create()) //使用gson解析json
            .build()
    }
}