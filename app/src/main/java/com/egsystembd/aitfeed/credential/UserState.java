package com.egsystembd.aitfeed.credential;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class UserState {
    public static final int FIRST_TIME_STATE = 0;
    public static final int LOGGED_IN_STATE = 1;
    public static final int LOGGED_OUT_STATE = 2;

    private static String KEY_CURRENT_STATE = "current_state";

    public static int getCurrentState(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(KEY_CURRENT_STATE, 0);
    }

    public static void setToFirstTimeState(Context context) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(KEY_CURRENT_STATE, FIRST_TIME_STATE);
        editor.commit();
    }

    public static void setToLoggedInState(Context context) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(KEY_CURRENT_STATE, LOGGED_IN_STATE);
        editor.commit();
    }

    public static void setToLoggedOutState(Context context) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(KEY_CURRENT_STATE, LOGGED_OUT_STATE);
        editor.commit();
    }


}
