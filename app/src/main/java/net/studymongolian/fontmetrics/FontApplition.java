package net.studymongolian.fontmetrics;

import android.app.Application;

/**
 * 在此写用途
 *
 * @author: zhiwei
 * @date: 2018-04-12 17:49
 * @version: 9.1.0
 */
public class FontApplition extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ContextUtils.setContext(this);
    }
}
