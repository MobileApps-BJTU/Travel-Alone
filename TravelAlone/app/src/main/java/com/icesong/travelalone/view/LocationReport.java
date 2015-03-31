package com.icesong.travelalone.view;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icesong.travelalone.R;


/**
 * Created by Felix on 2015/3/30.
 */
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;


public class LocationReport extends Fragment {
    Context context;
    public LocationReport(){

    };
    @SuppressLint("ValidFragment")
    public LocationReport(Context location){
        context = location;
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_location_report, container, false);
        ImageView image1 =  (ImageView)view.findViewById(R.id.location_back);
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
