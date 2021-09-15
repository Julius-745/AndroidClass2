package com.activity.AndroidClass2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
        daftar.setEnabled(false);


        editText = (EditText) findViewById(R.id.et1);
        editText2 = (EditText) findViewById(R.id.et2);

        if (TextUtils.isEmpty(editText.getText().toString()) || TextUtils.isEmpty(editText2.getText().toString())) {
            Toast.makeText(MainActivity.this, "Empty Field Not Allowed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Proceed", Toast.LENGTH_SHORT).show();
            daftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}