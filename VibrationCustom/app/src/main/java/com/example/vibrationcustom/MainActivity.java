package com.example.vibrationcustom;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    Button button;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                // 2000ms sleep 후 시작 (no pilot)
                // chirp 시그널 3회 재생, 사이사이 1.6초씩 sleep
                // 한 세기당 80ms씩 재생. 세기 간격: 10 (85, 95, ...,255)
                long[] vibPtrnTime = {2000,
                        1600, 80,  0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,   0, 80,   0, 80,
                        0, 80,  0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,   0, 80,   0, 80,
                        1600, 80,  0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,   0, 80,   0, 80,
                        0, 80,  0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,   0, 80,   0, 80,
                        1600, 80,  0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,   0, 80,   0, 80,
                        0, 80,  0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,   0, 80,   0, 80 };

                int[] vibPtrnAmpl =  {   0,
                        0,  85,   0, 95,   0, 105,  0, 115,   0, 125,   0, 135,  0, 145,  0, 155, 0, 165,
                        0, 175,   0, 185,  0, 195,   0, 205,   0, 215,  0, 225,  0, 235,  0, 245,   0, 255,
                        0,  85,   0, 95,   0, 105,  0, 115,   0, 125,   0, 135,  0, 145,  0, 155, 0, 165,
                        0, 175,   0, 185,  0, 195,   0, 205,   0, 215,  0, 225,  0, 235,  0, 245,   0, 255,
                        0,  85,   0, 95,   0, 105,  0, 115,   0, 125,   0, 135,  0, 145,  0, 155, 0, 165,
                        0, 175,   0, 185,  0, 195,   0, 205,   0, 215,  0, 225,  0, 235,  0, 245,   0, 255 };

                if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){

                    //create vibEffect instance
                    VibrationEffect vibEffect = VibrationEffect.createWaveform(vibPtrnTime, vibPtrnAmpl, -1);

                    vibrator.cancel();
                    vibrator.vibrate(vibEffect);  //initiate the vibration
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                // 2000ms sleep 후 시작 (no pilot)
                // chirp 시그널 3회 재생, 사이사이 1.6초씩 sleep
                // 한 세기당 40ms씩 재생. 세기 간격: 5 (80, 85, 90, 95, ...,255)
                long[] vibPtrnTime = {2000,
                        1600, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,  0, 40,  0, 40,
                        1600, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,  0, 40,  0, 40,
                        1600, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,  0, 40,  0, 40};

                int[] vibPtrnAmpl =  {   0,
                        0, 80,  0,  85,   0, 90,   0, 95,   0, 100,  0, 105,  0, 110,   0, 115,   0, 120,   0, 125,   0, 130,   0, 135,  0, 140,  0, 145,  0, 150,  0, 155,
                        0, 160,  0, 165,  0, 170,   0, 175,   0, 180,  0, 185,  0, 190 ,   0, 195,   0, 200,   0, 205,   0, 210,   0, 215,  0, 220,  0, 225,  0, 230,  0, 235,
                        0, 240,  0, 245,   0, 250,   0, 255,
                        0, 80,  0,  85,   0, 90,   0, 95,   0, 100,  0, 105,  0, 110,   0, 115,   0, 120,   0, 125,   0, 130,   0, 135,  0, 140,  0, 145,  0, 150,  0, 155,
                        0, 160,  0, 165,  0, 170,   0, 175,   0, 180,  0, 185,  0, 190 ,   0, 195,   0, 200,   0, 205,   0, 210,   0, 215,  0, 220,  0, 225,  0, 230,  0, 235,
                        0, 240,  0, 245,   0, 250,   0, 255,
                        0, 80,  0,  85,   0, 90,   0, 95,   0, 100,  0, 105,  0, 110,   0, 115,   0, 120,   0, 125,   0, 130,   0, 135,  0, 140,  0, 145,  0, 150,  0, 155,
                        0, 160,  0, 165,  0, 170,   0, 175,   0, 180,  0, 185,  0, 190 ,   0, 195,   0, 200,   0, 205,   0, 210,   0, 215,  0, 220,  0, 225,  0, 230,  0, 235,
                        0, 240,  0, 245,   0, 250,   0, 255};


                if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){

                    //create vibEffect instance
                    VibrationEffect vibEffect = VibrationEffect.createWaveform(vibPtrnTime, vibPtrnAmpl, -1);

                    vibrator.cancel();
                    vibrator.vibrate(vibEffect);  //initiate the vibration
                }

            }
        });


        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                // 2000ms sleep, 600ms for pilot
                // chirp 아닌 두 가지 세기로만 이루어진 test용 시그널
                long[] vibPtrnTime = {2000, 600,
                        2500, 1000,  100, 1000,
                        2500, 1000,  100, 1000,
                        2500, 1000,  100, 1000};
                int[] vibPtrnAmpl =  {   0, 255,
                        0, 255,  0,  160,
                        0, 255,  0,  160,
                        0, 255,  0,  160,};


                if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){



                    //create vibEffect instance
                    VibrationEffect vibEffect = VibrationEffect.createWaveform(vibPtrnTime, vibPtrnAmpl, -1);

                    vibrator.cancel();
                    vibrator.vibrate(vibEffect);  //initiate the vibration
                }

            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // test signal
                // 2000ms sleep, 600ms for pilot
                long[] vibPtrnTime = {2000, 600,
                        1000, 200, 100, 340, 150, 250, 100, 300,
                        1000, 200, 100, 340, 150, 250, 100, 300,
                        1000, 200, 100, 340, 150, 250, 100, 300};
                int[] vibPtrnAmpl =  {   0, 255,
                        0,  215,  0, 255,  0,  180, 0,   120,
                        0,  215,  0, 255,  0,  180, 0,   120,
                        0,  215,  0, 255,  0,  180, 0,   120};  // range 0 - 255

                if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){

                    //create vibEffect instance
                    VibrationEffect vibEffect =   VibrationEffect.createWaveform(vibPtrnTime, vibPtrnAmpl, -1);

                    vibrator.cancel();
                    vibrator.vibrate(vibEffect);  //initiate the vibration
                }

            }
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // Enables Always-on
        setAmbientEnabled();
    }
}
