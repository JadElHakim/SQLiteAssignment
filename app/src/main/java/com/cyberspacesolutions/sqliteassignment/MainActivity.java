package com.cyberspacesolutions.sqliteassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adpater.OnExamListener {
    RecyclerView recyclerView;
    MyDatabaseHelper db;
    ArrayList<String> courses,links;
    Adpater ad ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.MainView);
        //init arraylists to add/read elements
        courses = new ArrayList<>();
        links = new ArrayList<>();
        //init db
        db = new MyDatabaseHelper(MainActivity.this);
        //add into db dummy data
//        db.add("Mobile computing","https://developer.android.com/docs");
//        db.add("Web Development","https://www.w3schools.com/html/");
//        db.add("Data Structures","https://www.youtube.com/channel/UCZCFT11CWBi3MHNlGf019nw");
        //fetches all the content from db
        display();
        //set the custom adapter to the recycler view
        ad = new Adpater(MainActivity.this,courses,links,  this);
        recyclerView.setAdapter(ad);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void display(){
        Cursor cursor = db.readAll();
        //if db table is empty prompt
        if(cursor.getCount() == 0){
            Toast.makeText(this, "There is no data", Toast.LENGTH_SHORT).show();
        }else{
            //iterate through the db results and put into arrays to show in recycler view
            while (cursor.moveToNext()){
                courses.add(cursor.getString(0));
                links.add(cursor.getString(1));
            }
        }
    }
    //onclick for each item
    @Override
    public void onExamClick(int pos) {
        Intent intent = new Intent(this, webview.class);
        //put the link in to open it in webview in next activity
        intent.putExtra("link",links.get(pos));
        startActivity(intent);
    }
}