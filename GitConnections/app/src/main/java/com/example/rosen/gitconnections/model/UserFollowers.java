package com.example.rosen.gitconnections.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

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
    private Long userId;

    public UserFollowers(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(hash = 655722096)
    public UserFollowers(Long followersId, String name, String avatarUrl,
            Long userId) {
        this.followersId = followersId;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.userId = userId;
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

    public Long getUserId() {
        return this.userId;
    }
}
