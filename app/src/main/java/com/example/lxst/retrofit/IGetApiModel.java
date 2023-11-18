package com.example.lxst.retrofit;

import android.database.Observable;

import java.util.List;

import retrofit2.http.GET;

public interface IGetApiModel {
    @GET("posts")
    Observable<List<ApiModel>> getPosts();
}
