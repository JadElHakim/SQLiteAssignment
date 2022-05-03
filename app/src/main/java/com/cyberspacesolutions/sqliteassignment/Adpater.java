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
    OnExamListener onExamListener;
    Adpater(Context context, ArrayList courses , ArrayList links, OnExamListener onExamListener){
        this.context = context;
        this.courses = courses;
        this.links = links;
        this.onExamListener = onExamListener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_row,parent,false);
        return new MyViewHolder(view, onExamListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.courseT.setText(String.valueOf(courses.get(position)));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView courseT;
        OnExamListener oe;
        public MyViewHolder(View view, OnExamListener onExamListener) {
            super(view);
            courseT = view.findViewById(R.id.courseTitle);
            this.oe = onExamListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            oe.onExamClick(getAdapterPosition());
        }
    }
    public interface OnExamListener{
        void onExamClick(int pos);
    }
}
