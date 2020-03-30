package com.example.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.example.databases.DBAdapter.DATABASE_CREATE;
import static com.example.databases.DBAdapter.DATABASE_NAME;
import static com.example.databases.DBAdapter.DATABASE_TABLE;
import static com.example.databases.DBAdapter.DATABASE_VERSION;
import static com.example.databases.DBAdapter.KEY_EMAIL;
import static com.example.databases.DBAdapter.KEY_NAME;
import static com.example.databases.DBAdapter.KEY_ROWID;
import static com.example.databases.DBAdapter.TAG;

public class DatabaseHelper extends SQLiteOpenHelper {
    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DATABASE_CREATE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }
}


