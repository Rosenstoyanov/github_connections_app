package com.example.rosen.gitconnections.data;

import android.app.Application;

import com.example.rosen.gitconnections.application.App;

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
    public void getUserProfile(String userName, ProfileCallback profileCallback) {
        mRemoteDataSource.getUserProfile(userName, profileCallback);
    }

    @Override
    public void getUserRepositories(String userName, UserRepositoriesCallback callback) {
        mRemoteDataSource.getUserRepositories(userName, callback);
    }

    @Override
    public void getUserFollowers(String userName, UserFollowersCallback callback) {
        mRemoteDataSource.getUserFollowers(userName, callback);
    }

    @Override
    public void getUserFollowing(String userName, UserFollowingCallback callback) {
        mRemoteDataSource.getUserFollowing(userName, callback);
    }
}
