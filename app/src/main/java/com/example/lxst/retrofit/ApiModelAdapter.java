package com.example.lxst.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lxst.Adapter.LeaderboardAdapter;
import com.example.lxst.R;

import java.util.List;

public class ApiModelAdapter extends RecyclerView.Adapter<ApiModelViewHolder> {

    Context context;
    List <ApiModel> apiModelList;

    public ApiModelAdapter(Context context, List<ApiModel> apiModelList) {
        this.context = context;
        this.apiModelList = apiModelList;
    }

    @NonNull
    @Override
    public ApiModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.retrofit_item , parent , false);
        return new ApiModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApiModelViewHolder holder, int position) {
        holder.tvAuthor.setText(String.valueOf(apiModelList.get(position).userId));
        holder.tvTitle.setText(String.valueOf(apiModelList.get(position).title));
        holder.tvContent.setText(new StringBuilder(apiModelList.get(position).title.substring(0, 20))
                .append("...").toString());

    }

    @Override
    public int getItemCount() {
        return apiModelList.size();
    }
}
