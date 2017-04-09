package com.example.rosen.gitconnections.mvp.users_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.rosen.gitconnections.R;
import com.example.rosen.gitconnections.model.FollowersFollowingUsers;
import com.example.rosen.gitconnections.mvp.base.BaseActivity;

import java.util.List;

import butterknife.BindView;

public class UsersListActivity extends BaseActivity<UsersListPresentor> implements UsersListContractor.View {
    @BindView(R.id.rv_users)
    RecyclerView mUsersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
    }

    @Override
    public void onUsersListSuccess(List<FollowersFollowingUsers> repositories) {

    }

    @Override
    public void onUserlistFailure(String s) {

    }
}
