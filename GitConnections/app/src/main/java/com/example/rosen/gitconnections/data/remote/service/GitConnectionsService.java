package com.example.rosen.gitconnections.data.remote.service;

import com.example.rosen.gitconnections.model.FollowersFollowingUsers;
import com.example.rosen.gitconnections.model.RepositoryDetails;
import com.example.rosen.gitconnections.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rosen on 09.04.17.
 */

public interface GitConnectionsService {

    @GET("/users/{username}")
    Call<User> getUserProfile(@Path("username") String username);

    @GET("/users/{username}/repos")
    Call<List<RepositoryDetails>> getUserRepositoies(@Path("username") String username);

    @GET("/users/{username}/followers")
    Call<List<FollowersFollowingUsers>> getUserFollowers(@Path("username") String username);

    @GET("/users/{username}/following")
    Call<List<FollowersFollowingUsers>> getUserFollowing(@Path("username") String username);

}
