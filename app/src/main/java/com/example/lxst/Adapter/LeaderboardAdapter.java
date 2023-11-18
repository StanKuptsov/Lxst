package com.example.lxst.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.lxst.Model.LeaderboardModel;
import com.example.lxst.Model.QuizListModel;
import com.example.lxst.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private List<LeaderboardModel> leaderboardModelList;
    private OnItemClickedListner onItemClickedListner;

    public void setLeaderboardModelList(List<LeaderboardModel> leaderboardModelList) {
        this.leaderboardModelList = leaderboardModelList;
    }

    public LeaderboardAdapter(OnItemClickedListner onItemClickedListner){
        this.onItemClickedListner = onItemClickedListner;
    }
    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_item , parent , false);
        return new LeaderboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardAdapter.LeaderboardViewHolder holder, int position) {
        LeaderboardModel model = leaderboardModelList.get(position);
        holder.email.setText(model.getUser());
        holder.score.setText(model.getCorrect());

    }

    @Override
    public int getItemCount() {

        if (leaderboardModelList == null){
            return 0;
        }else{
            return leaderboardModelList.size();
        }

    }

    public class LeaderboardViewHolder extends RecyclerView.ViewHolder{
        //Переработать viewholder под ресайклер для лидерборда
        private TextView email;
        private TextView score ;
        private ConstraintLayout constraintLayout;

        public LeaderboardViewHolder(@NonNull View itemView) {
            super(itemView);

            score = itemView.findViewById(R.id.tvScore);
            email = itemView.findViewById(R.id.tvEmail);

//            constraintLayout = itemView.findViewById(R.id.constraintLayout);
//            constraintLayout.setOnClickListener(this);
        }

    }

    public interface OnItemClickedListner {
        void onItemClick(int position);
    }

}




//package com.example.lxst.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.example.lxst.R;
//import com.example.lxst.Model.LeaderboardModel;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import java.util.ArrayList;
//
//public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {
//
//    Context context;
//    ArrayList<LeaderboardModel> usersArrayList;
//
//    public LeaderboardAdapter(Context context, ArrayList<LeaderboardModel> usersArrayList) {
//        this.context = context;
//        this.usersArrayList = usersArrayList;
//    }
//
//    @NonNull
//    @Override
//    public LeaderboardAdapter.LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(context).inflate(R.layout.leaderboard_item, parent, false);
//
//        return new LeaderboardViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull LeaderboardAdapter.LeaderboardViewHolder holder, int position) {
//
//        LeaderboardModel user = usersArrayList.get(position);
//
//        holder.Email.setText(user.Email);
//        holder.Score.setText(user.Score);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return usersArrayList.size();
//    }
//
//    public static class LeaderboardViewHolder extends RecyclerView.ViewHolder{
//
//        TextView Email, Score;
//
//        public LeaderboardViewHolder(@NonNull View itemView) {
//            super(itemView);
//            Email = itemView.findViewById(R.id.tvEmail);
//            Score = itemView.findViewById(R.id.tvScore);
//        }
//    }
//}
