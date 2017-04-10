package com.example.rosen.gitconnections.data;

import com.example.rosen.gitconnections.db.DataBaseHelper;
import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.model.User;
import com.example.rosen.gitconnections.model.UserFollowers;
import com.example.rosen.gitconnections.model.UserFollowing;

import java.util.List;

/**
 * Created by rosen on 09.04.17.
 */

public class GitConnectionsRepository implements GitConnectionsDataSource {
    private static GitConnectionsRepository instance;

    private final GitConnectionsDataSource mRemoteDataSource;
    private final GitConnectionsDataSource mLocalDataSource;

    private GitConnectionsRepository(GitConnectionsDataSource remoteDataSource, GitConnectionsDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static GitConnectionsRepository getInstance(GitConnectionsDataSource remoteDataSource,
                                                       GitConnectionsDataSource localDataSource) {
        if (instance == null) {
            instance = new GitConnectionsRepository(remoteDataSource, localDataSource);
        }
        return instance;
    }


    @Override
    public void getUserProfile(final String userName, final ProfileCallback profileCallback) {
        mRemoteDataSource.getUserProfile(userName, new ProfileCallback() {
            @Override
            public void onSuccess(User user) {
                user.setUserName(userName);
                DataBaseHelper.getInstance().insertOrReplaceUser(user);
                mLocalDataSource.getUserProfile(userName, profileCallback);
            }

            @Override
            public void onError(String error) {
                mLocalDataSource.getUserProfile(userName, profileCallback);
//                profileCallback.onError(error);
            }
        });
    }

    @Override
    public void getUserRepositories(final String userName, final UserRepositoriesCallback callback) {

        mRemoteDataSource.getUserRepositories(userName, new UserRepositoriesCallback() {
            @Override
            public void onSuccess(List<RepositoryDetails> repositories) {
                DataBaseHelper.getInstance().saveUserRepos(userName, repositories);
                mLocalDataSource.getUserRepositories(userName, callback);
            }

            @Override
            public void onError(String error) {
                mLocalDataSource.getUserRepositories(userName, callback);
//                callback.onError(error);
            }
        });
    }

    @Override
    public void getUserFollowers(final String userName, final UserFollowersCallback callback) {
        mRemoteDataSource.getUserFollowers(userName, new UserFollowersCallback() {
            @Override
            public void onSuccess(List<UserFollowers> repositories) {
                DataBaseHelper.getInstance().saveUserFollowers(userName, repositories);
                mLocalDataSource.getUserFollowers(userName, callback);
            }

            @Override
            public void onError(String error) {
                mLocalDataSource.getUserFollowers(userName, callback);
            }
        });
    }

    @Override
    public void getUserFollowing(final String userName, final UserFollowingCallback callback) {
        mRemoteDataSource.getUserFollowing(userName, new UserFollowingCallback() {
            @Override
            public void onSuccess(List<UserFollowing> repositories) {
                DataBaseHelper.getInstance().saveUserFollowing(userName, repositories);
                mLocalDataSource.getUserFollowing(userName, callback);
            }

            @Override
            public void onError(String error) {
                mLocalDataSource.getUserFollowing(userName, callback);
            }
        });
    }
}
