package com.activity.AndroidClass2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button daftar = (Button) findViewById(R.id.btn1);
        editText = (EditText) findViewById(R.id.et1);
        editText2 = (EditText) findViewById(R.id.et2);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().length() == 0) {
                    editText.setError("Nim Diperlukan!");
                } else if (editText2.getText().toString().length() == 0) {
                    editText2.setError("Username diperlukan!");
                } else {
                    Toast.makeText(getApplicationContext(), "Processed", Toast.LENGTH_SHORT);
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    public boolean onCreateOptionMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            startActivity(new Intent(this, Settings.class));
        } else if (item.getItemId() == R.id.about) {
            startActivity(new Intent(this, About.class));
        } else {
            startActivity(new Intent(this, Help.class));
        }
        return true;
    }
}