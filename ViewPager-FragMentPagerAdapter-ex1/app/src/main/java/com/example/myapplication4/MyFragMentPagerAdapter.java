package com.example.myapplication4;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * PagerAdapter는 양옆에 page를 미리 띄워둠
 * FragmentPagerAdapter는 한 번 뜬 객체는 지우지 않음
 * FragmentPagerStateAdapter는 화면에서 보이지 않으면 날림.
 */


public class MyFragMentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();

    public MyFragMentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public void addFragment(Fragment fragment){
        mFragments.add(fragment);
    }

    public void addFragments(List<Fragment> fragments){
        this.mFragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
