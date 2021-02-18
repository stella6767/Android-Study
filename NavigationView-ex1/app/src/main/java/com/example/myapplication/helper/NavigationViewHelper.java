package com.example.myapplication.helper;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.SubActivity;
import com.google.android.material.navigation.NavigationView;

public class NavigationViewHelper {

    private static final String TAG = "NavigationViewHelper";

    public static void enable(Context context, NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(item -> { //그래서 인텐트 플래그 방식...
            int id= item.getItemId();

            if(id == R.id.item1){
                Log.d(TAG, "onCreate: 메뉴1 클릭됨");
                //여기서 클릭시 어떤 로직을 작성한다.
                //이 방식의 단점은 액티비티가 스택에 계속 쌓임 finish를 못함(어느 액티비티에서 올지를 모르니까)
                //그래서 인텐트 플래그(Intent Flag) 설정
                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);

            }else if(id==R.id.item2){
                Log.d(TAG, "onCreate: 메뉴2 클릭됨");
                Intent intent = new Intent(context, SubActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
            }else if(id==R.id.item3){
                Log.d(TAG, "onCreate: 메뉴3클릭됨");
            }

            return true; //메뉴가 누르면, 디스플레이에 누른 색칠 표시

        });
    }
}
