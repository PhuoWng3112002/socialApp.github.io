package com.example.chatmeapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;

public class FindFriendHolder extends RecyclerView.ViewHolder {

    CircleImageView profileImage;
    TextView username,profession;

    public FindFriendHolder(@NonNull View itemView) {
        super(itemView);
        profileImage=itemView.findViewById(R.id.postImage);
        username=itemView.findViewById(R.id.username);
        profession=itemView.findViewById(R.id.profession);
    }
}
