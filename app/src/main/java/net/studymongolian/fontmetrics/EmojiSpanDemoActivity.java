package net.studymongolian.fontmetrics;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import net.studymongolian.fontmetrics.emoji.CenterTextView;
import net.studymongolian.fontmetrics.emoji.EmojiSpanUtils;
import net.studymongolian.fontmetrics.utils.DisplayUtils;

public class EmojiSpanDemoActivity extends Activity implements View.OnClickListener {
    CheckBox cbTop;
    CheckBox cbAscent;
    CheckBox cbBaseline;
    CheckBox cbDescent;
    CheckBox cbBottom;
    CheckBox cbBounds;
    CheckBox cbMeasuredWidth;

    TextView tvTop;
    TextView tvAscent;
    TextView tvBaseline;
    TextView tvDescent;
    TextView tvBottom;
    TextView tvBounds;
    TextView tvLeading;

    static final float DEFAULT_FONT_SIZE = 14;
    private CenterTextView mEmojiText;
    private CenterTextView mOldEmojiText;
    private SeekBar mTextSizeSeekBar;
    private TextView mHaveFontPadding;
    private TextView mNoFontPadding;
    private TextView mFontPadding;
    private CheckBox mFontPaddingCheck;
    private CheckBox mSpaceCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_emoji_span_demo);
        initView();
        List<Integer> tag = new ArrayList<>();
        tag.add(EmojiSpanUtils.TYPE_TOP);
        tag.add(EmojiSpanUtils.TYPE_ESSENCE);
        String singleText = "测试测试HhJjYyGg";
        mEmojiText.setText(EmojiSpanUtils.buildSpan(singleText, tag));

        singleText = "测试测试HhJjYyGg";
        mOldEmojiText.setText(EmojiSpanUtils.buildSpanOld(singleText, tag));
    }

    void setTextSize(float size) {
        mEmojiText.setTypeface();
        mEmojiText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
        mOldEmojiText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
        mHaveFontPadding.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
        mNoFontPadding.setTextSize(TypedValue.COMPLEX_UNIT_DIP, size);
    }

    void setIncludeFontPadding(boolean size) {
        mEmojiText.setIncludeFontPadding(size);
        mOldEmojiText.setIncludeFontPadding(size);
    }

    private void initView() {
        mEmojiText = (CenterTextView)findViewById(R.id.emoji_text);
        mOldEmojiText = (CenterTextView)findViewById(R.id.old_emoji_text);
        mTextSizeSeekBar = (SeekBar)findViewById(R.id.textSizeSeekBar);
        mHaveFontPadding = (TextView)findViewById(R.id.haveFontPadding);
        mNoFontPadding = (TextView)findViewById(R.id.noFontPadding);

        setTextSize(DEFAULT_FONT_SIZE);

        mTextSizeSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float fontSize = DEFAULT_FONT_SIZE
                    + DEFAULT_FONT_SIZE * (progress - mTextSizeSeekBar.getMax() / 2) / 100;
                setTextSize(fontSize);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mFontPadding = (TextView)findViewById(R.id.fontPadding);
        mFontPaddingCheck = (CheckBox)findViewById(R.id.fontPadding_check);

        mFontPaddingCheck.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setIncludeFontPadding(isChecked);
            }
        });
        mSpaceCheck = (CheckBox)findViewById(R.id.space_check);
        mSpaceCheck.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setSpace(isChecked);
            }
        });
        initFont();
    }

    void initFont() {
        cbTop = (CheckBox)findViewById(R.id.cbTop);
        cbAscent = (CheckBox)findViewById(R.id.cbAscent);
        cbBaseline = (CheckBox)findViewById(R.id.cbBaseline);
        cbDescent = (CheckBox)findViewById(R.id.cbDescent);
        cbBottom = (CheckBox)findViewById(R.id.cbBottom);
        cbBounds = (CheckBox)findViewById(R.id.cbTextBounds);
        cbMeasuredWidth = (CheckBox)findViewById(R.id.cbWidth);

        cbAscent.setOnClickListener(this);
        cbBaseline.setOnClickListener(this);
        cbDescent.setOnClickListener(this);
        cbBottom.setOnClickListener(this);
        cbBounds.setOnClickListener(this);

        tvTop = (TextView) findViewById(R.id.tvTop);
        tvAscent = (TextView) findViewById(R.id.tvAscent);
        tvBaseline = (TextView) findViewById(R.id.tvBaseline);
        tvDescent = (TextView) findViewById(R.id.tvDescent);
        tvBottom = (TextView) findViewById(R.id.tvBottom);
        tvBounds = (TextView) findViewById(R.id.tvTextBounds);
        tvLeading = (TextView) findViewById(R.id.tvLeadingValue);
    }

    void setSpace(boolean have) {
        int spze = have ? DisplayUtils.dp2px(50) : 0;
        mHaveFontPadding.setLineSpacing(spze, 0);
        mNoFontPadding.setLineSpacing(spze, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cbTop:
                mEmojiText.setTopVisible(cbTop.isChecked());
                mOldEmojiText.setTopVisible(cbTop.isChecked());
                break;
            case R.id.cbAscent:
                mEmojiText.setAscentVisible(cbAscent.isChecked());
                mOldEmojiText.setAscentVisible(cbAscent.isChecked());
                break;
            case R.id.cbBaseline:
                mEmojiText.setBaselineVisible(cbBaseline.isChecked());
                mOldEmojiText.setBaselineVisible(cbBaseline.isChecked());
                break;
            case R.id.cbDescent:
                mEmojiText.setDescentVisible(cbDescent.isChecked());
                mOldEmojiText.setDescentVisible(cbDescent.isChecked());
                break;
            case R.id.cbBottom:
                mEmojiText.setBottomVisible(cbBottom.isChecked());
                mOldEmojiText.setBottomVisible(cbBottom.isChecked());
                break;
            case R.id.cbTextBounds:
                mEmojiText.setBoundsVisible(cbBounds.isChecked());
                mOldEmojiText.setBoundsVisible(cbBounds.isChecked());
                break;
            case R.id.cbWidth:
                mEmojiText.setWidthVisible(cbMeasuredWidth.isChecked());
                mOldEmojiText.setWidthVisible(cbMeasuredWidth.isChecked());
                break;
            default:
                break;
        }
    }
}
