package com.example.rosen.gitconnections.data;

import com.example.rosen.gitconnections.model.FollowersFollowingUsers;
import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.model.User;

import java.util.List;

/**
 * Created by rosen on 09.04.17.
 */

public interface GitConnectionsDataSource {
    void getUserProfile(String userName, ProfileCallback profileCallback);
    void getUserRepositories(String userName, UserRepositoriesCallback callback);
    void getUserFollowers(String userName, UserFollowersCallback callback);
    void getUserFollowing(String userName, UserFollowingCallback callback);

    interface ProfileCallback {
        void onSuccess(User user);

        void onError(String error);
    }

    interface UserRepositoriesCallback {
        void onSuccess(List<RepositoryDetails> repositories);

        void onError(String error);
    }

    interface UserFollowersCallback {
        void onSuccess(List<FollowersFollowingUsers> repositories);

        void onError(String error);
    }

    interface UserFollowingCallback {
        void onSuccess(List<FollowersFollowingUsers> repositories);

        void onError(String error);
    }
}
