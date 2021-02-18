package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapplication2.helper.NavigationViewHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mContext = MainActivity.this; //mContext로 MainActivity 함수 쓸라면 다운캐스팅하면 된다.
    private Toolbar toolbarMain; //androidx의 toolbar
    private ImageView ivPerson;
    private BottomNavigationView btNv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarMain = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        ivPerson = findViewById(R.id.iv_person);

        btNv = findViewById(R.id.bt_nv);

        NavigationViewHelper.enable(mContext,btNv);


        ivPerson.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, PersonActivity.class);
            startActivity(intent);

        });
    }
}