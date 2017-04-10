package com.example.rosen.gitconnections.mvp.users_list;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rosen.gitconnections.R;
import com.example.rosen.gitconnections.model.FollowersFollowingUsers;
import com.example.rosen.gitconnections.settings.Settings;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rosen on 10.04.17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {
    private ArrayList<FollowersFollowingUsers> mData;
    private ItemClicksCallback mItemClicks;

    public UsersAdapter(ItemClicksCallback mItemClicks) {
        mData = new ArrayList<>();
        this.mItemClicks = mItemClicks;
    }

    public void setmData(ArrayList<FollowersFollowingUsers> mData) {
        this.mData.clear();
        this.mData = mData;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row_user, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tv_username)
        AppCompatTextView mUserName;
        @BindView(R.id.iv_avatar)
        ImageView mIvAvatar;

        public UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bind(FollowersFollowingUsers followersFollowingUsers) {
            mUserName.setText(followersFollowingUsers.getName());

            Glide.with(mIvAvatar.getContext())
                    .load(followersFollowingUsers.getAvatarUrl())
                    .dontAnimate()
                    .fallback(Settings.AVATAR_PLACE_HOLDER)
                    .placeholder(Settings.AVATAR_PLACE_HOLDER)
                    .error(Settings.AVATAR_PLACE_HOLDER)
                    .into(mIvAvatar);
        }

        @Override
        public void onClick(View v) {
            mItemClicks.onItemClick(mData.get(getAdapterPosition()));
        }
    }

    public interface ItemClicksCallback {
        void onItemClick(FollowersFollowingUsers followersFollowingUsers);
    }
}
