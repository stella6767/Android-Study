package com.example.movieapp;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


//익명클래스 내부에서는 외부에 변수(스택)를 접근할 수는 있는데 변결할 수 없다.
//전역변수로 만들면 다 해결되요!!
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private static final String TAG = "MovieAdapter";
    private final List<Integer> movies;
    private float ratingSaved = 0;

    public MovieAdapter(List<Integer> movies) {
        this.movies = movies;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivItem;


        public MyViewHolder(@NonNull View itemView) {  //D스택
            super(itemView);
            ivItem = itemView.findViewById(R.id.iv_item);

            //어쩔때는 ViewGroup 정보, Activity 정보

            ivItem.setOnClickListener(v -> { // C 스택
                View dialog = v.inflate(v.getContext(), R.layout.dialog_item, null); //애는 viewgroup이 없어서 null이라고 적어야 된다./
                ImageView ivItem = dialog.findViewById(R.id.iv_item);
                int pos = getAdapterPosition();
                ivItem.setImageResource(movies.get(pos));

                AlertDialog.Builder dlg = new AlertDialog.Builder(v.getContext());

                //추가
                SharedPreferences pref = v.getContext().getSharedPreferences("pref",MainActivity.MODE_PRIVATE); //메인 액티비티에서만 쓸 수 있게

                RatingBar ratingBar = dialog.findViewById(R.id.ratingBar);
                TextView tvRating = dialog.findViewById(R.id.rating);
                Log.d(TAG, "저장된 값: "+pref.getFloat("rating"+pos, 0));
                ratingBar.setRating(pref.getFloat("rating"+pos, 0));
                tvRating.setText(pref.getFloat("rating"+pos,0)+"");

                //float ratingSaved;//익명클래스 내부에서는 외부에 변수(스택)를 접근할 수는 있는데 변경할 수 없다.

                ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> { // A스택 rating
                    Log.d(TAG, "MyViewHolder: rating "+rating);
                    tvRating.setText(rating+"");
                    ratingSaved = rating;
                });


                dlg.setTitle("큰 포스터");
                dlg.setIcon(R.drawable.movie_icon);
                dlg.setView(dialog); //내용은 내가 디자인한 dialog
                dlg.setNegativeButton("닫기", null);
                dlg.setPositiveButton("확인", (dialog1, which) -> { // B스택
                    SharedPreferences.Editor ed = pref.edit(); //sharedPreferences를 제어할 editor를 선언
                    Log.d(TAG, "MyViewHolder: ratingSaved: " +ratingSaved);
                    ed.putFloat("rating"+pos, ratingSaved); // key,value 형식으로 저장
                    ed.commit(); //커밋을 해야 저장이 된다.

                });
                dlg.show();
            });
        }

        public void setItem(Integer i){
            ivItem.setImageResource(i);
        }
    }
}
