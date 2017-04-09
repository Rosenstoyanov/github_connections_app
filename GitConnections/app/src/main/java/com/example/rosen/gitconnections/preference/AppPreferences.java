package com.example.rosen.gitconnections.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.rosen.gitconnections.model.User;
import com.google.gson.Gson;

public class AppPreferences {
    private static final String PREF_NAME = "app_prefs";
    private static final String PROFILE = "user";

    private static Gson sGson = new Gson();

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, context.MODE_PRIVATE);
    }

    private static void putString(Context context, String key, String text) {
        getPrefs(context).edit().putString(key, text).apply();
    }

    private static String getString(Context context, String key, String def) {
        return getPrefs(context).getString(key, def);
    }

    public static void setUserProfile(User profile, Context context) {
        putString(context, PROFILE, profile != null ? sGson.toJson(profile) : null);
    }

    public static User getUserProfile(Context context) {
        String json = getString(context, PROFILE, null);
        if (!TextUtils.isEmpty(json)) {
            try {
                return sGson.fromJson(json, User.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
