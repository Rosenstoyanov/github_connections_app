package com.example.rosen.gitconnections.mvp.login.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Toast;

import com.example.rosen.gitconnections.R;
import com.example.rosen.gitconnections.model.User;
import com.example.rosen.gitconnections.model.UserSession;
import com.example.rosen.gitconnections.mvp.base.BaseFragment;
import com.example.rosen.gitconnections.mvp.user_details.UserDetailsActivity;
import com.example.rosen.gitconnections.preference.AppPreferences;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Rosen on 7/2/2017.
 */

public class LoginFragment extends BaseFragment<LoginPresenter> implements LoginContractor.View {

    @BindView(R.id.et_username)
    AppCompatEditText mUsername;

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initViews(View view) {
    }

    @OnClick(R.id.btn_login)
    public void login() {
        mPresenter.attemptUserLogin(mUsername.getText().toString());
    }

    @Override
    public void onLogInSuccess(User user) {
        AppPreferences.setUserSession(new UserSession(user.getUserId(), mUsername.getText().toString()), mActivity);

        Intent intent = new Intent(mActivity, UserDetailsActivity.class);
        startActivity(intent);
        mActivity.finish();
    }

    @Override
    public void onLogInFailure(String s) {
        Toast.makeText(mActivity, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoader() {
        mActivity.showLoader();
    }

    @Override
    public void hideLoader() {
        mActivity.hideLoader();
    }
}
