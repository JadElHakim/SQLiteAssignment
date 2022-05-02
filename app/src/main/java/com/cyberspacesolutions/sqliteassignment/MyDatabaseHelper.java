package com.cyberspacesolutions.sqliteassignment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DB_NAME="EXAM_DB";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME= "exams";
    private static final String COLUMN_ID= "id";
    private static final String COLUMN_EXAM= "exam";
    private static final String COLUMN_LINK= "link";
    
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_EXAM + " TEXT, " +
                        COLUMN_LINK + " TEXT);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
