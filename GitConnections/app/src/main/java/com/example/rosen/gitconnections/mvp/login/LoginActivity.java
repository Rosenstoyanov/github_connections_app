package com.example.rosen.gitconnections.mvp.login;

import com.example.rosen.gitconnections.R;
import com.example.rosen.gitconnections.data.GitConnectionsRepository;
import com.example.rosen.gitconnections.data.local.GitConnectionsLocalDataSource;
import com.example.rosen.gitconnections.data.remote.GitConnectionsRemoteDataSource;
import com.example.rosen.gitconnections.mvp.base.BaseActivity;
import com.example.rosen.gitconnections.mvp.login.login.LoginFragment;
import com.example.rosen.gitconnections.mvp.login.login.LoginPresenter;

public class LoginActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initViews() {
        LoginFragment loginFragment = LoginFragment.newInstance();
        loginFragment.setPresenter(new LoginPresenter(loginFragment,
                GitConnectionsRepository
                        .getInstance(
                                GitConnectionsRemoteDataSource.getInstance(),
                                GitConnectionsLocalDataSource.getInstanse())));
        openFragment(loginFragment, false);
    }
}
