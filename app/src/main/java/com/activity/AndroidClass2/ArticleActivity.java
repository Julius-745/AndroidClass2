package com.activity.AndroidClass2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.os.Bundle;
import android.widget.Button;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnn);

        ArticlesFragment fragment = ArticlesFragment.newInstance("https://cnn.com");
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}