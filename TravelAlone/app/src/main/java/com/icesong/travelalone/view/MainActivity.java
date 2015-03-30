package com.icesong.travelalone.view;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.icesong.travelalone.R;
import com.icesong.travelalone.model.Articles;

import java.util.Stack;


public class MainActivity extends Activity implements ArticleTitleItem.OnFragmentInteractionListener, ArticleWritten.OnFragmentInteractionListener{

    Stack<Articles> articleStack;
    ArrayAdapter<Articles> articlesArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .add(R.id.fragment_holder, new ArticleTitleItem()).commit();

        articleStack = new Stack<Articles>();
        articlesArrayAdapter = new ArrayAdapter<Articles>(
                this, R.layout.article_item_list,R.id.article_item_list_title,articleStack
        );

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
        String d = "d";
        String a = "d";
        //getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new ArticleDetailRead().newInstance(d,a)).addToBackStack(null).commit();
        getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new ArticleWritten()).addToBackStack(null).commit();
    }
}
