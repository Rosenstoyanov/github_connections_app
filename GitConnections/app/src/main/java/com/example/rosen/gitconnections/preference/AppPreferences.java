package com.example.rosen.gitconnections.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.rosen.gitconnections.model.UserSession;
import com.google.gson.Gson;

public class AppPreferences {
    private static final String PREF_NAME = "app_prefs";
    private static final String USER_SESSION = "user_session";
    private static final String USER_NAME = "user_name";

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

    public static void setUserSession(UserSession userSession, Context context) {
        putString(context, USER_SESSION, userSession != null ? sGson.toJson(userSession) : null);
    }

    public static UserSession getUserSession(Context context) {
        String json = getString(context, USER_SESSION, null);
        if (!TextUtils.isEmpty(json)) {
            try {
                return sGson.fromJson(json, UserSession.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void clear(Context context) {
        getPrefs(context).edit().clear().apply();
    }

}
