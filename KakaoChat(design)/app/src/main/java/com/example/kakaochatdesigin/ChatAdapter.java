package com.example.kakaochatdesigin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder>{

    private static final String TAG = "ChatAdapter";
    
    private final List<User> users;

    public ChatAdapter(List<User> users) {
        this.users = users;
    }

    public void addItem(User user){
        users.add(user);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        users.remove(position);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.chat_item,parent,false);

        return new MyViewHolder(view); //view가 리사이클러뷰에 하나 그려짐.
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        //2번 user_item이 가지고 있는 위젯들을 선언
        private TextView tvUsername;
        private TextView tvContent;
        private TextView tvchatDate;
        private ImageView ivProfile;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }


        public void setItem(User user){

        }
    }

}
