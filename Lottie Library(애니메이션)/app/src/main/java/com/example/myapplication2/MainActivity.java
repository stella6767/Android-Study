package com.example.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.animation.Animator;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

import static android.animation.Animator.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.progressAnimationView);
//        animationView.playAnimation();
//        animationView.setAnimation("data.json");
//        animationView.loop(true);
//        animationView.playAnimation();



        final LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.progressAnimationView);

        animationView.loop(true);
        animationView.playAnimation();

        animationView.addAnimatorListener(new Animator.AnimatorListener(){

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
               // animationView.setVisibility(View.GONE); // 애니메이션이 완료 된 후에 화면에서 사라지게
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }




}