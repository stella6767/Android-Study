package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

//stack 생성
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this; //mContext로 MainActivity 함수 쓸라면 다운캐스팅하면 된다.
    private GridView gvMovie;
    List<Movie> movies; //download 리턴이 없기 때문에 여기서 선언
    MovieAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml에 있는 그림이 메모리에 올라오는 과정 = 전체 인플레이트
        Log.d(TAG, "onCreate: ");
        gvMovie = findViewById(R.id.gv_movie);
        Log.d(TAG, "컨텍스트: " + MainActivity.this);
        Log.d(TAG, "컨텍스트: " + gvMovie.getContext());


        init();

        gvMovie.setAdapter(adapter);

    }

    private void init(){
        gvMovie = findViewById(R.id.gv_movie);
        movies = new ArrayList<>();
        adapter = new MovieAdapter(movies);
        download();
    }


    private void download(){
        //스레드로 돌아야함, 그래서 void
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000); //I/O 작업이 운이 좋아서 짧으면 그림이 그려지지만 아니면 안 뜸 동기화 작업이 필요
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                movies.add(new Movie(1,"제목",R.drawable.mov01));
                movies.add(new Movie(2,"제목",R.drawable.mov02));
                movies.add(new Movie(3,"제목",R.drawable.mov03));
                movies.add(new Movie(4,"제목",R.drawable.mov04));
                movies.add(new Movie(5,"제목",R.drawable.mov05));
                movies.add(new Movie(6,"제목",R.drawable.mov06));
                movies.add(new Movie(7,"제목",R.drawable.mov07));
                movies.add(new Movie(8,"제목",R.drawable.mov08));
                movies.add(new Movie(9,"제목",R.drawable.mov09));
                movies.add(new Movie(10,"제목",R.drawable.mov10));

                //adapter.notifyDataSetChanged(); //이것만으로는 안 됨
                //main 스레드 = UI 스레드가 adapter.notifyDataSetChanged();를 실행시키게 하면 됨.

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });


            }
        }).start();


    }
}