package com.example.rosen.gitconnections.model;

/**
 * Created by rosen on 09.04.17.
 */

import com.google.gson.annotations.SerializedName;

public class RepositoryDetails {
    private String name;
    private String description;
    @SerializedName("watchers_count")
    private Integer watchersCount;
    @SerializedName("forks_count")
    private Integer forksCount;

    public RepositoryDetails(String name, String description, Integer watchersCount, Integer forksCount) {
        this.name = name;
        this.description = description;
        this.watchersCount = watchersCount;
        this.forksCount = forksCount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getWatchersCount() {
        return watchersCount;
    }

    public Integer getForksCount() {
        return forksCount;
    }
}
