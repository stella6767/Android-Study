package com.example.myapplication3;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {

    private static final String TAG = "SearchFragment";
    private TextView tvTitle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Context context = container.getContext();
        MainActivity at = (MainActivity) context; //이런 식으로 데이터를 전달받을 수 있다.
        at.num = 1;
        Log.d(TAG, "onCreateView: "+at.num);

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        tvTitle = view.findViewById(R.id.tv_title);
        tvTitle.setText("Fragment Search");

        return view;
    }
}
