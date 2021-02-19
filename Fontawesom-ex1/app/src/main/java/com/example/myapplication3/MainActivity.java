package com.example.myapplication3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.fontawesome.FontDrawable;
import info.androidhive.fontawesome.FontTextView;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity2";
    private FontTextView fav;
    private ImageView ivHeart;
    private boolean isLike =false; //solid에 여기를 집어넣는다.


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fav = findViewById(R.id.fav);
        ivHeart = findViewById(R.id.imageView);


        FontDrawable drawable = new FontDrawable(this, R.string.fa_heart, isLike, false);
        ivHeart.setImageDrawable(drawable);

        ivHeart.setOnClickListener(v -> {
            isLike = !isLike;
            FontDrawable faheart = new FontDrawable(this, R.string.fa_heart, isLike, false);
            ivHeart.setImageDrawable(faheart);

        });

        fav.setOnClickListener(v -> {
            //fav.setTextColor(ContextCompat.getColor(this, android.R.color.black));
            fav.setTextColor(R.color.black );
        });

    }

}