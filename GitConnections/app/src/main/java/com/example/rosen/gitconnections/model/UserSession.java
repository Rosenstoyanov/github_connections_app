package com.example.rosen.gitconnections.model;

/**
 * Created by rosenstoyanov on 10.04.17.
 */

public class UserSession {
    private Long id;
    private String username;

    public UserSession(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
