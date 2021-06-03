package com.example.vibrationcustom;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends WearableActivity {

    Button button; // Train 버튼
    Button button2; // Test 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        // Train 화면으로 이동
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), TrainActivity.class);
                startActivity(intent);

            }
        });


        //Test 화면으로 이동, Test용 진동패턴 재생
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                // 2000ms sleep 후 시작 (no pilot)
                // chirp 시그널 1회 재생, 사이사이 1.6초씩 sleep
                // 한 세기당 40ms씩 재생. 세기 간격: 5 (80, 85, 90, 95, ...,255)

                //이것도 원래는 앞에 600, 그다음에 1600 쉬는데
                //지금은 0, 100으로 바꿔둠
                long[] vibPtrnTime = {0,
                        1000, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,  0, 40,  0, 40 };

                int[] vibPtrnAmpl = {   0,
                        0, 80,  0,  85,   0, 90,   0, 95,   0, 100,  0, 105,  0, 110,   0, 115,   0, 120,   0, 125,   0, 130,   0, 135,  0, 140,  0, 145,  0, 150,  0, 155,
                        0, 160,  0, 165,  0, 170,   0, 175,   0, 180,  0, 185,  0, 190 ,   0, 195,   0, 200,   0, 205,   0, 210,   0, 215,  0, 220,  0, 225,  0, 230,  0, 235,
                        0, 240,  0, 245,   0, 250,   0, 255 };


                if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){

                    //create vibEffect instance
                    VibrationEffect vibEffect = VibrationEffect.createWaveform(vibPtrnTime, vibPtrnAmpl, -1);

                    vibrator.cancel();
                    vibrator.vibrate(vibEffect);  //initiate the vibration

                    Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                    startActivity(intent);

                }

            }
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // Enables Always-on
        setAmbientEnabled();
    }
}
