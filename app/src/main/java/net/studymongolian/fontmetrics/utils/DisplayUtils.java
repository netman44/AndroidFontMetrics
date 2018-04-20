package net.studymongolian.fontmetrics.utils;

import android.util.DisplayMetrics;

/**
 * 在此写用途
 *
 * @author: zhiwei
 * @date: 2018-01-05 15:30
 * @version: 9.1.0
 */
public class DisplayUtils {
    static DisplayMetrics mDisplayMetrics;

    public static void init(DisplayMetrics context) {
        mDisplayMetrics = context;
    }

    /**
     * px 转 dp
     * 注意正负数的四舍五入规则
     * @param px px值
     * @return 转换后的dp值
     */
    public static int px2dp(int px) {
        return (int)(px / mDisplayMetrics.density + (px > 0 ?  0.5F : -0.5F));
    }

    public static int dp2px(int dp) {
        return (int)((float)dp * mDisplayMetrics.density + (dp > 0 ? 0.5F : -0.5F));
    }

    public static int getWidthPixels() {
        return mDisplayMetrics.widthPixels;
    }

}
