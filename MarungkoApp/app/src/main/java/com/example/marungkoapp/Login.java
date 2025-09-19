package com.example.marungkoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.marungkoapp.Aralin1.Aralin1_Item4;

public class Login extends AppCompatActivity {

    ImageView BackBtn;
    TextView SignupBtn;
    ImageButton LoginBtn;
    EditText EmailEditText, PasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        BackBtn = findViewById(R.id.backIcon);
        SignupBtn = findViewById(R.id.signupBtn);
        LoginBtn = findViewById(R.id.loginBtn);
        EmailEditText = findViewById(R.id.emailEdit);
        PasswordEditText = findViewById(R.id.passwordEdit);

        Intent userLevelText = getIntent();

        BackBtn.setOnClickListener(view -> LaunchIntent(MainActivity.class));
        SignupBtn.setOnClickListener(view -> LaunchIntent(Signup.class));

        LoginBtn.setOnClickListener(view -> {
            String emailString = EmailEditText.getText().toString().trim();
            String passwordString = PasswordEditText.getText().toString().trim();

            if (!TextUtils.isEmpty(emailString) && !TextUtils.isEmpty(passwordString)  ) {
                Toast.makeText(this, "Hi! " + emailString, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter all valid fields", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void LaunchIntent(Class<?> targetActivity) {
        Intent intent = new Intent(Login.this, targetActivity);
        startActivity(intent);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        LaunchIntent(MainActivity.class);
    }
}