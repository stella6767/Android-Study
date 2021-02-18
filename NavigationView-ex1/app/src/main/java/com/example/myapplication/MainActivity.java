package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.myapplication.helper.NavigationViewHelper;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this; //mContext로 MainActivity 함수 쓸라면 다운캐스팅하면 된다.

    private DrawerLayout drawer;
    private Button btn1;
    private NavigationView nv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml에 있는 그림이 메모리에 올라오는 과정 = 전체 인플레이트

        drawer = findViewById(R.id.drawer);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(v -> {
            drawer.openDrawer(GravityCompat.START); //그냥 GRavity.right와의 차이점은?
        });


        nv = findViewById(R.id.nv);

        NavigationViewHelper.enable(mContext,nv);
    }
}