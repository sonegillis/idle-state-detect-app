package com.gillis.idleapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    private Handler mHandler;
    private final long TIMEOUT = 2000;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            reactToIdleState();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, TIMEOUT);
        myCustomOnCreate(savedInstanceState);
    }

    protected void myCustomOnCreate(Bundle savedInstanceState) {

    }

    protected void reactToIdleState() {

    }

    protected void myCustomOnClick(View view) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        resetHandler();
        return false;
    }

    @Override
    public void onClick(View view) {
        resetHandler();
        myCustomOnClick(view);
    }

    private void resetHandler() {
        mHandler.removeCallbacks(mRunnable);
        mHandler.postDelayed(mRunnable, TIMEOUT);
    }
}
