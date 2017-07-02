package com.example.rosen.gitconnections.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by rosen on 09.04.17.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    protected BaseActivity mActivity;
    protected T mPresenter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initViews(view);
        return view;
    }

    public void setPresenter(T presenter){
        mPresenter = presenter;
    }

    public abstract int getLayoutId();

    public abstract void initViews(View view);

    @Override
    public void onStart() {
        super.onStart();
        if (mPresenter != null)
            mPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mPresenter != null)
            mPresenter.onStop();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (BaseActivity) context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mActivity = null;
        mPresenter = null;
        unbinder.unbind();
    }
}
