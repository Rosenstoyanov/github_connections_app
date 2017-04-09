package com.example.rosen.gitconnections.mvp.base;

/**
 * Created by rosen on 09.04.17.
 */

public abstract class BasePresenter {

    protected boolean mIsActivityRunning = false;

    public void onPause(){
        this.mIsActivityRunning = false;
    }

    public void onResume(){
        this.mIsActivityRunning = true;
    }
}
