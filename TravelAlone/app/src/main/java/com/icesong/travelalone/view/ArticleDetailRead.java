package com.icesong.travelalone.view;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icesong.travelalone.R;

import org.w3c.dom.Text;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArticleDetailRead#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticleDetailRead extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "number";

    // TODO: Rename and change types of parameters
    private int number;
    private MainActivity mainActivity;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment ArticleDetailRead.
     */
    // TODO: Rename and change types and number of parameters
    public static ArticleDetailRead newInstance(int number) {
        ArticleDetailRead fragment = new ArticleDetailRead();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, number);
        fragment.setArguments(args);
        return fragment;
    }

    public ArticleDetailRead() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            number = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_article_detail_read, container, false);
        mainActivity = (MainActivity)getActivity();
        List<Map<String, Object>> list = mainActivity.getArticleDataList();
        TextView readTitle = (TextView)view.findViewById(R.id.read_title);
        TextView readContext = (TextView)view.findViewById(R.id.read_context);
        ImageView readImage = (ImageView)view.findViewById(R.id.read_image);
        Map map = (Map)list.get(number);

        Object object = map.get("title");
        readTitle.setText((String)object);

        Object object1 = map.get("content");
        readContext.setText((String)object1);

//        Object object2 = map.get("img");
//        readImage.setImageResource((int)object2);
        return view;
    }


}
