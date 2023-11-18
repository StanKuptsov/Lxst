package com.example.lxst.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.adapter.rxjava3.RxJava2CallAdapterFactory;

public class RetrofitClient {
    private static Retrofit dataInstance;

    public static Retrofit getDataInstance(){
        if(dataInstance == null)
            dataInstance = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return dataInstance;
    }
}
