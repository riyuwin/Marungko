package com.example.marungkoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class UserSelect extends AppCompatActivity {

    ImageButton MagaaralBtn, GuroBtn, MagulangBtn, AdminBtn;

    ImageView BackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        MagaaralBtn = findViewById(R.id.magaaralBtn);
        GuroBtn = findViewById(R.id.guroBtn);
        MagulangBtn = findViewById(R.id.magulangBtn);
        AdminBtn = findViewById(R.id.adminBtn);
        BackBtn = findViewById(R.id.backIcon);

        MagaaralBtn.setOnClickListener(view -> {
            LaunchIntent(MgaAralin.class, "Magaaral");
        });

        BackBtn.setOnClickListener(view -> {
            LaunchIntent(MainActivity.class, null);
        });

        GuroBtn.setOnClickListener(view -> {
            LaunchIntent(Login.class, "Guro");
        });
        MagulangBtn.setOnClickListener(view -> {
            LaunchIntent(Login.class, "Magulang");
        });
        AdminBtn.setOnClickListener(view -> {
            LaunchIntent(Login.class, "Admin");
        });

        InitializeAnimation();
    }

    public  void InitializeAnimation(){
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.trans_fade_in);
        MagaaralBtn.startAnimation(fadeIn);
        GuroBtn.startAnimation(fadeIn);
        MagulangBtn.startAnimation(fadeIn);
        AdminBtn.startAnimation(fadeIn);
    }

    public  void LaunchIntent(Class<?> targetActivity, String userLevel){
        Intent intent = new Intent(UserSelect.this, targetActivity);
        intent.putExtra("userLevel", userLevel);
        startActivity(intent);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        LaunchIntent(MainActivity.class, null);
    }
}