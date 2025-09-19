package com.example.marungkoapp.Aralin1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.marungkoapp.MgaAralin;
import com.example.marungkoapp.R;
import com.example.marungkoapp.UserSelect;

import java.util.Locale;

public class Aralin1_Item4 extends AppCompatActivity {

    ImageView BackBtn;
    ImageButton BumalikBtn, MagpatuloyBtn, SunodBtn, BumalikMenuBtn;
    ImageButton ManikaBtn, AtisBtn, SiliBtn;
    ImageButton AlonAgilaBtn, SobreMapaBtn, SabonAklatBtn;
    ImageButton MmBtn, SsBtn, AaBtn;

    TextView TotalScore;

    LinearLayout PagsusulitItem1, PagsusulitItem2, PagsusulitItem3, PagsusulitItem4;

    private int currentNumber = 2;
    private int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aralin1_item4);
        MagpatuloyBtn = findViewById(R.id.magpatuloyBtn);
        BumalikBtn = findViewById(R.id.bumalikBtn);
        BackBtn = findViewById(R.id.backIcon);
        SunodBtn = findViewById(R.id.sunodBtn);
        BumalikMenuBtn = findViewById(R.id.bumalikMenuBtn);
        TotalScore = findViewById(R.id.totalScore);

        BumalikBtn.setOnClickListener(view -> LaunchIntent(Aralin1_Item3.class));
        MagpatuloyBtn.setOnClickListener(view -> LaunchIntent(Aralin1_Item4.class));
        BackBtn.setOnClickListener(view -> LaunchIntent(MgaAralin.class));
        BumalikMenuBtn.setOnClickListener(v -> LaunchIntent(MgaAralin.class));

        ManikaBtn = findViewById(R.id.manikaBtn);
        AtisBtn = findViewById(R.id.siliBtn);
        SiliBtn = findViewById(R.id.atisBtn);

        ManikaBtn.setOnClickListener(v -> checkAnswer(true, ManikaBtn, 1));
        AtisBtn.setOnClickListener(v -> checkAnswer(false, AtisBtn, 1));
        SiliBtn.setOnClickListener(v -> checkAnswer(false, SiliBtn, 1));

        AlonAgilaBtn = findViewById(R.id.alonAgilaBtn);
        SobreMapaBtn = findViewById(R.id.sobreMapaBtn);
        SabonAklatBtn = findViewById(R.id.sabonAklatBtn);

        AlonAgilaBtn.setOnClickListener(v -> checkAnswer(true, AlonAgilaBtn, 2));
        SobreMapaBtn.setOnClickListener(v -> checkAnswer(false, SobreMapaBtn, 2));
        SabonAklatBtn.setOnClickListener(v -> checkAnswer(false, SabonAklatBtn, 2));

        MmBtn = findViewById(R.id.mmBtn);
        SsBtn = findViewById(R.id.ssBtn);
        AaBtn = findViewById(R.id.aaBtn);

        MmBtn.setOnClickListener(v -> checkAnswer(false, MmBtn, 3));
        SsBtn.setOnClickListener(v -> checkAnswer(false, SsBtn, 3));
        AaBtn.setOnClickListener(v -> checkAnswer(true, AaBtn, 3));

        PagsusulitItem1 = findViewById(R.id.pagsusulitItem1);
        PagsusulitItem2 = findViewById(R.id.pagsusulitItem2);
        PagsusulitItem3 = findViewById(R.id.pagsusulitItem3);
        PagsusulitItem4 = findViewById(R.id.pagsusulitItem4);

        SunodBtn.setOnClickListener(v -> nextChecker(currentNumber));
    }


    private void nextChecker(int itemNumber) {
        PagsusulitItem1.setVisibility(View.GONE);
        PagsusulitItem2.setVisibility(View.GONE);
        PagsusulitItem3.setVisibility(View.GONE);
        PagsusulitItem4.setVisibility(View.GONE);

        switch (itemNumber) {
            case 1:
                PagsusulitItem1.setVisibility(View.VISIBLE);
                break;

            case 2:
                PagsusulitItem2.setVisibility(View.VISIBLE);
                break;

            case 3:
                PagsusulitItem3.setVisibility(View.VISIBLE);
                break;

            case 4:
                PagsusulitItem4.setVisibility(View.VISIBLE);
                TotalScore.setText(String.valueOf(totalScore) + "/3");
                break;

            default:
                break;
        }

        currentNumber++;
        SunodBtn.setVisibility(View.GONE);
    }


    private void checkAnswer(boolean isCorrect, ImageButton button, int itemNumber) {
        if (isCorrect) {
            button.setColorFilter(Color.argb(150, 0, 255, 0));
            disableAllButtons(itemNumber);
            SunodBtn.setVisibility(View.VISIBLE);
            totalScore++;
        } else {
            button.setColorFilter(Color.argb(150, 255, 0, 0));
            disableAllButtons(itemNumber);
            SunodBtn.setVisibility(View.VISIBLE);
        }
    }

    private void disableAllButtons(int item) {
        switch (item) {
            case 1:
                AtisBtn.setEnabled(false);
                SiliBtn.setEnabled(false);
                ManikaBtn.setEnabled(false);
                break;

            case 2:
                AlonAgilaBtn.setEnabled(false);
                SobreMapaBtn.setEnabled(false);
                SabonAklatBtn.setEnabled(false);
                break;

            case 3:
                MmBtn.setEnabled(false);
                SsBtn.setEnabled(false);
                AaBtn.setEnabled(false);
                break;

            default:
                break;
        }
    }

    public void LaunchIntent(Class<?> targetActivity) {
        Intent intent = new Intent(Aralin1_Item4.this, targetActivity);
        startActivity(intent);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        LaunchIntent(MgaAralin.class);
    }

}