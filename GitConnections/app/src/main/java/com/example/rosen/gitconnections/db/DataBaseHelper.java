package com.example.rosen.gitconnections.db;

import android.database.sqlite.SQLiteDatabase;

import com.example.rosen.gitconnections.application.App;
import com.example.rosen.gitconnections.model.DaoMaster;
import com.example.rosen.gitconnections.model.DaoSession;
import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.model.User;
import com.example.rosen.gitconnections.model.UserDao;
import com.example.rosen.gitconnections.model.UserFollowers;
import com.example.rosen.gitconnections.model.UserFollowersDao;
import com.example.rosen.gitconnections.model.UserFollowing;
import com.example.rosen.gitconnections.model.UserFollowingDao;

import java.util.List;

/**
 * Created by rosenstoyanov on 10.04.17.
 */

public class DataBaseHelper {
    private static DataBaseHelper instance;
    private DaoMaster.DevOpenHelper helper;
    private static SQLiteDatabase db;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private static UserDao userDao;
    private static UserFollowersDao userFollowersDao;
    private static UserFollowingDao userFollowingDao;

    private DataBaseHelper() {
        helper = new DaoMaster.DevOpenHelper(App.getInstance(), "git-connections-db", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

    }

    public static DataBaseHelper getInstance() {
        if (instance == null)
            instance = new DataBaseHelper();

        return instance;
    }

    public User getUser(Long id){
        userDao = daoSession.getUserDao();
        return userDao.queryBuilder().where(UserDao.Properties.UserId.eq(id)).list().get(0);
    }

    public User getUser(String userName){
        userDao = daoSession.getUserDao();
        return userDao.queryBuilder().where(UserDao.Properties.UserName.eq(userName)).list().get(0);
    }

    public void insertOrReplaceFollowing(UserFollowing userFollowing){
        userFollowingDao = daoSession.getUserFollowingDao();
        userFollowingDao.insertOrReplace(userFollowing);
    }

    public void insertOrReplaceFollowers(UserFollowers userFollowers){
        userFollowersDao = daoSession.getUserFollowersDao();
        userFollowersDao.insertOrReplace(userFollowers);
    }

    public void insertOrReplaceUser(User user) {
        userDao = daoSession.getUserDao();
        userDao.insertOrReplace(user);
    }

    public void saveUserRepos(String userName, List<RepositoryDetails> body) {
        User user = getUser(userName);
        user.setRepositoryDetails(body);
        insertOrReplaceUser(user);
    }

    public void saveUserFollowing(String userName, List<UserFollowing> body) {
        User user = getUser(userName);
        user.setFollowings(body);
        insertOrReplaceUser(user);
    }

    public void saveUserFollowers(String userName, List<UserFollowers> body) {
        User user = getUser(userName);
        user.setFollowerses(body);
        insertOrReplaceUser(user);
    }
}
