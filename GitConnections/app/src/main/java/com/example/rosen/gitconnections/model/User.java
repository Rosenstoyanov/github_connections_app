package com.example.rosen.gitconnections.model;

/**
 * Created by rosen on 09.04.17.
 */

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity
public class User {
    @Id
    @SerializedName("id")
    Long userId;
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

    @ToMany(referencedJoinProperty = "followersId")
    private List<UserFollowers> followerses;

    @ToMany(referencedJoinProperty = "followingId")
    private List<UserFollowing> followings;

    @ToMany(referencedJoinProperty = "repositoryId")
    private List<RepositoryDetails> repositoryDetails;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;


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

    @Generated(hash = 2023790938)
    public User(Long userId, String avatarUrl, String name, String bio, String location, String followersUrl, String followingUrl, String reposUrl, Integer publicRepos, Integer followers,
            Integer following) {
        this.userId = userId;
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

    @Generated(hash = 586692638)
    public User() {
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

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public void setPublicRepos(Integer publicRepos) {
        this.publicRepos = publicRepos;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1511689843)
    public List<UserFollowers> getFollowerses() {
        if (followerses == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserFollowersDao targetDao = daoSession.getUserFollowersDao();
            List<UserFollowers> followersesNew = targetDao._queryUser_Followerses(userId);
            synchronized (this) {
                if (followerses == null) {
                    followerses = followersesNew;
                }
            }
        }
        return followerses;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1650216217)
    public synchronized void resetFollowerses() {
        followerses = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 157654270)
    public List<UserFollowing> getFollowings() {
        if (followings == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserFollowingDao targetDao = daoSession.getUserFollowingDao();
            List<UserFollowing> followingsNew = targetDao._queryUser_Followings(userId);
            synchronized (this) {
                if (followings == null) {
                    followings = followingsNew;
                }
            }
        }
        return followings;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1450839380)
    public synchronized void resetFollowings() {
        followings = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1763504789)
    public List<RepositoryDetails> getRepositoryDetails() {
        if (repositoryDetails == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RepositoryDetailsDao targetDao = daoSession.getRepositoryDetailsDao();
            List<RepositoryDetails> repositoryDetailsNew = targetDao._queryUser_RepositoryDetails(userId);
            synchronized (this) {
                if (repositoryDetails == null) {
                    repositoryDetails = repositoryDetailsNew;
                }
            }
        }
        return repositoryDetails;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 804487131)
    public synchronized void resetRepositoryDetails() {
        repositoryDetails = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
}
