package com.icesong.travelalone.model;

import android.graphics.Bitmap;
import android.net.Uri;

import com.icesong.travelalone.R;

import org.w3c.dom.Text;

import java.net.URI;
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
    private String mArticlePhotos; //photos used in article
    private int mArticleLike; //number of people who like this article
    private int mArticleDislike; //number of people who dislike this article
    private ArticleComment[] mArticleComments;  //the comments of this article
    private  String mArticleOrigin;
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    private Bitmap bitmap;

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    private Uri uri;


    public Articles(){
        mArticleId = 1;
        mArticleName = "new Article";
        mArticleAuthor = "SongLiu";
        mArticleContent = "hi, i'm SongLiu!";
        mArticleData = new Date(System.currentTimeMillis());
        mArticleLike = 245;
        mArticleDislike = 123;
        mArticlePhotos = "R.";
        mArticlePosition = "Beijing";
        mArticleComments = new ArticleComment[0];
        mArticleOrigin = "Travel alone";

    }

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

    public String setArticleOrigin(){
        return mArticleOrigin;
    }
    public void setArticleOrigin(String origin){
        mArticleOrigin = origin;
    }

    public String getmArticlePhotos(){
        return mArticlePhotos;
    }
    public void setmArticlePhotos(String photourl){
        mArticlePhotos = photourl;
    }
}
