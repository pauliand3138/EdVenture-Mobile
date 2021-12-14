package com.example.adventure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adventure.Model.User;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://edventure-628aa-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference userTable = database.getReference("User");

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (!editUsername.getText().toString().isEmpty()) {
                    userTable.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            //Check whether or not username is exist in database
                            if (snapshot.child(editUsername.getText().toString()).exists()) {

                                //Get customer information
                                User user = snapshot.child(editUsername.getText().toString()).getValue(User.class);
                                user.setUserID(editUsername.getText().toString());

                                if (user.getUserPassword().equals(editPassword.getText().toString())) {
                                    Toast.makeText(Login.this, "Login successful!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login.this, Home.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(Login.this, "Password incorrect! Please try again!", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(Login.this, "User does not exist!", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                } else {
                    Toast.makeText(Login.this, "Please enter username and password!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Login.this, Home.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }
}