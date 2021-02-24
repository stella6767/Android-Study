package com.example.moviemvvm.service;

import com.example.moviemvvm.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieApi {

    @GET("api/movie")
    Call<List<Movie>> callMovies();

    @DELETE("api/movie/{id}")
    Call<List<Movie>> deleteMovie(@Path("id") Long id);

//    @GET("posts")
//    Call<List<Movie>> callMovies();

     Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.10.225:8000/")  //locahost 안 먹음! cmd에서 ipconfig 들어가 ip4 주소 직접 익렵
             //.baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
