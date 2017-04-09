package com.example.rosen.gitconnections.mvp.user_details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rosen.gitconnections.R;
import com.example.rosen.gitconnections.application.App;
import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.model.User;
import com.example.rosen.gitconnections.mvp.base.BaseActivity;
import com.example.rosen.gitconnections.mvp.users_list.UsersListActivity;
import com.example.rosen.gitconnections.preference.AppPreferences;
import com.example.rosen.gitconnections.settings.Settings;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class UserDetailsActivity extends BaseActivity<UserDetailsPresenter> implements UserDetailsContractor.View {
    @BindView(R.id.iv_avatar)
    ImageView mIvAvatar;
    @BindView(R.id.tv_name)
    AppCompatTextView mTvUsername;
    @BindView(R.id.tv_bio)
    AppCompatTextView mTvBio;
    @BindView(R.id.tv_followers_count)
    AppCompatTextView mTvFollowersCount;
    @BindView(R.id.tv_following_count)
    AppCompatTextView mTvFollowingCount;
    @BindView(R.id.tv_public_repos_count)
    AppCompatTextView mTvPublicReposCount;
    @BindView(R.id.rv_public_repos)
    RecyclerView mPublicReposList;

    private ReposAdapter mAdapter;
    private User mUser;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_details;
    }

    @Override
    protected void initViews() {
        mUser = AppPreferences.getUserProfile(this);

        Glide.with(this)
                .load(mUser.getAvatarUrl())
                .dontAnimate()
                .fallback(Settings.AVATAR_PLACE_HOLDER)
                .placeholder(Settings.AVATAR_PLACE_HOLDER)
                .error(Settings.AVATAR_PLACE_HOLDER)
                .into(mIvAvatar);

        mTvUsername.setText(mUser.getName());
        mTvBio.setText(mUser.getBio());
//        mTvFollowersCount.setText(mUser.getFollowers());
//        mTvFollowingCount.setText(mUser.getFollowing());
        mPresenter = new UserDetailsPresenter(this);

        mAdapter = new ReposAdapter();
        mPublicReposList.setLayoutManager(new LinearLayoutManager(this));
        mPublicReposList.setAdapter(mAdapter);

        mPresenter.getUserRepositories(AppPreferences.getUserName(this));
    }

    @OnClick({R.id.tv_followers_count, R.id.tv_following_count})
    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.tv_followers_count){
            Intent intent = new Intent(this, UsersListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean(Settings.EXTRA_OPEN_FOLLOWERS, true);
            startActivity(intent);
        } else if (id == R.id.tv_following_count){
            Intent intent = new Intent(this, UsersListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putBoolean(Settings.EXTRA_OPEN_FOLLOWERS, false);
            startActivity(intent);
        }

    }


    @Override
    public void onRepositoryDetailsSuccess(List<RepositoryDetails> repositories) {
//        mTvPublicReposCount.setText(repositories.size());
        mAdapter.setData((ArrayList<RepositoryDetails>) repositories);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRepositoryDetailsFailure(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_details_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_logout)
            App.getInstance().logout();

        return super.onOptionsItemSelected(item);
    }
}
