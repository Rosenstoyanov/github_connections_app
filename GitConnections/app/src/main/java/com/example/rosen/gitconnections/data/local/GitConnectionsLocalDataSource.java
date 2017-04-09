package com.example.rosen.gitconnections.data.local;

import com.example.rosen.gitconnections.data.GitConnectionsDataSource;

/**
 * Created by rosen on 09.04.17.
 */

public class GitConnectionsLocalDataSource implements GitConnectionsDataSource {
    private static GitConnectionsLocalDataSource instanse;

    public static GitConnectionsLocalDataSource getInstanse(){
        if (instanse == null)
            instanse = new GitConnectionsLocalDataSource();
        return instanse;
    }

    private GitConnectionsLocalDataSource() {
    }

    @Override
    public void login(String userName, LoginCallback loginCallback) {

    }
}
