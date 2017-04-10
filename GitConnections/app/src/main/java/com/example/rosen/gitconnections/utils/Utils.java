package com.example.rosen.gitconnections.utils;

import com.example.rosen.gitconnections.model.RepositoryDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rosen on 10.04.17.
 */

public class Utils {

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
