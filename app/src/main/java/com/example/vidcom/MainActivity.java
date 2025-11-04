package com.example.vidcom;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button uploadBtn;
    private int PICK_VIDEO_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        uploadBtn = findViewById(R.id.uploadbtn);
        uploadBtn.setOnClickListener(v->{
            Intent intent = new Intent(android.content.Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            getIntent().setType("video/*");
            startActivityForResult(intent,PICK_VIDEO_REQUEST);
        });

    }
}