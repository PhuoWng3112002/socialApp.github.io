package com.example.chatmeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.chatmeapp.Utills.Users;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class FindFriendActivity extends AppCompatActivity {
    FirebaseRecyclerOptions<Users>options;
    FirebaseRecyclerAdapter<Users,FindFriendHolder>adapter;

    Toolbar toolbar;

    DatabaseReference mUserRef;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_friend);

        toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Find Friends");
        
        recyclerView=findViewById(R.id.recycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mUserRef= FirebaseDatabase.getInstance().getReference().child("Users");
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


        LoadUsers("");

    }


    private void LoadUsers(String s) {
        Query query=mUserRef.orderByChild("username").startAt(s).endAt(s+"\uf8ff");
        options=new FirebaseRecyclerOptions.Builder<Users>().setQuery(query,Users.class).build();
        adapter=new FirebaseRecyclerAdapter<Users, FindFriendHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FindFriendHolder holder, int position, @NonNull Users model) {

                Picasso.get().load(model.getProfileImage()).into(holder.profileImage);
                holder.username.setText(model.getUsername());
                holder.profession.setText(model.getProfession());

            }

            @NonNull
            @Override
            public FindFriendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view_find_friend,parent,false);

                return new FindFriendHolder(view);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }
}