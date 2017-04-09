package com.example.rosen.gitconnections.mvp.user_details;

import com.example.rosen.gitconnections.data.GitConnectionsDataSource;
import com.example.rosen.gitconnections.data.GitConnectionsRepository;
import com.example.rosen.gitconnections.data.local.GitConnectionsLocalDataSource;
import com.example.rosen.gitconnections.data.remote.GitConnectionsRemoteDataSource;
import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.mvp.base.BasePresenter;
import com.example.rosen.gitconnections.mvp.login.LoginContractor;

import java.util.List;

/**
 * Created by rosen on 09.04.17.
 */

public class UserDetailsPresenter extends BasePresenter implements UserDetailsContractor.Presenter {
    private UserDetailsContractor.View mView;
    private GitConnectionsRepository mRepository;

    public UserDetailsPresenter(UserDetailsContractor.View mView) {
        this.mView = mView;
        mRepository = GitConnectionsRepository.getInstance(GitConnectionsRemoteDataSource.getInstance(), GitConnectionsLocalDataSource.getInstanse());
    }

    @Override
    public void getUserRepositories(String username) {
        mRepository.getUserRepositories(username, new GitConnectionsDataSource.UserRepositoriesCallback() {
            @Override
            public void onSuccess(List<RepositoryDetails> repositories) {
                if (mIsActivityRunning)
                    mView.onRepositoryDetailsSuccess(repositories);
            }

            @Override
            public void onError(String error) {
                if (mIsActivityRunning)
                    mView.onRepositoryDetailsFailure(error);
            }
        });
    }
}
