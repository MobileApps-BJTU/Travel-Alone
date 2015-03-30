package com.icesong.travelalone.view;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.icesong.travelalone.R;
import com.icesong.travelalone.model.Articles;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ArticleWritten.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ArticleWritten extends Fragment {

    private OnFragmentInteractionListener mListener;
    MainActivity mainActivity;
    Articles newArticle = new Articles();

    public ArticleWritten() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_article_written, container, false);
        View articleWritingView = inflater.inflate(R.layout.fragment_article_written, container, false);
        mainActivity = (MainActivity)getActivity();

        final ImageView saveImageView = (ImageView)articleWritingView.findViewById(R.id.writingArticleSave);
        ImageView addPhotoImageView = (ImageView)articleWritingView.findViewById(R.id.writingArticleAddPhotos);
        final EditText articleTitleEditText = (EditText)articleWritingView.findViewById(R.id.writingArticleTitle);
        final EditText articleContentEditText = (EditText)articleWritingView.findViewById(R.id.writingArticleContent);

        saveImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImageView.setAlpha(100);
                if(articleTitleEditText.getText() == null){
                    Toast.makeText(getActivity(), "Please Input Article Title",
                            Toast.LENGTH_SHORT).show();
                    saveImageView.setAlpha(255);
                }else if(articleContentEditText.getText() == null){
                    Toast.makeText(getActivity(), "Please Input Article Content",
                            Toast.LENGTH_SHORT).show();
                    saveImageView.setAlpha(255);
                }else{
                    newArticle.setmArticleName(articleTitleEditText.getText().toString());
                    newArticle.setmArticleContent(articleContentEditText.getText().toString());
                    mainActivity.setArticleDataList(newArticle);
                    getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new ArticleTitleItem()).addToBackStack(null).commit();
                }
            }
        });
        return articleWritingView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
