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

    public int getmArticleId() {
        return mArticleId;
    }

    public String getmArticleName() {
        return mArticleName;
    }

    public void setmArticleName(String mArticleName) {
        this.mArticleName = mArticleName;
    }

    public String getmArticleAuthor() {
        return mArticleAuthor;
    }

    public void setmArticleAuthor(String mArticleAuthor) {
        this.mArticleAuthor = mArticleAuthor;
    }

    public Date getmArticleData() {
        return mArticleData;
    }

    public void setmArticleData(Date mArticleData) {
        this.mArticleData = mArticleData;
    }

    public String getmArticlePosition() {
        return mArticlePosition;
    }

    public void setmArticlePosition(String mArticlePosition) {
        this.mArticlePosition = mArticlePosition;
    }

    public String getmArticleContent() {
        return mArticleContent;
    }

    public void setmArticleContent(String mArticleContent) {
        this.mArticleContent = mArticleContent;
    }

    public String[] getmArticlephotos() {
        return mArticlephotos;
    }

    public void setmArticlephotos(String[] mArticlephotos) {
        this.mArticlephotos = mArticlephotos;
    }

    public int getmArticleLike() {
        return mArticleLike;
    }

    public void setmArticleLike(int mArticleLike) {
        this.mArticleLike = mArticleLike;
    }

    public int getmArticleDislike() {
        return mArticleDislike;
    }

    public void setmArticleDislike(int mArticleDislike) {
        this.mArticleDislike = mArticleDislike;
    }

    public ArticleComment[] getmArticleComments() {
        return mArticleComments;
    }

    public void setmArticleComments(ArticleComment[] mArticleComments) {
        this.mArticleComments = mArticleComments;
    }

    public void setmArticleId(int mArticleId) {
        this.mArticleId = mArticleId;
    }
}
