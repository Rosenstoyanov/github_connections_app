package com.example.rosen.gitconnections.data.remote;

import com.example.rosen.gitconnections.data.GitConnectionsDataSource;
import com.example.rosen.gitconnections.data.remote.service.GitConnectionsService;
import com.example.rosen.gitconnections.data.remote.service.RestClient;
import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.model.User;

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
    public void login(String userName, final LoginCallback loginCallback) {
        mGitConnectionsService.getUserProfile(userName).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful())
                    loginCallback.onLoginSuccess(response.body());
                else
                    loginCallback.onLoginError(response.errorBody().toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loginCallback.onLoginError("Something went");
            }
        });
    }
}