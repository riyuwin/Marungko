package com.example.marungkoapp.Aralin1;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.marungkoapp.MgaAralin;
import com.example.marungkoapp.R;
import com.example.marungkoapp.UserSelect;

import java.util.Locale;

public class Aralin1_Item3 extends AppCompatActivity {

    ImageView BackBtn;
    ImageButton BumalikBtn, MagpatuloyBtn, ManikaBtn, MapaBtn, ManokBtn, MartilyoBtn, MesaBtn;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aralin1_item3);

        MagpatuloyBtn = findViewById(R.id.magpatuloyBtn);
        BumalikBtn = findViewById(R.id.bumalikBtn);
        BackBtn = findViewById(R.id.backIcon);

        ManikaBtn = findViewById(R.id.manikaBtn);
        MesaBtn = findViewById(R.id.mesaBtn);
        ManokBtn = findViewById(R.id.manokBtn);
        MapaBtn = findViewById(R.id.mapaBtn);
        MartilyoBtn = findViewById(R.id.martilyoBtn);

        BumalikBtn.setOnClickListener(view -> LaunchIntent(Aralin1_Item2.class));
        MagpatuloyBtn.setOnClickListener(view -> LaunchIntent(Aralin1_Item4.class));
        BackBtn.setOnClickListener(view -> LaunchIntent(MgaAralin.class));

        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = tts.setLanguage(new Locale("fil", "PH"));
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });

        ManikaBtn.setOnClickListener(v -> {
            showImage(R.drawable.manika_drawing);
            speak("Manika");
        });
        MesaBtn.setOnClickListener(v -> {
            showImage(R.drawable.mesa_drawing);
            speak("Mesa");
        });
        ManokBtn.setOnClickListener(v -> {
            showImage(R.drawable.manok_drawing);
            speak("Manok");
        });
        MartilyoBtn.setOnClickListener(v -> {
            showImage(R.drawable.martilyo_drawing);
            speak("Martilyo");
        });
        MapaBtn.setOnClickListener(v -> {
            showImage(R.drawable.mapa_drawing);
            speak("Mapa");
        });

    }

    public void LaunchIntent(Class<?> targetActivity) {
        Intent intent = new Intent(Aralin1_Item3.this, targetActivity);
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