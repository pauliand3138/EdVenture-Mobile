package com.example.adventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CourseChapter extends AppCompatActivity {
    ImageView subtopicButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_chapter);
        getSupportActionBar().hide();

        subtopicButton = findViewById(R.id.subtopic1);

        subtopicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseChapter.this, CourseVideo.class);
                startActivity(intent);
            }
        });

        backButton = findViewById(R.id.imageView24);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}