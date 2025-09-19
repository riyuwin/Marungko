package com.example.marungkoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView logoImage;
    LinearLayout LinearContainer;
    ImageView MagsimulaBtn, MananaliksikBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        logoImage = findViewById(R.id.logo);
        LinearContainer = findViewById(R.id.linearContainer);
        MagsimulaBtn = findViewById(R.id.magsimulaBtn);
        MananaliksikBtn = findViewById(R.id.mananaliksikBtn);

        InitializeAnimation();

        MagsimulaBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UserSelect.class);
            startActivity(intent);
        });
    }

    public  void InitializeAnimation(){
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.trans_fade_in);
        logoImage.startAnimation(fadeIn);
        MagsimulaBtn.startAnimation(fadeIn);
        MananaliksikBtn.startAnimation(fadeIn);
    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        // None
    }

}