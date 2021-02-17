package com.example.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.List;

public class MovieAdapter extends BaseAdapter {

    private static final String TAG = "ItemAdapter";
    private final List<Movie> movies; //final로 만들면 alter + enter로 생성자 만들기 편하다.
    //private final Context mContext;


    public MovieAdapter(List<Movie> movies) {  //, Context mContext
        this.movies = movies;
        //this.mContext = mContext; //이렇게 해서 메인 컨텍스트를 넘겨받을 수도 있다. 근데 이렇게 넘겨받을 필요없다. getview 인자에 이미 정의
    }

    public void addItem(Movie movie){
        movies.add(movie);
        //notifyDataSetChanged(); 여기다 직접 추가하는 건 비추천
        uiChange();
    }

    public void removeItem(int position){
        movies.remove(position);
        notifyDataSetChanged();
    }

    public void uiChange(){
        notifyDataSetChanged();
    }

    //전체크기를 확인하기 위해서 필요(나도, 어댑터 자체도)
    @Override
    public int getCount() {
        return movies.size();
    }

    //클릭하거나 어떤 이벤트 발생시에 컬렉션 정보를 확인하기 위해 필요
    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    //클릭했을 때 어떤 아이템을 알기 위해
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //객체를 생성해서 그림을 그리는 함수(객체를 6번(movies.size) 생성해서 그림을 그리는 함수 50dp)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d(TAG, "getView: "+position);
        if (convertView == null){ //처음에는 새로 만들어지니까 null이고, 이후에는 계속 남아있을 것이다. 이 convertview를 재사용하는 게 리사이클러뷰
            Log.d(TAG, "convertview가 null입니다");
        }else{
            Log.d(TAG, "convertview가 null이 아닙니다");
        }

        //1. 부모 컨텍스트 가져오기 (Context <- MainActivity)
        MainActivity mainActivityContext = (MainActivity)parent.getContext(); //액티비티 컨텍스트를 가져온다.
        //Context context = parent.getContext();
        //MainActivity mainActivity = (MainActivity)context;

        //인플레이터 객체 생성 완료(옛날 방법) - xml을 자바 객체로 만들게 해주는 도구
        LayoutInflater inflater = (LayoutInflater)mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //LayoutInflater inflater1 = LayoutInflater.from(context); //새로 나온 방법


//        if(convertView == null) { //디자인을 재사용(convertview), 임의로 리사이클러뷰를 만듬. 대신 강제성이 없음
//            convertView = inflater.inflate(R.layout.list_item, parent);
//        }

        //걍 재사용 않고 새로 만들어라.
        View view = inflater.inflate(R.layout.movie_item, parent,false);
        TextView tvTitle = view.findViewById(R.id.tv_titlte);
        tvTitle.setText(movies.get(position).getTitle());
        ImageView ivPic = view.findViewById(R.id.iv_pic);
        //ivPic.setImageResource(R.drawable.mov02);
        ivPic.setImageResource(movies.get(position).getPic());




        view.setOnClickListener(v -> {
            Log.d(TAG, "클릭됨");
            Toast.makeText(mainActivityContext, "클릭됨"+position, Toast.LENGTH_LONG).show(); //왜 안 되지..
            Intent intent = new Intent(mainActivityContext,DetailActivity.class);
            intent.putExtra("title",movies.get(position).getTitle());
            mainActivityContext.startActivity(intent);
        });

        view.setOnLongClickListener(v -> {
            Toast.makeText(mainActivityContext, "롱클릭됨"+position, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "movies 사이즈"+movies.size());
            movies.remove(position);
            Log.d(TAG, "movies 변경된 사이즈"+movies.size());

            this.notifyDataSetChanged(); // 데이터 화면 동기화- 데이터 변경 후 UI 동기화 시 호출해야함
            return true;
        });

        return view;
    }



}