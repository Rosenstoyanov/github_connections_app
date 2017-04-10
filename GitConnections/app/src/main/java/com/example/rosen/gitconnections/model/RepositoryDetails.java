package com.example.rosen.gitconnections.model;

/**
 * Created by rosen on 09.04.17.
 */

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class RepositoryDetails {
    @Id
    @SerializedName("id")
    Long repositoryId;
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

    @Generated(hash = 1795126317)
    public RepositoryDetails(Long repositoryId, String name, String description, Integer watchersCount,
            Integer forksCount) {
        this.repositoryId = repositoryId;
        this.name = name;
        this.description = description;
        this.watchersCount = watchersCount;
        this.forksCount = forksCount;
    }

    @Generated(hash = 255653356)
    public RepositoryDetails() {
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

    public Long getRepositoryId() {
        return this.repositoryId;
    }

    public void setRepositoryId(Long repositoryId) {
        this.repositoryId = repositoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWatchersCount(Integer watchersCount) {
        this.watchersCount = watchersCount;
    }

    public void setForksCount(Integer forksCount) {
        this.forksCount = forksCount;
    }
}
