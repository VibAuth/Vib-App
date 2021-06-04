package com.example.vibrationcustom;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.wearable.activity.WearableActivity;
import android.view.WindowManager;
import android.widget.TextView;

public class TestActivity extends WearableActivity {

    private TextView tv;
    private TextView tv2;

    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        tv = (TextView) findViewById(R.id.text);
        tv2 = (TextView) findViewById(R.id.text2);

        mRunnable = new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(), ResultScreenActivity.class);
                startActivity(intent);
            }
        };

        mHandler = new Handler();

        //2600ms 이후에 결과 화면(ResultScreenActivity)로 넘어감
        mHandler.postDelayed(mRunnable, 2600);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        // Enables Always-on
        setAmbientEnabled();
        //finish();
    }

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacks(mRunnable);
        super.onDestroy();
    }
}
