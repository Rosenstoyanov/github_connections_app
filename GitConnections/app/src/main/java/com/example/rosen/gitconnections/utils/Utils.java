package com.example.rosen.gitconnections.utils;

import com.example.rosen.gitconnections.data.remote.service.RestClient;
import com.example.rosen.gitconnections.model.Error;
import com.example.rosen.gitconnections.model.RepositoryDetails;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by rosen on 10.04.17.
 */

public class Utils {

    public static Error parseError(Response<?> response) {
        Converter<ResponseBody, Error> converter =
                RestClient.getsRetrofit()
                        .responseBodyConverter(Error.class, Error.class.getAnnotations());
        Error error;
        try {
            error = converter.convert(response.errorBody());
            return error;
        } catch (IOException e) {
            return new Error("Something went wrong");
        }
    }

    public static void sortRepos(List<RepositoryDetails> repos){
        Collections.sort(repos, new Comparator<RepositoryDetails>() {
            @Override
            public int compare(RepositoryDetails o1, RepositoryDetails o2) {
                if (o1.getForksCount().compareTo(o2.getForksCount()) == 0)
                    return o1.getWatchersCount().compareTo(o2.getWatchersCount());

                return o1.getForksCount().compareTo(o2.getForksCount());
            }
        });
    }
}
