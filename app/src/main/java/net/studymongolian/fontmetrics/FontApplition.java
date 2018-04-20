package net.studymongolian.fontmetrics;

import android.app.Application;
import net.studymongolian.fontmetrics.utils.ContextUtils;
import net.studymongolian.fontmetrics.utils.DisplayUtils;

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
        DisplayUtils.init(getBaseContext().getResources().getDisplayMetrics());
        ContextUtils.setContext(this);
    }
}
