package com.example.googlemapapp;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/**
 * desc:
 * author: zouhecan {zouhecan@gmail.com}
 * date: 2020/4/28
 */
public class TestFragment4 extends Fragment {
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_2, container, false);
        ((TextView) view.findViewById(R.id.content)).setText(type);
        view.setBackgroundColor(Color.parseColor("#33da33"));
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("cookie");
        arrayList.add("modify");
        arrayList.add("sync");
        Log.d("zouhecan", arrayList.toString());
//        FragmentTest1Binding binding = FragmentTest1Binding.inflate(getLayoutInflater());
//        binding.content.setText(index);
    }
}
