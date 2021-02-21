package com.example.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private static final String TAG = "MainActivity2";

    SwipeRefreshLayout mSwipeRefreshLayout;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //리스트뷰에 담기 위한 임의 값
        String beforeItems[] = { "11", "22", "33", "44"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, beforeItems);
        mSwipeRefreshLayout = findViewById(R.id.swipeRefresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        //색상지정
        mSwipeRefreshLayout.setColorSchemeResources(R.color.design_default_color_on_secondary, R.color.design_default_color_on_primary, R.color.black, R.color.purple_700);
        listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);

    }


    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        //3초후에 해당 adapter를 갱신하고 동글뱅이를 닫아준다.setRefreshing(false);
        //핸들러를 사용하는 이유는 일반쓰레드는 메인쓰레드가 가진 UI에 접근할 수 없기 때문에 핸들러를 이용해서
        //메시지큐에 메시지를 전달하고 루퍼를 이용하여 순서대로 UI에 접근한다.

        //반대로 메인쓰레드에서 일반 쓰레드에 접근하기 위해서는 루퍼를 만들어야 한다.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //해당 어댑터를 서버와 통신한 값이 나오면 됨
                String afterItems[] = insertData();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, afterItems);
                listview.setAdapter(adapter);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        },3000);
    }


    public String[] insertData(){
        Random r = new Random();
        int listCount = r.nextInt(10)+1;
        String afterItem[] = new String[listCount];
        for (int i=0; i<listCount; i++){
            afterItem[i] = r.nextInt(30)+"";
        }
        return afterItem;
    }


}