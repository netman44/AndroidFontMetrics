package net.studymongolian.fontmetrics.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.util.Log;

/**
 * 在此写用途
 *
 * @author: zhiwei
 * @date: 2018-04-12 17:37
 * @version: 9.1.0
 */
public class EmojiImageSpanForPostDetail extends ImageSpan{
    private int mExtraSpace = 0;
    public EmojiImageSpanForPostDetail(Context context, Bitmap bitmap, int extraSpace) {
        super(context, bitmap);
        mExtraSpace = extraSpace;
    }

    public EmojiImageSpanForPostDetail(Context context, Bitmap bitmap) {
        super(context, bitmap);
    }

    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fontMetricsInt) {
        Log.e("zhiwei:", "aaaaaaaa 5555getSize: fontMetricsInt=" + fontMetricsInt);
        Drawable drawable = this.getDrawable();
        Rect rect = drawable.getBounds();
        if(fontMetricsInt != null) {
            Paint.FontMetricsInt fmPaint = paint.getFontMetricsInt();
            int fontHeight = fmPaint.bottom - fmPaint.top;
            int drHeight = rect.bottom - rect.top;
            int top = drHeight / 2 - fontHeight / 4;
            int bottom = drHeight / 2 + fontHeight / 4;
            fontMetricsInt.ascent = -bottom;
            fontMetricsInt.top = -bottom;
            fontMetricsInt.bottom = top;
            fontMetricsInt.descent = top;
        }
        Log.e("zhiwei:",  "aaaaaaaa 6666getSize: fontMetricsInt=" + fontMetricsInt);
        return rect.right;
    }
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Log.e("zhiwei:", "aaaaaaaa draw: fm=" + paint.getFontMetricsInt());
        Drawable drawable = this.getDrawable();
        canvas.save();
        //        byte extraSpace = 0;
        int transY = (bottom - top - drawable.getBounds().bottom - mExtraSpace) / 2 + top;
        canvas.translate(x, (float)transY);
        drawable.draw(canvas);
        canvas.restore();
    }
}
