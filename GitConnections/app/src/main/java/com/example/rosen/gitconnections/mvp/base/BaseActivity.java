package com.example.rosen.gitconnections.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;

import com.example.rosen.gitconnections.R;
import com.example.rosen.gitconnections.db.DataBaseHelper;
import com.example.rosen.gitconnections.widgets.DimmedProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rosen on 09.04.17.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    protected T mPresenter;
    protected DataBaseHelper mDataBaseHelper;
    @Nullable
    @BindView(R.id.progress)
    DimmedProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mDataBaseHelper = DataBaseHelper.getInstance();
        initViews();
    }

    public void showLoader(){
        if (progressBar != null)
            progressBar.setVisibility(View.VISIBLE);
    }

    public void hideLoader(){
        if (progressBar != null)
            progressBar.setVisibility(View.GONE);
    }

    protected void openFragment(Fragment fragment, boolean addToBackStack){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.grp_container, fragment);
        if (addToBackStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

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

    public void hideSoftKeyboard() {

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        else {
            getWindow().setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
            );
        }
    }
}
