package com.example.rosen.gitconnections.service;

import com.example.rosen.gitconnections.model.RepositoryDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rosen on 09.04.17.
 */

public interface GitConnectionsService {

    @GET("/users/{username}/")
    Call<List<RepositoryDetails>> getUserProfile(@Path("username") String username);

    @GET("/users/{username}/repos/")
    Call<List<RepositoryDetails>> getUserRepositoies(@Path("username") String username);

    @GET("/users/{username}/followers/")
    Call<List<RepositoryDetails>> getUserFollowers(@Path("username") String username);

    @GET("/users/{username}/following/")
    Call<List<RepositoryDetails>> getUserFollowing(@Path("username") String username);

}
