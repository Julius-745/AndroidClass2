package com.julius745.crudfile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TodoList extends AppCompatActivity {

    private ListView mTodoListView;
    private DBHandler mHelper;
    private NoteAdapter mAdapter;
    Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        mHelper = new DBHandler(this);
        mTodoListView = (ListView) findViewById(R.id.todo_list);
        mAdapter = new NoteAdapter(this, R.layout.row_todo_list, new ArrayList<>());
        mTodoListView.setAdapter(mAdapter);

        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHelper.delete(id);
                Toast.makeText(TodoList.this, "Deleted List", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUI() {
        List<Note> taskList = mHelper.getAllNotes();
        mAdapter.clear();
        mAdapter.addAll(taskList);
        mAdapter.notifyDataSetChanged();

    }


}