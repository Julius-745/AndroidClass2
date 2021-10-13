package com.julius745.crudfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class TodoList extends AppCompatActivity {

    private ListView myList;
    private ListAdapter todoListAdapter;
    private notesmodels notesmodels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
    }
}