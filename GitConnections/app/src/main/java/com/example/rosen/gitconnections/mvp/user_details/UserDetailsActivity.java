package com.example.rosen.gitconnections.mvp.user_details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.rosen.gitconnections.R;
import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.model.User;
import com.example.rosen.gitconnections.mvp.base.BaseActivity;
import com.example.rosen.gitconnections.preference.AppPreferences;
import com.example.rosen.gitconnections.settings.Settings;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        
        init();
    }

    private void init(){
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
        mTvFollowersCount.setText(mUser.getFollowers());
        mTvFollowingCount.setText(mUser.getFollowing());
        mPresenter.getUserRepositories(mUser.getName());

        mAdapter = new ReposAdapter();
        mPublicReposList.setLayoutManager(new LinearLayoutManager(this));
        mPublicReposList.setAdapter(mAdapter);
    }


    @Override
    public void onRepositoryDetailsSuccess(List<RepositoryDetails> repositories) {
        mTvPublicReposCount.setText(repositories.size());
        mAdapter.setData((ArrayList<RepositoryDetails>) repositories);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRepositoryDetailsFailure(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
