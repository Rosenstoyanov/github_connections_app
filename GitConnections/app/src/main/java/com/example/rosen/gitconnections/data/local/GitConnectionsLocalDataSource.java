package com.example.rosen.gitconnections.data.local;

import com.example.rosen.gitconnections.data.GitConnectionsDataSource;
import com.example.rosen.gitconnections.db.DataBaseHelper;
import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.utils.Utils;

import java.util.List;

/**
 * Created by rosen Roseon 09.04.17.
 */

public class GitConnectionsLocalDataSource implements GitConnectionsDataSource {
    private static GitConnectionsLocalDataSource instanse;
    private DataBaseHelper dataBaseHelper;

    public static GitConnectionsLocalDataSource getInstanse(){
        if (instanse == null)
            instanse = new GitConnectionsLocalDataSource();
        return instanse;
    }

    private GitConnectionsLocalDataSource() {
        dataBaseHelper = DataBaseHelper.getInstance();
    }

    @Override
    public void getUserProfile(String userName, ProfileCallback profileCallback) {
        profileCallback.onSuccess(DataBaseHelper.getInstance().getUser(userName));
    }

    @Override
    public void getUserRepositories(String userName, UserRepositoriesCallback callback) {
        //// TODO: crate query with descending criteria
        List<RepositoryDetails> list = dataBaseHelper.getUser(userName).getRepositoryDetails();
        Utils.sortRepos(list);
        callback.onSuccess(list);
    }

    @Override
    public void getUserFollowers(String userName, UserFollowersCallback callback) {
        callback.onSuccess(dataBaseHelper.getUser(userName).getFollowerses());
    }

    @Override
    public void getUserFollowing(String userName, UserFollowingCallback callback) {
        callback.onSuccess(dataBaseHelper.getUser(userName).getFollowings());
    }
}
