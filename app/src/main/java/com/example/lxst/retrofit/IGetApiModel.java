package com.example.lxst.retrofit;

//import android.database.Observable;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface IGetApiModel {
    @GET("posts")
    Observable<List<ApiModel>> getPosts();
}
