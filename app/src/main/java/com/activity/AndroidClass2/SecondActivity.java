package com.activity.AndroidClass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
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

        RelativeLayout web1 = (RelativeLayout) findViewById(R.id.btn1);
        RelativeLayout web2 = (RelativeLayout) findViewById(R.id.btn2);
        RelativeLayout web3 = (RelativeLayout) findViewById(R.id.btn3);

        web1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String url = "https://www.cnnindonesia.com/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
        });

        web2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.kompas.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        web3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.detik.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

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
                startActivity(new Intent(this, Settings.class));
                return true;
            case R.id.logout:
                Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}