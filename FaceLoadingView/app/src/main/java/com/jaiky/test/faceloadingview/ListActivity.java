package com.jaiky.test.faceloadingview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    TextView mTextView;
    FaceLoadingView mFaceLoadingView;
    boolean isFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mFaceLoadingView = (FaceLoadingView) findViewById(R.id.faceView);
        mTextView = (TextView) findViewById(R.id.mTextView);
        mTextView.setVisibility(View.GONE);

        isFail = getIntent().getBooleanExtra("isFail", false);

        //Simulate get data
        if (isFail) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mFaceLoadingView.setFailed();
                }
            }, 5000);
        }
        else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mFaceLoadingView.hiddenView();
                    mTextView.setVisibility(View.VISIBLE);
                }
            }, 5000);
        }


    }




}
