package com.julius745.crudfile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notes_db";
    private static final String TABLE_NOTES = "notes";

    private static final String KEY_ID = "id";
    private static final String KEY_CONTENT = "content";
    private static final String KEY_CHECKED = "checked";

    public DBHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TDL_TABLE = "CREATE TABLE " + TABLE_NOTES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_CONTENT + " TEXT,"
                + KEY_CHECKED + " BOOLEAN" + ")";
        db.execSQL(CREATE_TDL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }


    // Insert or update a note in the database
    // Since SQLite doesn't support "upsert" we need to fall back on an attempt to UPDATE (in case the
    // note already exists) optionally followed by an INSERT (in case the note does not already exist).
    // Unfortunately, there is a bug with the insertOnConflict method
    // (https://code.google.com/p/android/issues/detail?id=13045) so we need to fall back to the more
    // verbose option of querying for the note's primary key if we did an update.
    public long addOrUpdateNote(Note note) {
        // The database connection is cached so it's not expensive to call getWriteableDatabase() multiple times.
        SQLiteDatabase db = getWritableDatabase();
        long noteId = -1;

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_ID, note.id);
            values.put(KEY_CONTENT, note.content);
            values.put(KEY_CHECKED, note.checked);

            // First try to update the note in case the note already exists in the database
            // This assumes userNames are unique
            int rows = note.id > 0 ? db.update(TABLE_NOTES, values, KEY_ID + "= ?", new String[]{ Long.toString(note.id) }) : 0;

            // Check if update succeeded
            if (rows == 1) {
                noteId = note.id;
            } else {
                // note with this userName did not already exist, so insert new note
                noteId = db.insertOrThrow(TABLE_NOTES, null, values);
            }
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("DB", "Error while trying to add or update note");
        } finally {
            db.endTransaction();
        }
        return noteId;
    }

    public List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();

        // SELECT * FROM POSTS
        // LEFT OUTER JOIN USERS
        // ON POSTS.KEY_POST_USER_ID_FK = USERS.KEY_USER_ID
        String POSTS_SELECT_QUERY =
                String.format("SELECT * FROM %s", TABLE_NOTES);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(POSTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    Note newPost = new Note();
                    newPost.id = cursor.getLong(cursor.getColumnIndex(KEY_ID));
                    newPost.content = cursor.getString(cursor.getColumnIndex(KEY_CONTENT));
                    newPost.checked = cursor.getInt(cursor.getColumnIndex(KEY_CHECKED)) == 1;
                    notes.add(newPost);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d("DB", "Error while trying to get notes from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return notes;
    }

    public void Delete(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTES,KEY_ID+"="+id,null);
        db.close();
    }
}
