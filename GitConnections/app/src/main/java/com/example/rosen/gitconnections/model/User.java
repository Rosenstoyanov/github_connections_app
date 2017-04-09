package com.example.rosen.gitconnections.model;

/**
 * Created by rosen on 09.04.17.
 */

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("avatar_url")
    private String avatarUrl;
    private String name;
    private String bio;
    private String location;
    @SerializedName("followers_url")
    private String followersUrl;
    @SerializedName("following_url")
    private String followingUrl;
    @SerializedName("repos_url")
    private String reposUrl;
    @SerializedName("public_repos")
    private Integer publicRepos;
    private Integer followers;
    private Integer following;

    public User(String avatarUrl, String name, String bio, String location, String followersUrl, String followingUrl, String reposUrl, Integer publicRepos, Integer followers, Integer following) {
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.bio = bio;
        this.location = location;
        this.followersUrl = followersUrl;
        this.followingUrl = followingUrl;
        this.reposUrl = reposUrl;
        this.publicRepos = publicRepos;
        this.followers = followers;
        this.following = following;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public String getLocation() {
        return location;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public Integer getPublicRepos() {
        return publicRepos;
    }

    public Integer getFollowers() {
        return followers;
    }

    public Integer getFollowing() {
        return following;
    }
}
