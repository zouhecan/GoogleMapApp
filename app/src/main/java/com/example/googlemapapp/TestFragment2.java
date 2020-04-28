package com.example.googlemapapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * desc:
 * author: zouhecan {zouhecan@gmail.com}
 * date: 2020/4/28
 */
public class TestFragment2 extends Fragment {
    private String index;

    public TestFragment2(String index) {
        this.index = index;
    }

    public TestFragment2() {
        Log.d("zouhecan", "TestFragment2 no param constructor");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_1, container, false);
        ((TextView) view.findViewById(R.id.content)).setText(index);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        FragmentTest1Binding binding = FragmentTest1Binding.inflate(getLayoutInflater());
//        binding.content.setText(index);
    }
}
