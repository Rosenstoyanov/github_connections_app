package com.example.rosen.gitconnections.data.remote;

import com.example.rosen.gitconnections.data.GitConnectionsDataSource;
import com.example.rosen.gitconnections.data.remote.service.GitConnectionsService;
import com.example.rosen.gitconnections.data.remote.service.RestClient;
import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.model.User;
import com.example.rosen.gitconnections.model.UserFollowers;
import com.example.rosen.gitconnections.model.UserFollowing;
import com.example.rosen.gitconnections.utils.Utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rosen on 09.04.17.
 */

public class GitConnectionsRemoteDataSource implements GitConnectionsDataSource {
    private GitConnectionsService mGitConnectionsService;
    private static GitConnectionsRemoteDataSource instance;

    private GitConnectionsRemoteDataSource() {
        mGitConnectionsService =  RestClient.getApiService();
    }

    public static GitConnectionsRemoteDataSource getInstance() {
        if (instance == null) {
            instance = new GitConnectionsRemoteDataSource();
        }
        return instance;
    }


    @Override
    public void getUserProfile(final String userName, final ProfileCallback profileCallback) {
        mGitConnectionsService.getUserProfile(userName).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()){
                    profileCallback.onSuccess(response.body());
                } else
                    profileCallback.onError(Utils.parseError(response).getError());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
//                profileCallback.onError("Something went");
                profileCallback.onError("");
            }
        });
    }

    @Override
    public void getUserRepositories(final String userName, final UserRepositoriesCallback callback) {
        mGitConnectionsService.getUserRepositoies(userName).enqueue(new Callback<List<RepositoryDetails>>() {
            @Override
            public void onResponse(Call<List<RepositoryDetails>> call, Response<List<RepositoryDetails>> response) {
                if (response.isSuccessful()){
                    callback.onSuccess(response.body());
                } else
                    callback.onError(Utils.parseError(response).getError());
            }

            @Override
            public void onFailure(Call<List<RepositoryDetails>> call, Throwable t) {
                callback.onError("Something went");
            }
        });
    }

    @Override
    public void getUserFollowers(final String userName, final UserFollowersCallback callback) {
        mGitConnectionsService.getUserFollowers(userName).enqueue(new Callback<List<UserFollowers>>() {
            @Override
            public void onResponse(Call<List<UserFollowers>> call, Response<List<UserFollowers>> response) {
                if (response.isSuccessful()){
                    callback.onSuccess(response.body());
                } else
                    callback.onError(Utils.parseError(response).getError());
            }

            @Override
            public void onFailure(Call<List<UserFollowers>> call, Throwable t) {
                callback.onError("Something went");
            }
        });
    }

    @Override
    public void getUserFollowing(String userName, final UserFollowingCallback callback) {
        mGitConnectionsService.getUserFollowing(userName).enqueue(new Callback<List<UserFollowing>>() {
            @Override
            public void onResponse(Call<List<UserFollowing>> call, Response<List<UserFollowing>> response) {
                if (response.isSuccessful()){
                    callback.onSuccess(response.body());
                } else
                    callback.onError(Utils.parseError(response).getError());
            }

            @Override
            public void onFailure(Call<List<UserFollowing>> call, Throwable t) {
                callback.onError("Something went");
            }
        });
    }
}
