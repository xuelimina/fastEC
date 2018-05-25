package com.yuanting.fastec;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.yuanting.latte.ec.database.DatabaseManager;
import com.yuanting.latte.ec.icon.FontEcModule;
import com.yuanting.latte_core.app.Latte;
import com.yuanting.latte_core.net.interceptors.DebugInterceptor;

/**
 * Created on 2018/4/17 15:07
 * Created by 薛立民
 * TEL 13262933389
 */
public class FastECApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(getApplicationContext()).withApiHost("http://oxjde2kpq.bkt.clouddn.com/")
                .withIcons(new FontAwesomeModule())
                .withLoaderDelayed(500)
                .withWeChatAppID("微信AppKey").withWeChatAppSecret("微信AppSecret")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .withJavascriptInterface("latte")
                .withIcons(new FontEcModule()).configure();
        DatabaseManager.getInstance().init(this);
        initStetho();
    }

    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build()
        );
    }
}
