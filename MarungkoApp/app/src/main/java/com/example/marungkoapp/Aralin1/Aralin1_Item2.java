package com.example.marungkoapp.Aralin1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marungkoapp.MgaAralin;
import com.example.marungkoapp.R;
import com.example.marungkoapp.UserSelect;

import java.util.Locale;

public class Aralin1_Item2 extends AppCompatActivity {

    ImageView BackBtn;
    ImageButton BumalikBtn, MagpatuloyBtn, MataBtn, MesaBtn, ManokBtn, MatandaBtn, MaisBtn;
    TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aralin1_item2);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        MagpatuloyBtn = findViewById(R.id.magpatuloyBtn);
        BumalikBtn = findViewById(R.id.bumalikBtn);
        BackBtn = findViewById(R.id.backIcon);

        MataBtn = findViewById(R.id.mataBtn);
        MesaBtn = findViewById(R.id.mesaBtn);
        ManokBtn = findViewById(R.id.manokBtn);
        MatandaBtn = findViewById(R.id.matandaBtn);
        MaisBtn = findViewById(R.id.maisBtn);

        BumalikBtn.setOnClickListener(view -> LaunchIntent(Aralin1_Item1.class));
        MagpatuloyBtn.setOnClickListener(view -> LaunchIntent(Aralin1_Item3.class));
        BackBtn.setOnClickListener(view -> LaunchIntent(MgaAralin.class));

        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = tts.setLanguage(new Locale("fil", "PH"));
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });

        MataBtn.setOnClickListener(v -> {
            showImage(R.drawable.mata_image);
            speak("Mata");
        });
        MesaBtn.setOnClickListener(v -> {
            showImage(R.drawable.mesa_image);
            speak("Mesa");
        });
        ManokBtn.setOnClickListener(v -> {
            showImage(R.drawable.manok_image);
            speak("Manok");
        });
        MatandaBtn.setOnClickListener(v -> {
            showImage(R.drawable.matanda_image);
            speak("Matanda");
        });
        MaisBtn.setOnClickListener(v -> {
            showImage(R.drawable.mais_image);
            speak("Mais");
        });

    }

    public void LaunchIntent(Class<?> targetActivity) {
        Intent intent = new Intent(Aralin1_Item2.this, targetActivity);
        startActivity(intent);
    }

    private void showImage(int imageRes) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_image_preview);

        ImageView imageView = dialog.findViewById(R.id.previewImage);
        imageView.setImageResource(imageRes);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        dialog.show();
    }

    private void speak(String text) {
        if (tts != null) {
            tts.stop();
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        LaunchIntent(MgaAralin.class);
    }

}