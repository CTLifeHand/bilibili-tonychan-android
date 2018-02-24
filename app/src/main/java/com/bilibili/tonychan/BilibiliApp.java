package com.bilibili.tonychan;

import android.app.Application;

/**
 * Created by CYT on 2018/2/24.
 */

public class BilibiliApp extends Application {

    public static BilibiliApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        init();
    }

    private void init() {
        //初始化Leak内存泄露检测工具
//        LeakCanary.install(this);
//        //初始化Stetho调试工具
//        Stetho.initialize(
//                Stetho.newInitializerBuilder(this)
//                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
//                        .build());
    }

    public static BilibiliApp getInstance() {
        return mInstance;
    }

}
