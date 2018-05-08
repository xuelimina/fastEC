package com.yuanting.latte_core.app;

import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

/**
 * Created on 2018/4/17 11:41
 * Created by 薛立民
 * TEL 13262933389
 * 参数调用工具类
 */
public final class Latte {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Context getApplicationContext() {
        return (Context) getConfigurations().get(ConfigKeys.APPLICATION_CONTEXT);
    }
    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }
    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }
    public static HashMap<Object, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }
    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }
}
