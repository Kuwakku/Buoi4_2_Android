package com.example.buoi4_2_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private ArrayList<User> mListUsers;
    private Context mContext;
    public UserAdapter(ArrayList<User> mListUsers) {
        this.mListUsers = mListUsers;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        User user = mListUsers.get(position);
        holder.tvUserName.setText(user.getUserName());
        holder.tvInfo.setText("Age: " + user.getAge() + " Email: " + user.getEmail() + " Address: " + user.getAddress());
        Glide.with(mContext).load(user.getAvatar()).into(holder.imgAvatar);
    }

    @Override
    public int getItemCount() {
        return mListUsers != null ? mListUsers.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView tvUserName;
        TextView tvInfo;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvInfo = itemView.findViewById(R.id.tvInfo);
        }
    }
}
