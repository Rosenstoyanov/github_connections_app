package com.example.rosen.gitconnections.mvp.user_details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.example.rosen.gitconnections.R;

import butterknife.BindView;

public class UserDetailsActivity extends AppCompatActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
    }
}
