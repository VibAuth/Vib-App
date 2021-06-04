package com.example.vibrationcustom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingDeque;

public class TrainActivity extends WearableActivity {

    private TextView tv_count;
    private TextView tv_subcount;
    private Button button;

    private TimerTask timerTask;
    private TimerTask timerTask2;
    private Timer timer;

    private int vibCounter = -1;
    private int subCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        tv_count = (TextView) findViewById(R.id.tv_count);
        tv_subcount = (TextView) findViewById(R.id.tv_sub_count);
        button = (Button) findViewById(R.id.train_button);

        final Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")

            @Override
            public void onClick(View v) {

                if(subCounter > 3) subCounter = 0;
                subCounter++;

                tv_count.setText(" " + subCounter + " / 4 SET");


                // 2000ms sleep 후 시작 (no pilot)
                // chirp 시그널 3회 재생, 사이사이 1.6초씩 sleep
                // 한 세기당 40ms씩 재생. 세기 간격: 5 (80, 85, 90, 95, ...,255) 총 36steps   36 * 40 = 1440     1440 + 1660 = 3040

                //원래는 200, 1600, 40, 0, 40, ..., 1600, ... 1600...임!
                //지금 일단 0, 1400, 40, 0, 40, ... , 100, ... 으로 바꿔둠.
                long[] vibPtrnTime = {0,
                        1400, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
                        0, 40,  0, 40,  0, 40,  0, 40,
                        1400, 40,  0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,   0, 40,   0, 40,   0, 40,   0, 40,   0, 40,  0, 40,  0, 40,  0, 40,  0, 40,
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

                    @SuppressLint("HandlerLeak")
                    final Handler handler = new Handler(){
                        @Override
                        public void handleMessage(@NonNull Message msg) {
                            super.handleMessage(msg);

                            String string = "";
                            if(vibCounter < 1) {
                                string = "";
                                tv_subcount.setText(string);
                            }
                            else if(vibCounter >=3){
                                string = Character.toString("\u2192".toCharArray()[0]) + " 3";
                                tv_subcount.setText(string);
                            }
                            else {
                                string = Character.toString("\u2192".toCharArray()[0]) + " " + vibCounter;
                                tv_subcount.setText(string);
                            }

                        }
                    };

                    @SuppressLint("HandlerLeak")
                    final Handler handler2 = new Handler(){
                        @Override
                        public void handleMessage(@NonNull Message msg) {

                            //4 set 녹음 시 종료
                            if(subCounter == 4 ){

                                tv_subcount.setTextSize(20);
                                tv_subcount.setText("Training 완료");
                                tv_subcount.setTypeface(tv_subcount.getTypeface(), Typeface.ITALIC);

                                //Train 버튼 비활성화
                                button.setEnabled(false);
                                button.setClickable(false);

                                //Train 버튼 회색으로
                                button.setBackground(getResources().getDrawable(R.drawable.roundedbutton_false));
                            }
                            else {
                                tv_subcount.setText("");
                            }
                        }
                    };

                    timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            vibCounter++;

                            Log.d("TAG", "run: Vibration counter ---> " + String.valueOf(vibCounter));
                            Message msg = handler.obtainMessage();
                            handler.sendMessage(msg);

                            if(vibCounter >= 3){
                                Log.d("TAG", "CANCEL 전");

                                timerTask2 = new TimerTask() {
                                    @Override
                                    public void run() {
                                        Message msg2 = handler2.obtainMessage();
                                        handler2.sendMessage(msg2);

                                        Log.d("TAG", "CANCEL 후");
                                        vibCounter = -1;

                                        timerTask.cancel();
                                        timerTask2.cancel();
                                    }
                                };

                                timer.schedule(timerTask2, 1500);  // -> 3 이라는 표시는 1500ms 이후에 사라지게
                            }
                        }
                    };

                    timer = new Timer();
                    timer.schedule(timerTask, 0, 2840);  // -> 한 진동당 2840ms

                }
            }
        });


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        // Enables Always-on
        setAmbientEnabled();
    }
}
