package com.example.rosen.gitconnections.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.rosen.gitconnections.mvp.login.LoginActivity;
import com.example.rosen.gitconnections.mvp.login.LoginContractor;

/**
 * Created by rosen on 09.04.17.
 */

public class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter != null)
            mPresenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null)
            mPresenter.onResume();
    }

//    private boolean checkAuthenticated() {
//        if (!(this instanceof LoginActivity)) {
//            // check if login
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
