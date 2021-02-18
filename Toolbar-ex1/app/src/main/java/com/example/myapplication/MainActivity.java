package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mContext = MainActivity.this; //mContext로 MainActivity 함수 쓸라면 다운캐스팅하면 된다.
    private Toolbar toolbarMain; //androidx의 toolbar
    private ImageView ivPerson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml에 있는 그림이 메모리에 올라오는 과정 = 전체 인플레이트

        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        ivPerson = findViewById(R.id.iv_person);

        ivPerson.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, PersonActivity.class);
            startActivity(intent);

        });



    }
}