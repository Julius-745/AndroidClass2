package com.activity.AndroidClass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    // 5000 milidetik = 5 detik
    private final int SPLASH_LENGTH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // title bar nya dihabis
        getSupportActionBar().hide();

        // delay 5 detik (SPLASH_LENGTH)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // ambil mainactivity
                Intent main = new Intent(SplashScreen.this,MainActivity.class);
                // load mainactivity (bagian e julius)
                SplashScreen.this.startActivity(main);
                SplashScreen.this.finish();
            }
        }, SPLASH_LENGTH);

    }
}