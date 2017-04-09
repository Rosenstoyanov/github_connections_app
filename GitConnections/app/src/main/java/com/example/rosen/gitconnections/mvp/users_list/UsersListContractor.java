package com.example.rosen.gitconnections.mvp.users_list;

import com.example.rosen.gitconnections.model.FollowersFollowingUsers;
import com.example.rosen.gitconnections.model.RepositoryDetails;

import java.util.List;

/**
 * Created by rosen on 10.04.17.
 */

public interface UsersListContractor {
    interface Presenter {
        void getFollowersList(String username);

        void getFollowingList(String username);
    }

    interface View {
        void onUsersListSuccess(List<FollowersFollowingUsers> repositories);

        void onUserlistFailure(String s);
    }
}
