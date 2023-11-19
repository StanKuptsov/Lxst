package com.example.lxst.retrofit;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lxst.R;

public class ApiModelViewHolder extends RecyclerView.ViewHolder {
    TextView tvAuthor, tvTitle, tvContent;
    public ApiModelViewHolder(@NonNull View itemView) {
        super(itemView);

        tvAuthor = (TextView) itemView.findViewById(R.id.tvAuthor);
        tvContent = (TextView) itemView.findViewById(R.id.tvContent);
        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
    }
}
