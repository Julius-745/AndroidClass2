package com.activity.AndroidClass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Context konteks = getApplicationContext();
        CharSequence kata = "Berhasil!";
        int durasi = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(konteks,kata,durasi);
        toast.show();

        WebView web = (WebView) findViewById(R.id.wv);
        web.loadUrl("https://www.trunojoyo.ac.id/");

    }
}