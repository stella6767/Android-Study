package com.example.kakaochatdesigin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.Shader;
import android.os.Bundle;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView kakaoChatList;
    private List<User> users;
    private ChatAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        kakaoChatList.setLayoutManager(manager);
        kakaoChatList.setAdapter(adapter);


    }


    private void init(){
        kakaoChatList = findViewById(R.id.kakao_chat_list);
        users = new ArrayList<>();
        adapter = new ChatAdapter(users);

        download();
    }


    private void download(){
        //스레드로 돌아야함, 그래서 void
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000); //I/O 작업이 운이 좋아서 짧으면 그림이 그려지지만 아니면 안 뜸 동기화 작업이 필요
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                users.add(new User(1,"제목","",R.drawable.post1,"1월 3일"));
                users.add(new User(2,"제목","",R.drawable.post1,"1월 3일"));
                users.add(new User(3,"제목","",R.drawable.post1,"1월 3일"));
                users.add(new User(4,"제목","",R.drawable.post1,"1월 3일"));
                users.add(new User(5,"제목","",R.drawable.post1,"1월 3일"));
                users.add(new User(6,"제목","",R.drawable.post1,"1월 3일"));
                users.add(new User(7,"제목","",R.drawable.post1,"1월 3일"));
                users.add(new User(8,"제목","",R.drawable.post1,"1월 3일"));
                users.add(new User(9,"제목","",R.drawable.post1,"1월 3일"));
                users.add(new User(10,"제목","",R.drawable.post1,"1월 3일"));



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