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
public class UserFollowers {
    @Id
    @SerializedName("id")
    Long followersId;
    @SerializedName("login")
    private String name;
    @SerializedName("avatar_url")
    private String avatarUrl;

    public UserFollowers(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    @Generated(hash = 325016258)
    public UserFollowers(Long followersId, String name, String avatarUrl) {
        this.followersId = followersId;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    @Generated(hash = 1983782772)
    public UserFollowers() {
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Long getFollowersId() {
        return this.followersId;
    }

    public void setFollowersId(Long followersId) {
        this.followersId = followersId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
