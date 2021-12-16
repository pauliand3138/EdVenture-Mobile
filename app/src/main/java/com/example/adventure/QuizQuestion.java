package com.example.adventure;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;

public class QuizQuestion extends AppCompatActivity {
    MaterialButton submitButton;
    ImageView backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(QuizQuestion.this);

                LayoutInflater inflater = getLayoutInflater();
                View quizAlertDialog = inflater.inflate(R.layout.quiz_alertdialog,null);

                MaterialButton closeButton = quizAlertDialog.findViewById(R.id.closeButton);
                MaterialButton doneButton = quizAlertDialog.findViewById(R.id.doneButton);

                builder.setView(quizAlertDialog);

                final AlertDialog dialog = builder.create();

                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                doneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        finish();
                    }
                });

                dialog.show();
            }
        });
    }
}