package com.example.rosen.gitconnections.mvp.user_details;

import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.model.User;

import java.util.List;

/**
 * Created by rosen on 09.04.17.
 */

public interface UserDetailsContractor {
    interface Presenter {
        void getUserRepositories(String username);

        void getUserProfile(String userName);
    }

    interface View {
        void onRepositoryDetailsSuccess(List<RepositoryDetails> repositories);

        void onFailure(String s);

        void onUserProfileSuccess(User user);
    }
}
