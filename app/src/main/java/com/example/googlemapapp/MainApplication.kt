package com.example.googlemapapp

import android.app.Application
import android.util.Log
import com.tencent.smtt.sdk.QbSdk
import com.tencent.smtt.sdk.QbSdk.PreInitCallback


/**
 * desc:
 * author: zouhecan {hc.zou@ctrip.com}
 * date: 2020/4/27
 */
class MainApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        initX5()
    }

    private fun initX5() {
        QbSdk.setDownloadWithoutWifi(true)
        //x5内核初始化接口//搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.initX5Environment(applicationContext, object : PreInitCallback {
            override fun onViewInitFinished(arg0: Boolean) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("MainApplication", " onViewInitFinished is $arg0")
            }

            override fun onCoreInitFinished() {}
        })
    }
}