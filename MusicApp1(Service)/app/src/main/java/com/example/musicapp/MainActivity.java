package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tiMusic;
    private Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiMusic = findViewById(R.id.ti_music);
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(v -> {
            String musicName = tiMusic.getText().toString();

            Intent intent = new Intent(MainActivity.this,MyService.class);

            intent.putExtra("musicName",musicName);
            startService(intent);


        });

        btnStop.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,MyService.class);
            stopService(intent);
        });
    }
}