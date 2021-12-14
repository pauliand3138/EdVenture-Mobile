package com.example.adventure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class Register extends AppCompatActivity {

    MaterialButton registerButton;
    EditText editUsername, editFullName, editPassword, editRetypePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        registerButton = findViewById(R.id.registerButton);
        editUsername = findViewById(R.id.editUsername);
        editFullName = findViewById(R.id.editFullName);
        editPassword = findViewById(R.id.editPassword);
        editRetypePassword = findViewById(R.id.editRetypePassword);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://edventure-628aa-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference userTable = database.getReference("User");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userTable.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (editFullName.getText().toString().equals("") || editUsername.getText().toString().equals("") || editPassword.getText().toString().equals("") ||
                                editRetypePassword.getText().toString().equals("")) {
                            Toast.makeText(Register.this, "All fields must not be empty!", Toast.LENGTH_SHORT).show();

                        } else if ((editPassword.getText().toString().equals(editRetypePassword.getText().toString())) && (!editPassword.getText().toString().equals(""))) {
                            //Username already exist
                            if (snapshot.child(editUsername.getText().toString()).exists()) {
                                Toast.makeText(Register.this, "Username already exist!", Toast.LENGTH_SHORT).show();

                            } else {
                                User customer = new User(editFullName.getText().toString(), editPassword.getText().toString());
                                userTable.child(editUsername.getText().toString()).setValue(customer);
                                Toast.makeText(Register.this, "Registration successful! ", Toast.LENGTH_SHORT).show();
                                finish(); //close activity
                            }
                        } else {
                            Toast.makeText(Register.this, "Both passwords must be the same!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
}