package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    
    private MyFragMentPagerAdapter myFragMentPagerAdapter;
    private ViewPager vpContainer;
    private TabLayout tabs;

    private LinearLayout totalLayout;

    DisplayMetrics metrics = new DisplayMetrics();

    
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalLayout = findViewById(R.id.total_layout);
        Log.d(TAG, "onCreate: "+totalLayout.getWidth());

        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        int width_px = Resources.getSystem().getDisplayMetrics().widthPixels;
        int pixeldpi = Resources.getSystem().getDisplayMetrics().densityDpi;

        Log.d("ApplicationTagName", "Display width in px is " + width_px);

        float density = getBaseContext().getResources().getDisplayMetrics().density;
        int dpWidth  = (int)((float)width_px/density);

        Log.i( " DP(Width) "  , dpWidth  + "dp" );



        vpContainer = findViewById(R.id.vp_container);
        tabs = findViewById(R.id.tabs);

        myFragMentPagerAdapter = new MyFragMentPagerAdapter(getSupportFragmentManager(),1);

        myFragMentPagerAdapter.addFragment(new Frag1());
        myFragMentPagerAdapter.addFragment(new Frag2());

        vpContainer.setAdapter(myFragMentPagerAdapter);

        //tab이랑 연결되어야 함.
        tabs.setupWithViewPager(vpContainer);
        //tab에 아이템 그리기
        tabs.getTabAt(0).setIcon(R.drawable.ic_apps);
        tabs.getTabAt(0).setCustomView(R.layout.tab_image);
        tabs.getTabAt(1).setIcon(R.drawable.ic_monitor);
        tabs.getTabAt(1).setCustomView(R.layout.tab_image);

    }
}