package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

//stack 생성
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private Context mContext = MainActivity.this; //mContext로 MainActivity 함수 쓸라면 다운캐스팅하면 된다.
    private RecyclerView rvNoteList;
    private List<Note> notes;
    private NoteAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml에 있는 그림이 메모리에 올라오는 과정 = 전체 인플레이트
        init();
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rvNoteList.setLayoutManager(manager);
        rvNoteList.setAdapter(adapter);
    }

    private void init(){
        rvNoteList = findViewById(R.id.rv_note_list);
        notes = new ArrayList<>();
        adapter = new NoteAdapter(notes);
        download();
    }


    private void download(){
        //스레드로 돌아야함, 그래서 void
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000); //I/O 작업이 운이 좋아서 짧으면 그림이 그려지지만 아니면 안 뜸 동기화 작업이 필요
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i=1; i<50; i++) {
                    notes.add(new Note(i, "Alie Conners Brunch this weekend?","I'll be in your neighborhood",15));
                }

                //adapter.notifyDataSetChanged(); //이것만으로는 안 됨
                //main 스레드 = UI 스레드가 adapter.notifyDataSetChanged();를 실행시키게 하면 됨.

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });


            }
        }).start();

    }
}