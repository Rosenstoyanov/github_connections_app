package com.example.rosen.gitconnections.mvp.users_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.rosen.gitconnections.R;
import com.example.rosen.gitconnections.model.FollowersFollowingUsers;
import com.example.rosen.gitconnections.model.User;
import com.example.rosen.gitconnections.mvp.base.BaseActivity;
import com.example.rosen.gitconnections.mvp.user_details.UserDetailsActivity;
import com.example.rosen.gitconnections.preference.AppPreferences;
import com.example.rosen.gitconnections.settings.Settings;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class UsersListActivity extends BaseActivity<UsersListPresentor>
        implements UsersListContractor.View, UsersAdapter.ItemClicksCallback {
    @BindView(R.id.rv_users)
    RecyclerView mUsersList;

    private UsersAdapter mAdapter;
    private User mUser;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_users_list;
    }

    @Override
    protected void initViews() {
        mPresenter = new UsersListPresentor(this);
        mUser = AppPreferences.getUserProfile(this);
        mAdapter = new UsersAdapter(this);
        mUsersList.setLayoutManager(new LinearLayoutManager(this));
        mUsersList.setAdapter(mAdapter);

        Bundle bundle = getIntent().getExtras();
        if (bundle.getBoolean(Settings.EXTRA_OPEN_FOLLOWERS))
            mPresenter.getFollowersList(mUser.getName());
        else
            mPresenter.getFollowingList(mUser.getName());
    }

    @Override
    public void onUsersListSuccess(List<FollowersFollowingUsers> repositories) {
        mAdapter.setmData((ArrayList<FollowersFollowingUsers>) repositories);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onUserlistFailure(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(FollowersFollowingUsers followersFollowingUsers) {
        Intent intent = new Intent(this, UserDetailsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Settings.EXTRA_USERNAME, followersFollowingUsers.getName());
    }
}
