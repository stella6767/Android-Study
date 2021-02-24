package com.cos.retrofit2movieapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.retrofit2movieapp.MainActivity;
import com.cos.retrofit2movieapp.R;
import com.cos.retrofit2movieapp.databinding.CardItemBinding;
import com.cos.retrofit2movieapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private static final String TAG = "MovieAdapter";
    private final MainActivity mContext;

    private List<Movie> movies = new ArrayList<>();

    public MovieAdapter(MainActivity mContext) {
        this.mContext = mContext;
    }

    public void setMovies(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }

    public Long getMovieId(int position){
        return movies.get(position).getId();
    }

//    public void deleteId(int position){
//        movies.remove(position);
//        notifyDataSetChanged();
//    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CardItemBinding cardItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.card_item,
                parent,
                false);


        return new MovieViewHolder(cardItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.cardItemBinding.setMovie(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    //card_item 디자인이 연결!!
    class MovieViewHolder extends RecyclerView.ViewHolder{
        private CardItemBinding cardItemBinding; //내가 만든 바인딩 된 xml 파일 뒤에 Binding만 붙어서 만들어진다.

        public MovieViewHolder(@NonNull CardItemBinding cardItemBinding) {

            super(cardItemBinding.getRoot());
            this.cardItemBinding = cardItemBinding;
        }
    }



}
