package com.example.adventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class Login extends AppCompatActivity {
    MaterialButton loginButton, registerButton, googleButton, facebookButton;
    EditText editUsername, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        googleButton = findViewById(R.id.googleButton);
        facebookButton = findViewById(R.id.facebookButton);
        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Home.class);
                startActivity(intent);
                finish();
            }
        });
    }
}