package com.example.rosen.gitconnections.mvp.base;

/**
 * Created by rosen on 09.04.17.
 */

public abstract class BasePresenter {

    protected boolean mIsActivityRunning = false;

    void onStop(){
        this.mIsActivityRunning = false;
    }

    void onStart(){
        this.mIsActivityRunning = true;
    }
}
