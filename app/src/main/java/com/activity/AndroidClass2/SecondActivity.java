package com.activity.AndroidClass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // ambil konteks
        Context konteks = getApplicationContext();
        // tampilkan toast
        CharSequence kata = "Berhasil!";
        int durasi = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(konteks,kata,durasi);
        toast.show();
        // ambil webview trus load halaman UTM
        WebView web = (WebView) findViewById(R.id.wv);
        web.loadUrl("https://www.trunojoyo.ac.id/");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.about:
                Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, About.class));
                return true;
            case R.id.settings:
                Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Help.class));
                return true;
            case R.id.logout:
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}