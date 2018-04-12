package net.studymongolian.fontmetrics;

import android.content.Context;

/**
 * 在此写用途
 *
 * @author: zhiwei
 * @date: 2018-04-12 17:48
 * @version: 9.1.0
 */
public class ContextUtils {
    private static Context sContext;

    /**
     *
     * @param context context, 设置全局的Context
     */
    public static void setContext(Context context) {
        sContext = context;
    }

    /**
     * @return Context， 获取全局的Context
     */
    public static Context getContext() {
        return sContext;
    }
}
