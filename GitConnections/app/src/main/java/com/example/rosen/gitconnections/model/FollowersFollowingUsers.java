package com.example.rosen.gitconnections.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rosen on 10.04.17.
 */

public class FollowersFollowingUsers {
    @SerializedName("login")
    private String name;
    @SerializedName("avatar_url")
    private String avatarUrl;

    public FollowersFollowingUsers(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
