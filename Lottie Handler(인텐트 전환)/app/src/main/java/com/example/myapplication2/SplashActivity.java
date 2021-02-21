package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    public Context sContext = SplashActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        final LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.progressAnimationView);

        animationView.playAnimation();
        animationView.addAnimatorListener(new Animator.AnimatorListener(){

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                animationView.setVisibility(View.GONE); // 애니메이션이 완료 된 후에 화면에서 사라지게
                animationView.pauseAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

        });


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =  new Intent(sContext, MainActivity.class);
                startActivity(intent);
            }
        }, 5000);

        //Handler().postDelayed( startActivity(intent), 5500)

    }
}