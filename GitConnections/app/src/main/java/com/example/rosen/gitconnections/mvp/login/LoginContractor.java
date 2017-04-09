package com.example.rosen.gitconnections.mvp.login;

import com.example.rosen.gitconnections.model.User;
import com.example.rosen.gitconnections.mvp.base.BasePresenter;

/**
 * Created by rosen on 09.04.17.
 */

public interface LoginContractor {

    interface Presenter {
        void attemptUserLogin(String username);
    }

    interface View {
        void onLogInSuccess(User user);

        void onLogInFailure(String s);
    }
}
