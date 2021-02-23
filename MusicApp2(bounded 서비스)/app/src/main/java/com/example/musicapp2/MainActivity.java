package com.example.musicapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;

import com.example.musicapp2.R;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private TextInputEditText tiMusic;
    private Button btnStart, btnStop, btnPause;
    private MediaPlayer mp;

    ServiceConnection connection = new ServiceConnection() { // 콜백으로 서비스 변수와 함수를 받아올 수 있음
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected: 서비스 연결됨");
            mp = ((MyService.LocalBinder) service).getMp();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //서비스 실행 = 서비스의 onCreate와 onBind실헹 -> connection. onServiceConnected 가 콜백된
        Intent musicIntent = new Intent(MainActivity.this,MyService.class);
        bindService(musicIntent,connection,BIND_AUTO_CREATE);

        tiMusic = findViewById(R.id.ti_music);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        btnPause = findViewById(R.id.btn_pause);

        btnStart.setOnClickListener(v -> {
            //음악재생
            mp.start();
        });

        btnStop.setOnClickListener(v -> {
            mp.pause();
            mp.seekTo(0);
        });

        //nextMusic 버튼




       btnPause.setOnClickListener(v -> {
            mp.pause();
       });





    }
}