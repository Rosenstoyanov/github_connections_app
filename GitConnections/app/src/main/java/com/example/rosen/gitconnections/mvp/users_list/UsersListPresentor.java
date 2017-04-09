package com.example.rosen.gitconnections.mvp.users_list;

import com.example.rosen.gitconnections.data.GitConnectionsDataSource;
import com.example.rosen.gitconnections.data.GitConnectionsRepository;
import com.example.rosen.gitconnections.data.local.GitConnectionsLocalDataSource;
import com.example.rosen.gitconnections.data.remote.GitConnectionsRemoteDataSource;
import com.example.rosen.gitconnections.model.FollowersFollowingUsers;
import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.mvp.base.BasePresenter;

import java.util.List;

/**
 * Created by rosen on 10.04.17.
 */

public class UsersListPresentor extends BasePresenter implements UsersListContractor.Presenter {
    UsersListContractor.View mView;
    GitConnectionsRepository mRepository;

    public UsersListPresentor(UsersListContractor.View mView) {
        this.mView = mView;
        mRepository = GitConnectionsRepository.getInstance(GitConnectionsRemoteDataSource.getInstance(), GitConnectionsLocalDataSource.getInstanse());

    }

    @Override
    public void getFollowersList(String username) {
        mRepository.getUserFollowers(username, new GitConnectionsDataSource.UserFollowersCallback() {
            @Override
            public void onSuccess(List<FollowersFollowingUsers> repositories) {
                if (mIsActivityRunning)
                    mView.onUsersListSuccess(repositories);
            }

            @Override
            public void onError(String error) {
                if (mIsActivityRunning)
                    mView.onUserlistFailure(error);

            }
        });
    }

    @Override
    public void getFollowingList(String username) {
        mRepository.getUserFollowing(username, new GitConnectionsDataSource.UserFollowingCallback() {
            @Override
            public void onSuccess(List<FollowersFollowingUsers> repositories) {
                if (mIsActivityRunning)
                    mView.onUsersListSuccess(repositories);
            }

            @Override
            public void onError(String error) {
                if (mIsActivityRunning)
                    mView.onUserlistFailure(error);
            }
        });
    }
}
