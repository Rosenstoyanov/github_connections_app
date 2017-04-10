package com.example.rosen.gitconnections.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

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
    private Long userId;

    public UserFollowing(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(hash = 307593395)
    public UserFollowing(Long followingId, String name, String avatarUrl,
            Long userId) {
        this.followingId = followingId;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.userId = userId;
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

    public Long getUserId() {
        return this.userId;
    }
}
