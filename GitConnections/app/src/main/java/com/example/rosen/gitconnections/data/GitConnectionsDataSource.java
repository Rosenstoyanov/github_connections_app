package com.example.rosen.gitconnections.data;

import android.support.annotation.NonNull;

import com.example.rosen.gitconnections.model.User;

/**
 * Created by rosen on 09.04.17.
 */

public interface GitConnectionsDataSource {
    void login(String userName, LoginCallback loginCallback);

    interface LoginCallback {
        void onLoginSuccess(User user);

        void onLoginError(String error);
    }
}
