package net.studymongolian.fontmetrics.emoji;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import net.studymongolian.fontmetrics.R;

/**
 * 在此写用途
 *
 * @author: zhiwei
 * @date: 2018-04-12 21:30
 * @version: 9.1.0
 */
@SuppressLint("AppCompatCustomView")
public class CenterTextView extends TextView {
    Paint mPaint;

    private Paint mAscentPaint;
    private Paint mTopPaint;
    private Paint mBaselinePaint;
    private Paint mDescentPaint;
    private Paint mBottomPaint;
    private Paint mTextBoundsPaint;
    private static final float STROKE_WIDTH = 1.0f;

    private boolean mIsTopVisible;
    private boolean mIsAscentVisible;
    private boolean mIsBaselineVisible;
    private boolean mIsDescentVisible;
    private boolean mIsBottomVisible;
    private boolean mIsBoundsVisible;
    private boolean mIsWidthVisible;

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);

        mAscentPaint = new Paint();
        mAscentPaint.setColor(getResources().getColor(R.color.ascent));
        mAscentPaint.setStrokeWidth(STROKE_WIDTH);

        mTopPaint = new Paint();
        mTopPaint.setColor(getResources().getColor(R.color.top));
        mTopPaint.setStrokeWidth(STROKE_WIDTH);

        mBaselinePaint = new Paint();
        mBaselinePaint.setColor(getResources().getColor(R.color.baseline));
        mBaselinePaint.setStrokeWidth(STROKE_WIDTH);

        mBottomPaint = new Paint();
        mBottomPaint.setColor(getResources().getColor(R.color.bottom));
        mBottomPaint.setStrokeWidth(STROKE_WIDTH);

        mDescentPaint = new Paint();
        mDescentPaint.setColor(getResources().getColor(R.color.descent));
        mDescentPaint.setStrokeWidth(STROKE_WIDTH);
        mTextBoundsPaint = new Paint();
        mTextBoundsPaint.setColor(getResources().getColor(R.color.text_bounds));
        mTextBoundsPaint.setStrokeWidth(STROKE_WIDTH);
        mTextBoundsPaint.setStyle(Paint.Style.STROKE);
    }

    Rect mBounds = new Rect();

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Layout layout = getLayout();
        int count = layout.getLineCount();

        int size = count;
        float startX = 0;
        float startY = 0;
        float stopX = getWidth();
        float stopY = 0;
        for (int i = 1; i <= size; i++) {
            // draw lines
            float top = layout.getLineTop(i);
            float ascent = layout.getLineAscent(i);
            float bottom = layout.getLineBottom(i);
            float descent = layout.getLineDescent(i);
            float baseline = layout.getLineBaseline(i);

            Log.e("zhiwei:", this.getClass().getSimpleName() + " onDraw: top=" + top);
            Log.e("zhiwei:", this.getClass().getSimpleName() + " onDraw: ascent=" + ascent);
            Log.e("zhiwei:", this.getClass().getSimpleName() + " onDraw: bottom=" + bottom);
            Log.e("zhiwei:", this.getClass().getSimpleName() + " onDraw: descent=" + descent);
            Log.e("zhiwei:", this.getClass().getSimpleName() + " onDraw: baseLine=" + baseline);

            if (mIsTopVisible) {
                startY = layout.getLineTop(i);
                stopY = startY;
                canvas.drawLine(startX, startY, stopX, stopY, mTopPaint);
            }

            if (mIsAscentVisible) {
                startY = layout.getLineAscent(i);
                stopY = startY;
                //mLinePaint.setColor(Color.GREEN);
                canvas.drawLine(startX, startY, stopX, stopY, mAscentPaint);
            }

            if (mIsBaselineVisible) {
                startY = 0;
                stopY = startY;
                canvas.drawLine(startX, startY, stopX, stopY, mBaselinePaint);
            }

            if (mIsDescentVisible) {
                startY = layout.getLineDescent(i);
                stopY = startY;
                canvas.drawLine(startX, startY, stopX, stopY, mDescentPaint);
            }

            if (mIsBottomVisible) {
                startY = layout.getLineBottom(i);
                stopY = startY;
                canvas.drawLine(startX, startY, stopX, stopY, mBaselinePaint);
            }

            if (mIsBoundsVisible) {
                layout.getLineBounds(i, mBounds);
                float dx = getPaddingLeft();
                canvas.drawRect(mBounds.left + dx, mBounds.top, mBounds.right + dx, mBounds.bottom, mTextBoundsPaint);
            }

        }

        //canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, mPaint);
        //canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), mPaint);

    }

    public CenterTextView(Context context) {
        super(context);
        init();
    }

    public CenterTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CenterTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setTopVisible(boolean isVisible) {
        mIsTopVisible = isVisible;
        invalidate();
    }

    public void setAscentVisible(boolean isVisible) {
        mIsAscentVisible = isVisible;
        invalidate();
    }

    public void setBaselineVisible(boolean isVisible) {
        mIsBaselineVisible = isVisible;
        invalidate();
    }

    public void setDescentVisible(boolean isVisible) {
        mIsDescentVisible = isVisible;
        invalidate();
    }

    public void setBottomVisible(boolean isVisible) {
        mIsBottomVisible = isVisible;
        invalidate();
    }

    public void setBoundsVisible(boolean isVisible) {
        mIsBoundsVisible = isVisible;
        invalidate();
    }

    public void setWidthVisible(boolean isVisible) {
        mIsWidthVisible = isVisible;
        invalidate();
    }
}
