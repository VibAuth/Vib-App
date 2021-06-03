package com.example.vibrationcustom;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

public class ResultScreenActivity extends WearableActivity {

    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        textView = (TextView) findViewById(R.id.text);
        textView2 = (TextView) findViewById(R.id.text2);


        //test
        textView2.setText("Attacker");

        // Enables Always-on
        setAmbientEnabled();
    }
}
