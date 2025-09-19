package com.example.marungkoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marungkoapp.Aralin1.Aralin1Guide;

public class MgaAralin extends AppCompatActivity {

    ImageButton AralinBtn1, AralinBtn2, AralinBtn3, AralinBtn4, AralinBtn5, AralinBtn6, AralinBtn7, AralinBtn8, AralinBtn9, AralinBtn10;
    ImageView BackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mga_aralin);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        AralinBtn1 = findViewById(R.id.magaaralBtn1);
        AralinBtn2 = findViewById(R.id.magaaralBtn2);
        AralinBtn3 = findViewById(R.id.magaaralBtn3);
        AralinBtn4 = findViewById(R.id.magaaralBtn4);
        AralinBtn5 = findViewById(R.id.magaaralBtn5);
        AralinBtn6 = findViewById(R.id.magaaralBtn6);
        AralinBtn7 = findViewById(R.id.magaaralBtn7);
        AralinBtn8 = findViewById(R.id.magaaralBtn8);
        AralinBtn9 = findViewById(R.id.magaaralBtn9);
        AralinBtn10 = findViewById(R.id.magaaralBtn10);

        BackBtn = findViewById(R.id.backIcon);
        BackBtn.setOnClickListener(view -> {
            LaunchIntent(UserSelect.class);
        });

        AralinBtn1.setOnClickListener(view -> {
            LaunchIntent(Aralin1Guide.class);
        });

        InitializeAnimation();
    }


    public  void InitializeAnimation(){
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.trans_fade_in);
        AralinBtn1.startAnimation(fadeIn);
        AralinBtn2.startAnimation(fadeIn);
        AralinBtn3.startAnimation(fadeIn);
        AralinBtn4.startAnimation(fadeIn);
        AralinBtn5.startAnimation(fadeIn);
        AralinBtn6.startAnimation(fadeIn);
        AralinBtn7.startAnimation(fadeIn);
        AralinBtn8.startAnimation(fadeIn);
        AralinBtn9.startAnimation(fadeIn);
        AralinBtn10.startAnimation(fadeIn);
    }


    public  void LaunchIntent(Class<?> targetActivity){
        Intent intent = new Intent(MgaAralin.this, targetActivity);
        startActivity(intent);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        LaunchIntent(UserSelect.class);
    }
}