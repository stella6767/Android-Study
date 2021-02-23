package com.example.retrofitex1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private static final String TAG = "PostAdapter";

    private List<Post> posts = new ArrayList<>(); //네트워크로 통신해서 데이터 받을 거면 이렇게 하는 게 편안

    public void setPosts(List<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.post_item,parent,false);

        return new MyViewHolder(view); //view가 리스트뷰에 하나 그려짐.
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.setItem(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        private TextView tvTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.user_id);

        }

        public void setItem(Post post){
            tvTitle.setText(post.getTitle());

        }

    }
}
