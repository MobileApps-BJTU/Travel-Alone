package com.icesong.travelalone.view;


import android.app.Fragment;
import android.content.Context;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.icesong.travelalone.R;

/**
 * Created by Felix on 2015/3/30.
 */

public class FragmentMap extends Fragment {
    Context context;

    public FragmentMap() {

    }

    @SuppressLint("ValidFragment")
    public FragmentMap(Context location){
        context = location;
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_map, container, false);
        ImageView image1 =  (ImageView)view.findViewById(R.id.map_back);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .add(R.id.fragment_holder, new ArticleTitleItem()).commit();
            }
        });

        return view;
    }


}