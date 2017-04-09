package com.example.rosen.gitconnections.service;


import com.example.rosen.gitconnections.settings.Settings;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rosen on 09.04.17.
 */

public class RestClient {

    private static GitConnectionsService sGitConnectionsService;

    public static Retrofit sRetrofit;


    private static Retrofit getRestAdapter() {

//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        OkHttpClient client = builder.build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(Settings.EndPointUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        sRetrofit = restAdapter;

        return restAdapter;
    }

    public static GitConnectionsService getApiService() {

        if (sGitConnectionsService == null) {
            sGitConnectionsService = getRestAdapter().create(GitConnectionsService.class);
        }

        return sGitConnectionsService;
    }
}
