package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mContext = MainActivity.this; //mContext로 MainActivity 함수 쓸라면 다운캐스팅하면 된다.
    private ListView lvMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml에 있는 그림이 메모리에 올라오는 과정 = 전체 인플레이트
        Log.d(TAG, "onCreate: ");
        lvMovie = findViewById(R.id.lv_movie);
        Log.d(TAG, "컨텍스트: " + MainActivity.this);
        Log.d(TAG, "컨텍스트: " + lvMovie.getContext());

        List<Movie> movies = new ArrayList<>();

        for (int i=0; i<20; i++){
            movies.add(new Movie(i,"제목"+i,"서브제목"+i));
        }

        ItemAdapter adapter = new ItemAdapter(movies);

        lvMovie.setAdapter(adapter);

    }
}