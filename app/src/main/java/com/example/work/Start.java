package com.example.work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;



public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        // Hide the title bar and make the activity fullscreen
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start);

        new Handler().postDelayed(() -> {
            // Start the MainActivity after a 2000ms (2 seconds) delay
            Intent intent = new Intent(Start.this, MainActivity.class);
            startActivity(intent);

            // Finish the current activity, so the user cannot go back to it with the back button
            finish();
        }, 2000);
    }
}
