package com.icesong.travelalone.view;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    private final String IMAGE_TYPE = "image/*";

    private final int IMAGE_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .add(R.id.fragment_holder, new ArticleWritten()).commit();

        adapter = new SimpleAdapter(this, getArticleDataList(), R.layout.article_item_list,

                new String[]{"title", "content", "origin", "author", "comment", "pic"},

                new int[]{R.id.article_item_list_title, R.id.article_item_list_detail, R.id.article_item_list_origin,
                        R.id.article_item_list_author, R.id.article_item_list_comments, R.id.imageView});


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
        getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new ArticleDetailRead().newInstance(position)).addToBackStack(null).commit();
    }

    public List<Map<String, Object>> getArticleDataList() {
        return articleDataList;
    }

    public void setArticleDataList(Articles anArticle){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", anArticle.getmArticleName());
        map.put("content", anArticle.getmArticleContent());
        map.put("origin", anArticle.setArticleOrigin());
        map.put("author", anArticle.getmArticleAuthor());
        map.put("comment", anArticle.getmArticleComments().length);
        map.put("img", anArticle.getmArticlePhotos());
        map.put("pic",anArticle.getPath());
        articleDataList.add(map);
    }
}
