package com.example.buoi4_2_android;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> mListUsers;
    private UserAdapter mUserAdapter;
    private RecyclerView rvDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {
        rvDemo = findViewById(R.id.rvDemo);
        mUserAdapter = new UserAdapter(mListUsers);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvDemo.setLayoutManager(linearLayoutManager);
        rvDemo.setAdapter(mUserAdapter);

    }

    private void initData() {
        mListUsers = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setUserName("User name " + i);
            user.setAge(i + 10);
            user.setEmail("email " + i + "@gmail.com");
            user.setAvatar("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTac6CpjlIClig9Jt1TBvSobdJ5mySsRjdMTg&usqp=CAU");
            user.setAddress("HN");

            mListUsers.add(user);
        }
    }
}