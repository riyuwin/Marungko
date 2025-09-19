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

public class Signup extends AppCompatActivity {

    ImageView BackBtn;
    ImageButton SignupBtn;
    TextView LoginBtn;
    EditText UsernameEditText, EmailEditText, PasswordEditText, ConfirmEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        BackBtn = findViewById(R.id.backIcon);
        SignupBtn = findViewById(R.id.signupBtn);
        LoginBtn = findViewById(R.id.loginBtn);
        UsernameEditText = findViewById(R.id.usernameEdit);
        EmailEditText = findViewById(R.id.emailEdit);
        PasswordEditText = findViewById(R.id.passwordEdit);
        ConfirmEditText = findViewById(R.id.confirmPasswordEdit);

        BackBtn.setOnClickListener(view -> LaunchIntent(Login.class));
        LoginBtn.setOnClickListener(view -> LaunchIntent(Login.class));

        SignupBtn.setOnClickListener(view -> {
            String emailString = EmailEditText.getText().toString().trim();
            String usernameString = UsernameEditText.getText().toString().trim();
            String passwordString = PasswordEditText.getText().toString().trim();
            String confirmPasswordString = ConfirmEditText.getText().toString().trim();

            if (!TextUtils.isEmpty(emailString) &&
                    !TextUtils.isEmpty(usernameString) &&
                    !TextUtils.isEmpty(passwordString) &&
                    !TextUtils.isEmpty(confirmPasswordString) &&
                    passwordString.equals(confirmPasswordString)) {

                Toast.makeText(this, "Hi! " + usernameString, Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Please enter all valid fields", Toast.LENGTH_SHORT).show();
            }


        });
    }

    public void LaunchIntent(Class<?> targetActivity) {
        Intent intent = new Intent(Signup.this, targetActivity);
        startActivity(intent);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        LaunchIntent(Login.class);
    }
}