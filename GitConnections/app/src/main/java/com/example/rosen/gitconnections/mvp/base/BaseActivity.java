package com.example.rosen.gitconnections.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.rosen.gitconnections.db.DataBaseHelper;

import butterknife.ButterKnife;

/**
 * Created by rosen on 09.04.17.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected T mPresenter;
    protected DataBaseHelper mDataBaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mDataBaseHelper = DataBaseHelper.getInstance();
        initViews();
    }

    protected abstract int getLayoutId();

    protected abstract void initViews();

    @Override
    protected void onStart() {
        super.onStart();
        if (mPresenter != null)
            mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPresenter != null)
            mPresenter.onStop();
    }

//    private boolean checkAuthenticated() {
//        if (!(this instanceof LoginActivity)) {
//            // check if getUserSession
//            if (!mApplication.isAuthenticated()) {
//                Intent intent = new Intent(BaseActivity.this, mApplication.getLoginClass());
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                finish();
//                return false;
//            }
//        }
//        return true;
//    }
}
