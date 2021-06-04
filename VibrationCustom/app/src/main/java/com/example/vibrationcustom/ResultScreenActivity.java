package com.example.vibrationcustom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.wearable.activity.WearableActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public class ResultScreenActivity extends WearableActivity {

    private TextView textView;
    private TextView textView2;
    private boolean threadCondition = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);
        Log.d("ClientStream", getLocalIpAddress());

        textView = (TextView) findViewById(R.id.text);
        textView2 = (TextView) findViewById(R.id.text2);

        ServerThread thread = new ServerThread();
        thread.start();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        // Enables Always-on
        setAmbientEnabled();

    }

    class ServerThread extends Thread {
        String thisuser;

        @SuppressLint("HandlerLeak")
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if(thisuser.contentEquals("0"))
                    textView2.setText("Attacker");
                else
                    textView2.setText("User " + thisuser);
            }
        };

        @Override
        public void run() {
            while (threadCondition) {
                int port = 4000;

                try {
                    ServerSocket server = new ServerSocket(port);
                    Log.d("ServerThread", "Server Started.");

                    Socket socket = server.accept();
                    Log.d("ServerThread", "socket accepted.");

                    DataInputStream instream = new DataInputStream(socket.getInputStream());
                    int input = instream.read();
                    thisuser = String.valueOf(input);
                    Log.d("ServerThread", thisuser);

                    Message msg = handler.obtainMessage();
                    handler.sendMessage(msg);

                    socket.close();
                    threadCondition = false;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                ServerThread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Intent intent = new Intent(getApplicationContext(), MainActivity.class); //지금 액티비티에서 다른 액티비티로 이동하는 인텐트 설정
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);    //인텐트 플래그 설정

            Log.d("TAG", "onBackPressed: clear stack");
            startActivity(intent);  //인텐트 이동
            finish();   //현재 액티비티 종료
        }
    }

    public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
