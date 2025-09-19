package com.example.marungkoapp.Aralin1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marungkoapp.R;

public class Aralin1Guide extends AppCompatActivity {

    ImageView MagsimulaBn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aralin1_guide);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        MagsimulaBn = findViewById(R.id.magsimulaBtn);

        MagsimulaBn.setOnClickListener(view -> {
            LaunchIntent(Aralin1_Item1.class);
        });


    }

    public  void LaunchIntent(Class<?> targetActivity){
        Intent intent = new Intent(Aralin1Guide.this, targetActivity);
        startActivity(intent);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        //LaunchIntent(MgaAralin.class);
    }
}