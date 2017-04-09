package com.example.rosen.gitconnections.data;

import android.support.annotation.NonNull;

import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.model.User;

import java.util.List;

/**
 * Created by rosen on 09.04.17.
 */

public interface GitConnectionsDataSource {
    void login(String userName, LoginCallback loginCallback);
    void getUserRepositories(String userName, UserRepositoriesCallback callback);

    interface LoginCallback {
        void onLoginSuccess(User user);

        void onLoginError(String error);
    }

    interface UserRepositoriesCallback {
        void onSuccess(List<RepositoryDetails> repositories);

        void onError(String error);
    }
}
