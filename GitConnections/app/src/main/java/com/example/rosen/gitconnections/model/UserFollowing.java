package com.example.rosen.gitconnections.model;

import com.example.rosen.gitconnections.mvp.users_list.UsersAdapter;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by rosen on 10.04.17.
 */
@Entity
public class UserFollowing {
    @Id
    @SerializedName("id")
    Long followingId;
    @SerializedName("login")
    private String name;
    @SerializedName("avatar_url")
    private String avatarUrl;

    public UserFollowing(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    @Generated(hash = 978204332)
    public UserFollowing(Long followingId, String name, String avatarUrl) {
        this.followingId = followingId;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    @Generated(hash = 1479098381)
    public UserFollowing() {
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Long getFollowingId() {
        return this.followingId;
    }

    public void setFollowingId(Long followingId) {
        this.followingId = followingId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
