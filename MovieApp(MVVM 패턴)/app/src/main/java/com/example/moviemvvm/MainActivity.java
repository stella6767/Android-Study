package com.example.moviemvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.moviemvvm.adapter.MovieAdapter;
import com.example.moviemvvm.model.Movie;
import com.example.moviemvvm.service.MovieApi;
import com.example.moviemvvm.viewmodel.MovieViewModel;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private MainActivity mContext = MainActivity.this;
    private RecyclerView rvMovie;
    private MovieAdapter movieAdapter;
    private MovieViewModel movieViewModel;
    //Call<List<Movie>> call = MovieApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initObject();
        initSetting();
        initData();
    }

    private void initObject(){
        rvMovie = findViewById(R.id.rv_movie);
        movieAdapter = new MovieAdapter();
        movieViewModel = new ViewModelProvider(mContext).get(MovieViewModel.class);
    }

    private void initSetting(){
        rvMovie.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        rvMovie.setAdapter(movieAdapter);
    }

    private void initData(){

        movieViewModel.데이터초기화();

        movieViewModel.구독().observe(mContext, movies -> {
            Log.d(TAG, "initData: 데이터 변경이 감지됨");
            movieAdapter.setMovies(movies);
            movieAdapter.notifyDataSetChanged();

        });
        movieViewModel.changeData();

        //movieViewModel.삭제(Long.valueOf(150));


    }



}