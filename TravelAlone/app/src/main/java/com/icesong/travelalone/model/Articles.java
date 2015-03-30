package com.icesong.travelalone.model;

import org.w3c.dom.Text;

import java.util.Date;

/**
 * Created by 12301103 SongLiu(刘嵩) on 3/29.
 */
public class Articles {
    private int mArticleId;     //article NO.
    private String mArticleName;//article name
    private String mArticleAuthor;//article author
    private Date mArticleData; //article written data
    private String mArticlePosition;//article written position
    private String mArticleContent;//'article content
    private String[] mArticlephotos; //photos used in article
    private int mArticleLike; //number of people who like this article
    private int mArticleDislike; //number of people who dislike this article
    private ArticleComment[] mArticleComments;  //the comments of this article

    public int getArticleId(){
        return mArticleId;
    }

    public String getArticleName(){
        return mArticleName;
    }

    public String getArticleAuthor(){
        return mArticleAuthor;
    }

    public Date getArticleData(){
        return mArticleData;
    }

    public String getArticlePosition(){
        return mArticlePosition;
    }

    public String getArticleContent(){
        return mArticleContent;
    }

    public void setArticleContent(String name){
        mArticleName = name;
    }

    public void setArticleTitle(String name){
        mArticleName = name;
    }
}
