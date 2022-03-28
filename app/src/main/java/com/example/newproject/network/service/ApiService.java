package com.example.newproject.network.service;

import com.example.newproject.network.models.LoginBody;
import com.example.newproject.network.models.LoginResponse;
import com.example.newproject.network.models.MoviesBody;
import com.example.newproject.network.models.MoviesResponse;
import com.example.newproject.network.models.RegisterBody;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/auth/login")
    Call<LoginResponse> doLogin(@Body LoginBody loginBody);
    @POST("/auth/register")
    Call<Void> doRegister(@Body RegisterBody registerBody);
    @GET("/movies")
    Call<List<MoviesResponse>> getMovies(@Body MoviesBody moviesBody);
}
