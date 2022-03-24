package com.example.newproject.network;

import com.example.newproject.network.service.ApiService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHandler {
//    private static ApiHandler mInstance;
//    private static final String BASE_URL = "https://cinema.areas.su";
//    private Retrofit retrofit;
//
//    public ApiHandler(){
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Lever.BODY);
//        OkHttpClient.Builder client = new OkHttpClient.Builder()
//                .addInterceptor(interceptor);
//        retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .client(client.build())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        ErrorUtils.retrofit = retrofit;
//    }
//    //будет получать экземпляр нашего ApiHandler
//    public static ApiHandler getInstance(){
//        if(mInstance == null)
//            mInstance = new ApiHandler();
//        return mInstance;
//    }
//    //класс у которого вызываем запросы к API
//    public ApiService getService(){
//        return retrofit.create(ApiService.class);
//    }
}
