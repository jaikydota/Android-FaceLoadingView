package com.jaiky.test.faceloadingview;


import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Loading Faceview
 * @author Jaiky
 * @date Jul 4, 2016
 * PS: Not easy to write code, please indicate.
 */
public class FaceImageView extends ImageView{

    private AnimationDrawable loadingDrawable;

    private AnimationDrawable failedDrawable;

    public FaceImageView(Context context) {
        super(context);
        init();
    }

    public FaceImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FaceImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        setImageResource(R.drawable.face_progressbar_default);
        loadingDrawable = (AnimationDrawable) getDrawable();
        failedDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.face_progressbar_failed);
        loadingDrawable.start();
    }

    /**
     * 设置载入失败
     */
    public void setFailed() {
        setImageDrawable(failedDrawable);
        failedDrawable.start();
    }

    /**
     * 设置正在载入
     */
    public void setloading() {
        setImageDrawable(loadingDrawable);
        loadingDrawable.start();
    }

    public void startAnimation(){
        AnimationDrawable anim = (AnimationDrawable) getDrawable();
        anim.start();
    }

    public void stopAnimation(){
        AnimationDrawable anim = (AnimationDrawable) getDrawable();
        //停留在第一针
        anim.setVisible(true, true);
        anim.stop();
    }

    public void pauseAnimation(){
        AnimationDrawable anim = (AnimationDrawable) getDrawable();
        anim.stop();
    }

}

