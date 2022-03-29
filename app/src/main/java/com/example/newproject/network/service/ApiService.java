package com.example.newproject.network.service;

import com.example.newproject.network.models.LoginBody;
import com.example.newproject.network.models.LoginResponse;
import com.example.newproject.network.models.MoviesResponse;
import com.example.newproject.network.models.RegisterBody;
import com.example.newproject.network.models.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("/auth/login")
    Call<LoginResponse> doLogin(@Body LoginBody loginBody);

    @POST("/auth/register")
    Call<Void> doRegister(@Body RegisterBody registerBody);

    @GET("/movies")
    Call<List<MoviesResponse>> getMovies(@Query("filter") String filter);

    @GET("/user")
    Call<List<UserResponse>> getUserInfo();
}

