package net.studymongolian.fontmetrics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import net.studymongolian.fontmetrics.test.TestActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fontFamily(View view) {
        jump(TestActivity.class);
    }


    public void jumpPaint(View view) {
        jump(TextPaintActivity.class);
    }

    void jump(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    public void jumpEmoji(View view) {
        jump(EmojiSpanDemoActivity.class);
    }
}
