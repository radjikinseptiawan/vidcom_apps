package com.example.vidcom;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    TextView text;
    ImageView img,icon;
    Animation top,bottom,top_img;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        text = findViewById(R.id.text);
        img = findViewById(R.id.icon);
        icon = findViewById(R.id.flag);

        top = AnimationUtils.loadAnimation(this,R.anim.top);
        top_img = AnimationUtils.loadAnimation(this, R.anim.top_img);
        bottom = AnimationUtils.loadAnimation(this,R.anim.bottom);

        text.startAnimation(bottom);
        img.startAnimation(top_img);
        icon.startAnimation(top);
        new Handler().postDelayed(()->{
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        },2000);
    }
}
