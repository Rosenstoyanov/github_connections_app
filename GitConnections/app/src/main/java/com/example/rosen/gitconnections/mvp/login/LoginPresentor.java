package com.example.rosen.gitconnections.mvp.login;

import com.example.rosen.gitconnections.data.GitConnectionsDataSource;
import com.example.rosen.gitconnections.data.GitConnectionsRepository;
import com.example.rosen.gitconnections.data.local.GitConnectionsLocalDataSource;
import com.example.rosen.gitconnections.data.remote.GitConnectionsRemoteDataSource;
import com.example.rosen.gitconnections.model.User;
import com.example.rosen.gitconnections.mvp.base.BasePresenter;

/**
 * Created by rosen on 09.04.17.
 */

public class LoginPresentor extends BasePresenter implements LoginContractor.Presenter {
    private LoginContractor.View mView;
    private GitConnectionsRepository mRepository;

    public LoginPresentor(LoginContractor.View mView) {
        this.mView = mView;
        mRepository = GitConnectionsRepository.getInstance(GitConnectionsRemoteDataSource.getInstance(), GitConnectionsLocalDataSource.getInstanse());
    }

    @Override
    public void attemptUserLogin(String username) {
        mRepository.login(username, new GitConnectionsDataSource.LoginCallback() {
            @Override
            public void onLoginSuccess(User user) {
                if (mIsActivityRunning)
                    mView.onLogInSuccess(user);
            }

            @Override
            public void onLoginError(String error) {
                if (mIsActivityRunning)
                    mView.onLogInFailure(error);
            }
        });
    }
}
