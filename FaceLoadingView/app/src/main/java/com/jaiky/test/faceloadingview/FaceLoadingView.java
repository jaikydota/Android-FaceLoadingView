package com.jaiky.test.faceloadingview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Loading Faceview
 * @author Jaiky
 * @date Jul 4, 2016
 * PS: Not easy to write code, please indicate.
 */
public class FaceLoadingView extends FrameLayout{

    private TextView tvInfo;
    private FaceImageView faceView;

    public FaceLoadingView(Context context) {
        super(context);
        init(context);
    }

    public FaceLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FaceLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context){
        //设置动画视图
        faceView = new FaceImageView(context);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        //int widthHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 220, dm);
        LayoutParams faceLayout = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        faceLayout.gravity = Gravity.CENTER;
        faceView.setLayoutParams(faceLayout);

        //设置显示文本
        tvInfo = new TextView(context);
        LayoutParams tvLayout = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        tvLayout.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        tvLayout.bottomMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, dm);
        tvLayout.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, dm);
        tvInfo.setLayoutParams(tvLayout);
        tvInfo.setText("努力加载中...");
        tvInfo.setTextColor(Color.parseColor("#757575"));
        tvInfo.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);

        //添加到布局
        addView(faceView);
        addView(tvInfo);
    }


    public void setFailed() {
        setVisibility(View.VISIBLE);
        faceView.setFailed();
        tvInfo.setText("载入失败，请刷新尝试...");
    }

    public void setFailedWithMsg(String msg) {
        setVisibility(View.VISIBLE);
        faceView.setFailed();
        tvInfo.setText(msg);
    }


    public void setloading() {
        setVisibility(View.VISIBLE);
        faceView.setloading();
        tvInfo.setText("努力加载中...");
    }

    public void setloadingWithMsg(String msg) {
        setVisibility(View.VISIBLE);
        faceView.setloading();
        tvInfo.setText(msg);
    }


    /**
     * 隐藏视图
     */
    public void hiddenView(){
        setVisibility(View.GONE);
    }

    /**
     * 显示视图
     */
    public void show(){
        setVisibility(View.VISIBLE);
    }

    /**
     * 设置加载消息内容
     *
     * @param msg
     */
    public void setMsg(String msg) {
        tvInfo.setText(msg);
    }



}
