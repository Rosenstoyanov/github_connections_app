package com.example.rosen.gitconnections.mvp.login.login;

import com.example.rosen.gitconnections.data.GitConnectionsDataSource;
import com.example.rosen.gitconnections.data.GitConnectionsRepository;
import com.example.rosen.gitconnections.data.local.GitConnectionsLocalDataSource;
import com.example.rosen.gitconnections.data.remote.GitConnectionsRemoteDataSource;
import com.example.rosen.gitconnections.model.User;
import com.example.rosen.gitconnections.mvp.base.BasePresenter;

import static com.example.rosen.gitconnections.R.string.username;

/**
 * Created by rosen on 09.04.17.
 */

public class LoginPresenter extends BasePresenter implements LoginContractor.Presenter {
    private LoginContractor.View mView;
    private GitConnectionsRepository mRepository;

    public LoginPresenter(LoginContractor.View mView, GitConnectionsRepository repository) {
        this.mView = mView;
        mRepository = repository;
    }

    @Override
    public void attemptUserLogin(String username) {
        mView.showLoader();

        mRepository.getUserProfile(username, new GitConnectionsDataSource.ProfileCallback() {
            @Override
            public void onSuccess(User user) {
                if (mIsActivityRunning) {
                    mView.onLogInSuccess(user);
                    mView.hideLoader();
                }
            }

            @Override
            public void onError(String error) {
                if (mIsActivityRunning) {
                    mView.onLogInFailure(error);
                    mView.hideLoader();
                }
            }
        });
    }
}
