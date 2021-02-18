package com.example.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder>{

    private static final String TAG = "NoteAdapter";

    private final List<Note> notes;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    public void addItem(Note note){
        notes.add(note);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        notes.remove(position);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.note_item,parent,false);

        return new MyViewHolder(view); //view가 리사이클러뷰에 하나 그려짐.
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(notes.get(position));

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    //1번
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        //2번 user_item이 가지고 있는 위젯들을 선언
        private TextView tvTitle;
        private TextView tvSubTitle;
        private TextView tvMin;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_titlte);
            tvSubTitle = itemView.findViewById(R.id.tv_subTitle);
            tvMin = itemView.findViewById(R.id.tv_min);
        }

        public void setItem(Note note){
            tvTitle.setText(note.getTitle());
            tvSubTitle.setText(note.getSubtitle());
            tvMin.setText(note.getMin().toString());
        }
    }


}