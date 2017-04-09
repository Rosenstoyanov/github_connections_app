package com.example.rosen.gitconnections.data;

import com.example.rosen.gitconnections.application.App;
import com.example.rosen.gitconnections.data.local.GitConnectionsLocalDataSource;
import com.example.rosen.gitconnections.data.remote.GitConnectionsRemoteDataSource;

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
    public void login(String userName, LoginCallback loginCallback) {
        mRemoteDataSource.login(userName, loginCallback);
    }

    @Override
    public void getUserRepositories(String userName, UserRepositoriesCallback callback) {
        mRemoteDataSource.getUserRepositories(userName, callback);
    }
}
