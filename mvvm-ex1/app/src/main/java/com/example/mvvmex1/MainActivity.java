package com.example.mvvmex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.mvvmex1.model.Post;
import com.example.mvvmex1.viewmodel.PostViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private PostViewModel postViewModel;
    private Button btnChange, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        btnChange = findViewById(R.id.btn_change);
        btn2 = findViewById(R.id.btn2);
        postViewModel.데이터초기화();

        //1.레드로핏에 findALl 요청
        //postViewModel.전체가져오기(모델);


        //1,2,3 => 1,2,3,4
        //1,2,3 => 1,2
        //1,2,3 => 1,4,2,3
        //1,2,3 => 1,2,4
        postViewModel.구독().observe(this, posts -> {
            Log.d(TAG, "onCreate: 데이터 변경됨");
            //어댑터 던지기
        });

        btnChange.setOnClickListener(v -> {
            postViewModel.포스트한건추가(new Post(1,"제목1"));
        });

        btn2.setOnClickListener(v -> {
            postViewModel.포스트변경();
        });
    }
}