package com.cyberspacesolutions.sqliteassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyDatabaseHelper db;
    ArrayList<String> courses,links;
    Adpater ad ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.MainView);
        courses = new ArrayList<>();
        links = new ArrayList<>();
        db = new MyDatabaseHelper(MainActivity.this);
//        db.add("Mobile computing","https://developer.android.com/docs");
//        db.add("Web Development","https://www.w3schools.com/html/");
//        db.add("Data Structures","https://www.youtube.com/channel/UCZCFT11CWBi3MHNlGf019nw");
        display();
        ad = new Adpater(MainActivity.this,courses,links);
        recyclerView.setAdapter(ad);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void display(){
        Cursor cursor = db.readAll();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "There is no data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                courses.add(cursor.getString(0));
                links.add(cursor.getString(0));
            }
        }
    }
}