package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

//메인쓰레드 = onCreat() => UI 쓰레드 (무한루프[A버튼, B버튼])
//                      => 이벤트 스레드 [ A버튼,A버튼,A버튼 - (3번 클릭)] 확인
//                      => 이벤트 리스너(OS(안드로이드))[A버튼]
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private TextView tvTitle;

    int num = 19;

    //매니페스트에서 설정된 자바 파일이 실행될 때 가장 먼저 실행되는 함수 onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); //그림 그리는 함수(무엇을? activity_main) => 그림 그리는 자바코드
        Log.d(TAG, "onCreate: ");

//        tvTitle = findViewById(R.id.tv_title);
//        tvTitle.setText("HI");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    //앱 멈출때!
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: "+num);
    }

    //앱 그려지기 직전!
    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = getSharedPreferences("movie",MODE_PRIVATE);
        String title = sp.getString("title","없음");
        //Log.d(TAG, "onResume: "+num);
        Log.d(TAG, "onResume: "+title);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }//onCreat 종료시에 그림 그려짐


    //앱 종료시~~!!!
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");


       //1. 파일(그림 사진 = 카메라로 찍은 사진)
       //2. 내부 DB = (SQL Lite) (주소록, 메모장, 달력 등..)
       //3. 외부서버 = 외부DB (인스타그램 업로드할 사진)
        // 4. 하드 엑세스 저장소(제일 많이 씀) = 앱마다 달려있음 = 실제로는 한개(키로 구분)= Sheared Preference

        SharedPreferences sp = getSharedPreferences("movie",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("title","바람과 함께 사라지다.");
        editor.commit();

    }
}