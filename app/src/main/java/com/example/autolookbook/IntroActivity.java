package com.example.autolookbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class IntroActivity extends AppCompatActivity {

    private static final int DELAY_TIME_MS = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Log.d("IntroActivity", "jasdeep hi : " + getTheme().toString());


        // Use a Handler to post a delayed action to start the LoginActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start LoginActivity after the delay
                Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish(); // Finish MainActivity to prevent going back to it when pressing back button
            }
        }, DELAY_TIME_MS);
    }
}
