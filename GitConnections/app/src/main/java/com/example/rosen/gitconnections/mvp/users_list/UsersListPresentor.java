package com.example.rosen.gitconnections.mvp.users_list;

import com.example.rosen.gitconnections.data.GitConnectionsDataSource;
import com.example.rosen.gitconnections.data.GitConnectionsRepository;
import com.example.rosen.gitconnections.data.local.GitConnectionsLocalDataSource;
import com.example.rosen.gitconnections.data.remote.GitConnectionsRemoteDataSource;
import com.example.rosen.gitconnections.model.FollowersFollowingUsers;
import com.example.rosen.gitconnections.model.UserFollowers;
import com.example.rosen.gitconnections.model.UserFollowing;
import com.example.rosen.gitconnections.mvp.base.BasePresenter;

import java.util.ArrayList;
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
            public void onSuccess(List<UserFollowers> repositories) {
                if (mIsActivityRunning)
                    mView.onUsersListSuccess(converetFollowers(repositories));
            }

            @Override
            public void onError(String error) {
                if (mIsActivityRunning)
                    mView.onUserlistFailure(error);

            }
        });
    }

    private ArrayList<FollowersFollowingUsers> converetFollowing(List<UserFollowing> list){
        ArrayList<FollowersFollowingUsers> result = new ArrayList<>();
        for (UserFollowing following : list){
            result.add(new FollowersFollowingUsers(following.getName(), following.getAvatarUrl()));
        }

        return result;
    }

    private ArrayList<FollowersFollowingUsers> converetFollowers(List<UserFollowers> list){
        ArrayList<FollowersFollowingUsers> result = new ArrayList<>();
        for (UserFollowers following : list){
            result.add(new FollowersFollowingUsers(following.getName(), following.getAvatarUrl()));
        }

        return result;
    }

    @Override
    public void getFollowingList(String username) {
        mRepository.getUserFollowing(username, new GitConnectionsDataSource.UserFollowingCallback() {
            @Override
            public void onSuccess(List<UserFollowing> repositories) {
                if (mIsActivityRunning)
                    mView.onUsersListSuccess(converetFollowing(repositories));
            }

            @Override
            public void onError(String error) {
                if (mIsActivityRunning)
                    mView.onUserlistFailure(error);
            }
        });
    }
}
