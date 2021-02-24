package com.example.moviemvvm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviemvvm.MainActivity;
import com.example.moviemvvm.R;
import com.example.moviemvvm.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private static final String TAG = "MovieAdapter";

    private List<Movie> movies = new ArrayList<>();

    public void setMovies(List<Movie> movies){
        Log.d(TAG, "MovieViewHolder: 들어옴?");
        this.movies = movies;
        notifyDataSetChanged();
    }

    public void removeItem(int position){ //mutable live data만 삭제..
        movies.remove(position);
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.movie_item,parent,false);

        return new MovieViewHolder(view); //view가 리스트뷰에 하나 그려짐.
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        holder.setItem(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {


        private TextView tvTitle,tvUrl,tvYear,tvRating, tvRuntime, tvSummary;
        private ImageView ivPic, ivTrash;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUrl = itemView.findViewById(R.id.tv_url);
            tvYear = itemView.findViewById(R.id.tv_year);
            tvRating = itemView.findViewById(R.id.tv_rating);
            tvRuntime = itemView.findViewById(R.id.tv_runtime);
            tvSummary = itemView.findViewById(R.id.tv_summary);
            ivPic = itemView.findViewById(R.id.iv_pic);
            tvTitle = itemView.findViewById(R.id.tv_title);

            ivTrash = itemView.findViewById(R.id.iv_trash);

            ivTrash.setOnClickListener(v -> {
                Log.d(TAG, "클릭됨"+getAdapterPosition());
                removeItem(getAdapterPosition());
            });

        }


        public void setItem(Movie movie){
            tvTitle.setText(movie.getTitle());
            tvYear.setText(movie.getYear().toString());
            tvRating.setText(movie.getRating().toString());
            tvRuntime.setText(movie.getRuntime().toString());
            tvSummary.setText(movie.getSummary());
            tvUrl.setText(movie.getUrl());

            Glide //내가 아무것도 안 했는데 스레드로 동작(편안)
                    .with(itemView)
                    .load(movie.getMedium_cover_image())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(ivPic);


        }

    }
}
