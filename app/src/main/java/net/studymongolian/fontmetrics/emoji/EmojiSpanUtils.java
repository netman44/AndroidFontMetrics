package net.studymongolian.fontmetrics.emoji;

import java.util.List;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import net.studymongolian.fontmetrics.ContextUtils;
import net.studymongolian.fontmetrics.R;

/**
 * Created by kai
 * since 16/11/12
 */
public class EmojiSpanUtils {
    public static final int TYPE_HIGH_QUALITY = 1;//优质
    public static final int TYPE_EXCLUSIVE = 2;//独家
    public static final int TYPE_ESSENCE = 3;//精华
    //0205版本页卡中有可能出现的标签：置顶，热评
    //优质和独家，位置优先于精华
    public static final int TYPE_TOP = 5;//置顶
    public static final int TYPE_HOT = 6;//热评

    //客户端自定义
    public static final int TYPE_QA = -1000;//问答
    public static final int TYPE_VOTE = -1001;//投票

    public static final int TYPE_TOPIC = 0;
    public static final int TYPE_SPECIAL_SUBJECT = 1;
    public static final int TYPE_PK = 2;


    /**
     * 评论专用的   构建页卡的带tag的标题（主要是tag部分）
     * @param title 标题
     * @param tags 标签列表
     * @return 带tag的标题
     */
    public static CharSequence buildSpan(CharSequence title, List<Integer> tags ) {
        if (title == null) {
            title = "";
        }

        final SpannableStringBuilder ss = new SpannableStringBuilder();
        int beginIndex = 0;

        if (tags.contains(TYPE_TOP)) {
            ss.append("置顶 ");
            Drawable highQualityDrawable = ContextUtils.getContext().getResources().getDrawable(R.drawable.planet_comment_card_tag_top);

            ImageSpan span = new EmojiImageSpan(
                ContextUtils.getContext(),
                ((BitmapDrawable) highQualityDrawable).getBitmap());
            ss.setSpan(span, beginIndex, beginIndex + 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            beginIndex = ss.length();
        }

        ss.append(title);
        return ss;
    }

    /**
     * 评论专用的   构建页卡的带tag的标题（主要是tag部分）
     * @param title 标题
     * @param tags 标签列表
     * @return 带tag的标题
     */
    public static CharSequence buildSpanOld(CharSequence title, List<Integer> tags ) {
        if (title == null) {
            title = "";
        }

        final SpannableStringBuilder ss = new SpannableStringBuilder();
        int beginIndex = 0;

        if (tags.contains(TYPE_TOP)) {
            ss.append("置顶 ");
            Drawable highQualityDrawable = ContextUtils.getContext().getResources().getDrawable(R.drawable.planet_comment_card_tag_top);

            ImageSpan span = new EmojiImageSpanForPostDetail(
                ContextUtils.getContext(),
                ((BitmapDrawable) highQualityDrawable).getBitmap(), 0);
            ss.setSpan(span, beginIndex, beginIndex + 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            beginIndex = ss.length();
        }

        ss.append(title);
        return ss;
    }

}
