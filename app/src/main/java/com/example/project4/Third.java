package com.example.project4;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Third extends Fragment {

    public  List<String> List = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<String> listStr = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listStr.add(new String("第" + String.valueOf(i + 1) + "項"));
        }
        List = listStr;
        Log.d("qq", String.valueOf(List));


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third, container, false);


        RecyclerView mrecyclerView = v.findViewById(R.id.recyclerView);

        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //mrecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        //mrecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

        ViewAdapter adapter = new ViewAdapter(getActivity(), List);

        mrecyclerView.setAdapter(adapter);

        return v;
    }

}