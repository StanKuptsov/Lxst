package com.example.lxst.views;

import android.content.Context;
import android.os.Bundle;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lxst.Adapter.LeaderboardAdapter;
import com.example.lxst.Model.LeaderboardModel;
import com.example.lxst.R;
import com.example.lxst.retrofit.ApiModel;
import com.example.lxst.retrofit.ApiModelAdapter;
import com.example.lxst.retrofit.IGetApiModel;
import com.example.lxst.retrofit.RetrofitClient;

import java.util.List;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RetrofitFragment extends Fragment {

    IGetApiModel API;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public RetrofitFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Init API
        Retrofit retrofit = RetrofitClient.getDataInstance();
        API = retrofit.create(IGetApiModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_retrofit, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.RetrofitRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchData();
    };

    private void fetchData()
    {
        compositeDisposable.add(API.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ApiModel>>()
                {
                    @Override
                    public void accept(List<ApiModel> apiModelList) throws Exception
                    {
                        displayData(apiModelList);
                    }
                }));
    }

    private void displayData(List<ApiModel> apiModelList) {
        ApiModelAdapter adapter = new ApiModelAdapter(apiModelList);
        recyclerView.setAdapter(adapter);
    }

    public void onStop(){
        compositeDisposable.clear();
        super.onStop();
    }
}