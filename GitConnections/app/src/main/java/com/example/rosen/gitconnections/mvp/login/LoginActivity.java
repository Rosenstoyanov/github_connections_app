package com.example.rosen.gitconnections.mvp.login;

import android.content.Intent;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Toast;

import com.example.rosen.gitconnections.R;
import com.example.rosen.gitconnections.model.User;
import com.example.rosen.gitconnections.model.UserSession;
import com.example.rosen.gitconnections.mvp.base.BaseActivity;
import com.example.rosen.gitconnections.mvp.user_details.UserDetailsActivity;
import com.example.rosen.gitconnections.preference.AppPreferences;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresentor> implements LoginContractor.View {

    @BindView(R.id.et_username)
    AppCompatEditText mUsername;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        mPresenter = new LoginPresentor(this);
    }

    @OnClick(R.id.btn_login)
    public void login() {
        mPresenter.attemptUserLogin(mUsername.getText().toString());
    }

    @Override
    public void onLogInSuccess(User user) {
        AppPreferences.setUserSession(new UserSession(user.getUserId(), mUsername.getText().toString()), this);

        Intent intent = new Intent(this, UserDetailsActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLogInFailure(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
