package com.julius745.crudfile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TodoList extends AppCompatActivity {

    private ListView mTodoListView;
    private DBHandler mHelper;
    private NoteAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        mHelper = new DBHandler(this);
        mTodoListView = (ListView) findViewById(R.id.todo_list);
        mAdapter = new NoteAdapter(this, R.layout.row_todo_list, new ArrayList<>());
        mTodoListView.setAdapter(mAdapter);
    }

    private void updateUI() {
        List<Note> taskList = mHelper.getAllNotes();
        mAdapter.clear();
        mAdapter.addAll(taskList);
        mAdapter.notifyDataSetChanged();

    }
}