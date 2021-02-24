package com.example.moviemvvm.viewmodel;


import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviemvvm.model.Movie;
import com.example.moviemvvm.service.MovieApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {

    private static final String TAG = "MovieViewModel";
    private  List<Movie> movies;

    //LiveData, MutableLiveData
    private MutableLiveData<List<Movie>> mtMovies = new MutableLiveData<>();

    //데이터 변경감지
    public MutableLiveData<List<Movie>> 구독() {
        return mtMovies;
    }


    public void 삭제(Long id) { //서버에 요청해서 진짜로 삭제하는 거.. 데이터 자체를..
        Call<List<Movie>> call =
                MovieApi.retrofit.create(MovieApi.class).deleteMovie(id);
        call.enqueue(new Callback<List<Movie>>() {

            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                Log.d(TAG, "onResponse: delete 통신성공");
                //String respmsg = response.body().toString(); //무조건 자바 오브젝트만 제이슨으로 변환해서 응답하는가?
                Log.d(TAG, "onResponse: 삭제완료?" + response.body());
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage()); // android:usesCleartextTraffic="true" !!!! 꼭 해줘야 된다.
                Log.d(TAG, "onFailure: delete 통신실패");
            }
        });

    }



    public void 데이터초기화(){
        List<Movie> movies = new ArrayList<>();
        mtMovies.setValue(movies);
    }

    public void changeData() {
        Call<List<Movie>> call =
                MovieApi.retrofit.create(MovieApi.class).callMovies();
        call.enqueue(new Callback<List<Movie>>() {

            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                Log.d(TAG, "onResponse: 통신성공 데이터 삽입");
                movies = response.body();
                mtMovies.setValue(movies);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage()); // android:usesCleartextTraffic="true" !!!! 꼭 해줘야 된다.
                Log.d(TAG, "onFailure: 통신실패");
            }
        });

    }



}