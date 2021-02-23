package com.example.retrofitex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private RecyclerView postList;
    private PostAdapter postAdapter;
    private Context mContext = MainActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PostApi postApi = PostApi.retrofit.create(PostApi.class);
        //https://jsonplaceholder.typicode.com/posts
        Call<List<Post>> call = postApi.getPosts();

        call.enqueue(new Callback<List<Post>>() { //새로운 스레드 동작
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                List<Post> posts = response.body();
                //어댑터에 던지기 + notifydatachanged
                Log.d(TAG, "onResponse: "+posts);

                LinearLayoutManager manager = new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
                postList = findViewById(R.id.rv_post);
                postList.setLayoutManager(manager);
                postAdapter = new PostAdapter(posts);

                postList.setAdapter(postAdapter);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.d(TAG, "onFailure: 실패");
            }
        });


    }
}