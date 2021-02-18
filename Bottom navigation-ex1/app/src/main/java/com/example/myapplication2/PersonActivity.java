package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;

public class PersonActivity extends AppCompatActivity {

    private Toolbar toolbarPerson;
    private ImageView personBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        toolbarPerson = findViewById(R.id.toolbar_person);
        personBack = findViewById(R.id.person_back);

        setSupportActionBar(toolbarPerson);

        personBack.setOnClickListener(v -> {
            finish();

        });
    }
}