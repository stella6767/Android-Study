package com.cos.retrofit2movieapp.service;

import com.cos.retrofit2movieapp.model.Movie;
import com.cos.retrofit2movieapp.model.ResponseDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieService { //interface니까 어차피 static이니 안 붙여도 된다.

//    @GET("api/movie")
//    Call<List<Movie>> findAll();

//    @DELETE("api/movie/{id}")  //Retrofit 공식사이트 가서 문법공부 https://square.github.io/retrofit/
//    Call<String> deleteById(@Path("id") Long id);

    @GET("api/movie")
    Call<ResponseDto<List<Movie>>> findAll();


    @DELETE("api/movie/{id}")
    Call<ResponseDto> deleteById(@Path("id") Long id);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.10.225:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
