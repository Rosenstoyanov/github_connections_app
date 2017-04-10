package com.example.rosen.gitconnections.mvp.base;

/**
 * Created by rosen on 09.04.17.
 */

public abstract class BasePresenter {

    protected boolean mIsActivityRunning = false;

    public void onStop(){
        this.mIsActivityRunning = false;
    }

    public void onStart(){
        this.mIsActivityRunning = true;
    }
}
