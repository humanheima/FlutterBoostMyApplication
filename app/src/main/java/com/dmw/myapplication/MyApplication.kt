package com.dmw.myapplication

import android.app.Application
import android.content.Context
import com.idlefish.flutterboost.NewFlutterBoost
import com.idlefish.flutterboost.Utils
import com.idlefish.flutterboost.interfaces.INativeRouter

/**
 * Created by dumingwei on 2019-10-26.
 * Desc:
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val router: INativeRouter = object : INativeRouter {
            override fun openContainer(
                context: Context?,
                url: String?,
                urlParams: MutableMap<String, Any>?,
                requestCode: Int,
                exts: MutableMap<String, Any>?
            ) {
                val assembleUrl = Utils.assembleUrl(url, urlParams)
                PageRouter.openPageByUrl(context, assembleUrl, urlParams)
            }

        }

        val platform = NewFlutterBoost.ConfigBuilder(this, router)
            .isDebug(true)
            .whenEngineStart(NewFlutterBoost.ConfigBuilder.ANY_ACTIVITY_CREATED)
            .build()

        NewFlutterBoost.instance().init(platform)
    }
}