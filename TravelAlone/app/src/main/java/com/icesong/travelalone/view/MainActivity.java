package com.icesong.travelalone.view;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.icesong.travelalone.R;
import com.icesong.travelalone.model.Articles;
import com.icesong.travelalone.view.menu.ResideMenu;
import com.icesong.travelalone.view.menu.ResideMenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class MainActivity extends Activity implements ArticleTitleItem.OnFragmentInteractionListener, ArticleWritten.OnFragmentInteractionListener,View.OnClickListener {
    private ResideMenu resideMenu;
    private MainActivity mContext;

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
        mContext = this;

        getFragmentManager().beginTransaction()
                .add(R.id.fragment_holder, new ArticleTitleItem()).commit();

        adapter = new SimpleAdapter(this, getArticleDataList(), R.layout.article_item_list,

                new String[]{"title", "content", "origin", "author", "comment", "pic"},

                new int[]{R.id.article_item_list_title, R.id.article_item_list_detail, R.id.article_item_list_origin,
                        R.id.article_item_list_author, R.id.article_item_list_comments, R.id.imageView});

        setUpMenu();
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

    //setting article title list
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

    //init slide menu and set menu functions
    private void setUpMenu() {
        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.menu_background);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);

        // create menu items;
        String titles[] = { "Write", "Articles", "Coll", "Location", "Map" };
        int icon[] = { R.drawable.icon_write, R.drawable.ican_article, R.drawable.ican_collection, R.drawable.ican_report,R.drawable.ican_map };

        for(int i=0;i<titles.length;i++){
            final int menuFlag = i;
            ResideMenuItem resideMenuItem = new ResideMenuItem(this,icon[i],titles[i]);
            resideMenuItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(menuFlag == 0){
                        resideMenu.closeMenu();
                        getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new ArticleWritten()).addToBackStack(null).commit();
                    }else if(menuFlag == 1){
                        resideMenu.closeMenu();
                        //getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new ArticleWritten()).addToBackStack(null).commit();
                    }else if(menuFlag == 2){
                        resideMenu.closeMenu();
                        //getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new ArticleWritten()).addToBackStack(null).commit();
                    }else if(menuFlag == 3){
                        resideMenu.closeMenu();
                        getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new LocationReport()).addToBackStack(null).commit();
                    }else if(menuFlag == 4){
                        resideMenu.closeMenu();
                        getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new FragmentMap()).addToBackStack(null).commit();
                    }
                    else{
                        resideMenu.closeMenu();
                    }
                }
            });
            resideMenu.addMenuItem(resideMenuItem);
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.onInterceptTouchEvent(ev) || super.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {
        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            //Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            //Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    public ResideMenu getResideMenu(){
        return resideMenu;
    }
}
