package com.icesong.travelalone.view;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;

import com.icesong.travelalone.R;
import com.icesong.travelalone.model.Articles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class MainActivity extends Activity implements ArticleTitleItem.OnFragmentInteractionListener, ArticleWritten.OnFragmentInteractionListener {

    private SimpleAdapter adapter;
    List<Map<String, Object>> articleDataList = new ArrayList<Map<String, Object>>();

    public SimpleAdapter getAdapter() {
        return adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .add(R.id.fragment_holder, new ArticleTitleItem()).commit();

        adapter = new SimpleAdapter(this, getArticleDataList(), R.layout.article_item_list,

                new String[]{"title", "content", "origin", "author", "comment", "img"},

                new int[]{R.id.article_item_list_title, R.id.article_item_list_detail, R.id.article_item_list_origin,
                        R.id.article_item_list_author, R.id.article_item_list_comments, R.id.imageView});

        articleDataList = new ArrayList<Map<String, Object>>();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void OpenArticleDetailRead(int position) {
        //getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new ArticleDetailRead().newInstance(d,a)).addToBackStack(null).commit();
        getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new ArticleWritten()).addToBackStack(null).commit();
    }

    public List<Map<String, Object>> getArticleDataList() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "article1");
        map.put("content", "content1");
        map.put("origin", "origin1");
        map.put("author", "author1");
        map.put("comment", "comment1");
        map.put("img", R.drawable.abc_btn_check_to_on_mtrl_000);
        articleDataList.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "article2");
        map.put("content", "content2");
        map.put("origin", "origin2");
        map.put("author", "author2");
        map.put("comment", "comment2");
        map.put("img", R.drawable.abc_btn_radio_material);
        articleDataList.add(map);

        map = new HashMap<String, Object>();
        map.put("title", "article3");
        map.put("content", "content3");
        map.put("origin", "origin3");
        map.put("author", "author3");
        map.put("comment", "comment3");
        map.put("img", R.drawable.abc_btn_check_to_on_mtrl_015);
        articleDataList.add(map);

        return articleDataList;
    }

    public void setArticleDataList(Articles anArticle){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "articl23131e1");
        map.put("content", "cont121313ent1");
        map.put("origin", "origin1");
        map.put("author", "author1");
        map.put("comment", "comment1");
        map.put("img", R.drawable.abc_btn_check_to_on_mtrl_000);

        articleDataList.add(map);
    }
}
