package com.example.marungkoapp.Aralin1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marungkoapp.MgaAralin;
import com.example.marungkoapp.R;
import com.example.marungkoapp.UserSelect;

import java.util.Locale;

public class Aralin1_Item1 extends AppCompatActivity {
    ImageView BackBtn;
    ImageButton MagpatuloyBtn, PakingganBtn;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aralin1_item1);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        MagpatuloyBtn = findViewById(R.id.magpatuloyBtn);
        MagpatuloyBtn.setOnClickListener(view -> LaunchIntent(Aralin1_Item2.class));

        PakingganBtn = findViewById(R.id.pakingganBtn);
        BackBtn = findViewById(R.id.backIcon);

        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = tts.setLanguage(new Locale("fil", "PH"));
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });


        PakingganBtn.setOnClickListener(view -> {
            speak("Ang letrang M...");
        });

        BackBtn.setOnClickListener(view -> LaunchIntent(MgaAralin.class));
    }

    private void speak(String text) {
        if (tts != null) {
            tts.stop();
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    public void LaunchIntent(Class<?> targetActivity) {
        Intent intent = new Intent(Aralin1_Item1.this, targetActivity);
        startActivity(intent);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        LaunchIntent(MgaAralin.class);
    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}