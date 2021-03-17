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

                // 2000ms sleep, 600ms for pilot
                long[] vibPtrnTime = {2000, 600,
                        1000, 80,  0, 80,  0, 80,  0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,   0, 80,   0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,  0, 80,  0, 80,
                        1000, 80,  0, 80,  0, 80,  0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,   0, 80,   0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,  0, 80,  0, 80,
                        1000, 80,  0, 80,  0, 80,  0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,   0, 80,   0, 80,   0, 80,   0, 80,   0, 80,  0, 80,  0, 80,  0, 80,  0, 80};
                int[] vibPtrnAmpl =  {   0, 255,
                        0, 85,  0,   95,   0, 105,  0, 115,   0, 125,   0, 135,   0, 145,  0, 155,  0, 165,   0, 175,   0, 185,   0, 195,   0, 205,   0, 215,  0, 225,  0, 235,  0, 245,  0, 255,
                        0, 85,  0,   95,   0, 105,  0, 115,   0, 125,   0, 135,   0, 145,  0, 155,  0, 165,   0, 175,   0, 185,   0, 195,   0, 205,   0, 215,  0, 225,  0, 235,  0, 245,  0, 255,
                        0, 85,  0,   95,   0, 105,  0, 115,   0, 125,   0, 135,   0, 145,  0, 155,  0, 165,   0, 175,   0, 185,   0, 195,   0, 205,   0, 215,  0, 225,  0, 235,  0, 245,  0, 255};

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

                // 2000ms sleep, 600ms for pilot
                long[] vibPtrnTime = {2000, 600,
                        1000, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                           0, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                           0, 40,  0, 40,  0, 40,  0, 40,
                        1000, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,  0, 40,  0, 40,
                        1000, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,  0, 40,  0, 40};
                int[] vibPtrnAmpl =  {   0, 255,
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
                long[] vibPtrnTime = {2000, 600,
                        1000, 15,  0, 15,   0, 15,   0, 15,   0, 15,  0, 15,  0, 15,   0, 15,   0, 15,   0, 15,   0, 15,   0, 15,  0, 15,  0, 15,  0, 15,  0, 15,
                        0, 15,  0, 15,   0, 15,   0, 15,   0, 15,  0, 15,  0, 15,   0, 15,   0, 15,   0, 15,   0, 15,   0, 15,  0, 15,  0, 15,  0, 15,  0, 15,
                        0, 15,  0, 15,   0, 15,   0, 15,   0, 15,  0, 15,  0, 15,   0, 15,   0, 15,   0, 15,   0, 15,   0, 15,  0, 15,  0, 15,  0, 15,  0, 15,
                        0, 15,  0, 15,   0, 15,   0, 15,   0, 15,  0, 15,  0, 15,   0, 15,   0, 15,   0, 15,   0, 15,   0, 15,  0, 15,  0, 15,  0, 15,  0, 15,
                        0, 15,  0, 15,   0, 15,   0, 15,   0, 15,  0, 15,  0, 15,   0, 15,   0, 15,   0, 15,   0, 15,   0, 15,  0, 15,  0, 15,  0, 15,  0, 15,
                        0, 15,  0, 15,   0, 15,   0, 15,   0, 15,  0, 15,  0, 15,   0, 15};
                int[] vibPtrnAmpl =  {   0, 255,
                        0, 81,  0,  83,   0, 85,   0, 87,   0, 89,  0, 91,  0, 93,   0, 95,   0, 97,   0, 99,   0, 101,   0, 103,  0, 105,  0, 107,  0, 109,  0, 111,
                        0, 113,  0, 115,  0, 117,   0, 119,  0, 121, 0, 123,  0, 125,  0, 127,  0, 129,   0, 131,   0, 133,   0, 135,  0, 137,  0, 139,  0, 141,  0, 143,
                        0, 145,  0, 147,   0, 149,   0, 151, 0, 153, 0, 155,  0, 157,  0, 159,  0, 161,   0, 163,   0, 165,   0, 167,  0, 169,  0, 171,  0, 173,  0, 175,
                        0, 177,  0, 179,   0, 181,   0, 183,   0, 185,  0, 187,  0, 189,   0, 191,   0, 193,   0, 195,   0, 197,   0, 199,  0, 201,  0, 203,  0, 205,  0, 207,
                        0, 209,  0, 211,  0, 213,   0, 215,   0, 217,  0, 219,  0, 221 ,   0, 223,   0, 225,   0, 227,   0, 229,   0, 231,  0, 233,  0, 235,  0, 237,  0, 239,
                        0, 241,  0, 243,   0, 245,   0, 247,  0, 249, 0, 251, 0, 253, 0, 255,};


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

                // 2000ms sleep, 600ms for pilot
                long[] vibPtrnTime = {2000, 600};
                int[] vibPtrnAmpl =  {   0, 255};

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
