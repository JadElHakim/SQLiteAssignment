package com.cyberspacesolutions.sqliteassignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adpater extends RecyclerView.Adapter<Adpater.MyViewHolder> {
    Context context;
    ArrayList courses,links;
    Adpater(Context context, ArrayList courses , ArrayList links){
        this.context = context;
        this.courses = courses;
        this.links = links;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.courseT.setText(String.valueOf(courses.get(position)));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView courseT;
        public MyViewHolder(View view) {
            super(view);
            courseT = view.findViewById(R.id.courseTitle);
        }
    }
}
