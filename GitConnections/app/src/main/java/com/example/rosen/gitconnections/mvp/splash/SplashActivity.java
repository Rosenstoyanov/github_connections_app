package com.example.rosen.gitconnections.mvp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.rosen.gitconnections.mvp.login.LoginActivity;
import com.example.rosen.gitconnections.mvp.user_details.UserDetailsActivity;
import com.example.rosen.gitconnections.preference.AppPreferences;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (AppPreferences.getUserSession(this) != null){
            Intent intent = new Intent(this, UserDetailsActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
