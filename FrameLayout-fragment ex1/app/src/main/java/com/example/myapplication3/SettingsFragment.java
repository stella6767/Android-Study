package com.example.myapplication3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    private static final String TAG = "SettingsFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity at = (MainActivity) container.getContext();

        Log.d(TAG, "onCreateView: " + at.num);//컨텍스트를 공유함으로서 프레그먼트끼리 데이터를 공유하고 사용할수 있다.

        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        return view;
    }
}
