package com.cyberspacesolutions.sqliteassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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
        //create table
        String query = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_EXAM + " TEXT, " +
                        COLUMN_LINK + " TEXT);";
        //execute query
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    //add into db method
    void add(String exam,String link){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //add exam into exam column
        cv.put(COLUMN_EXAM,exam);
        //add link into link column
        cv.put(COLUMN_LINK,link);
       long result = db.insert(TABLE_NAME,null,cv);
       //if insert failed
       if(result == -1){
           Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
       }
       //if insert was succesfull
       else{
           Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
       }
    }
    //select all from table
    Cursor readAll(){
        //select query
        String query = " SELECT " +COLUMN_EXAM+","+COLUMN_LINK +" FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        //if database is not empty set query as cursor.
        //used later to iterate
        if(db != null){
           cursor =  db.rawQuery(query,null);
        }
    return cursor;
    }
}
