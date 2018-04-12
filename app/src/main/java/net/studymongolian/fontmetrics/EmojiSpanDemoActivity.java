package net.studymongolian.fontmetrics;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import net.studymongolian.fontmetrics.emoji.EmojiSpanUtils;

public class EmojiSpanDemoActivity extends Activity {
    static final float DEFAULT_FONT_SIZE = 14;
    private TextView mEmojiText;
    private TextView mOldEmojiText;
    private SeekBar mTextSizeSeekBar;
    private TextView mHaveFontPadding;
    private TextView mNoFontPadding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_emoji_span_demo);
        initView();
        List<Integer> tag = new ArrayList<>();
        tag.add(5);
        String singleText = "测试测试HhJjYyGg";
        mEmojiText.setText(EmojiSpanUtils.buildSpan(singleText, tag));

        singleText = "old测试测试HhJjYyGg";
        mOldEmojiText.setText(EmojiSpanUtils.buildSpanOld(singleText, tag));
    }

    void setTextSize(float size) {
        mEmojiText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
        mOldEmojiText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
        mHaveFontPadding.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
        mNoFontPadding.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
    }

    private void initView() {
        mEmojiText = (TextView)findViewById(R.id.emoji_text);
        mOldEmojiText = (TextView)findViewById(R.id.old_emoji_text);
        mTextSizeSeekBar = (SeekBar)findViewById(R.id.textSizeSeekBar);
        mHaveFontPadding = (TextView)findViewById(R.id.haveFontPadding);
        mNoFontPadding = (TextView)findViewById(R.id.noFontPadding);

        setTextSize(DEFAULT_FONT_SIZE);

        mTextSizeSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float fontSize = DEFAULT_FONT_SIZE + DEFAULT_FONT_SIZE * (progress - mTextSizeSeekBar.getMax() / 2) / 100;
                setTextSize(fontSize);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
