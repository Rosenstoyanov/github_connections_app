package com.example.rosen.gitconnections.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rosen on 10.04.17.
 */

public class Error {
    @SerializedName("message")
    private String error;

    public Error(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
