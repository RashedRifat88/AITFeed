package com.egsystembd.aitfeed.credential;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Credential {
    public static final String DEVICE_ID = "device_id";

    public static final String EMAIL = "email";
    public static final String DEALER_NAME = "dealer_name";
    public static final String PIN = "pin";
    public static final String LOGIN_SESSION_KEY = "login_session_key";
    public static final String TOKEN = "token";
    public static final String NAME = "name";
    public static final String BOOK_DOWNLOAD_STATUS = "book_download_status";
    public static final String BOOK_DOWNLOAD_ID = "book_download_id";
    public static final String MOBILE_VERIFICATION_STATUS = "mobile_verification_status";

//    public static final String USER_TOKEN = "user_token";
    public static final String USER_NAME = "user_name";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_ROLE = "user_role";
    public static final String USER_ADDRESS = "user_address";

//    public static void saveUSER_TOKEN(Context context, String value) {
//        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
//        editor.putString(USER_NAME, value);
//        editor.commit();
//    }
    public static void saveUserName(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(USER_NAME, value);
        editor.commit();
    }

    public static void saveUserEmail(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(USER_EMAIL, value);
        editor.commit();
    }

    public static void saveUserAddress(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(USER_ADDRESS, value);
        editor.commit();
    }

    public static void saveUserRole(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(USER_ROLE, value);
        editor.commit();
    }

    public static void saveEmail(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(EMAIL, value);
        editor.commit();
    }

    public static void saveDealerName(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(DEALER_NAME, value);
        editor.commit();
    }

    public static void savePin(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(PIN, value);
        editor.commit();
    }

    public static void saveSessionKey(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(LOGIN_SESSION_KEY, value);
        editor.commit();
    }

    public static void saveToken(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(TOKEN, value);
        editor.commit();
    }

    public static void saveDeviceId(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(DEVICE_ID, value);
        editor.commit();
    }

    public static void saveName(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(NAME, value);
        editor.commit();
    }

    public static void saveBookDownloadStatus(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(BOOK_DOWNLOAD_STATUS, value);
        editor.commit();
    }

    public static void saveBookDownloadId(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(BOOK_DOWNLOAD_ID, value);
        editor.commit();
    }


//    public static String getUSER_TOKEN(Context context) {
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
//        return sharedPreferences.getString(USER_TOKEN, null);
//    }

    public static String getUserName(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(USER_NAME, null);
    }

    public static String getUserEmail(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(USER_EMAIL, null);
    }

    public static String getUserRole(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(USER_ROLE, null);
    }

    public static String getEmail(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(EMAIL, null);
    }
    public static String getUserAddress(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(USER_ADDRESS, null);
    }

    public static String getDealerName(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(DEALER_NAME, null);
    }

    public static String getPin(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(PIN, null);
    }

    public static String getSessionKey(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(LOGIN_SESSION_KEY, null);
    }

    public static String getToken(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(TOKEN, null);
    }

    public static String getDeviceId(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(DEVICE_ID, null);
    }

    public static String getName(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(NAME, null);
    }

    public static String getBookDownloadStatus(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(BOOK_DOWNLOAD_STATUS, "false");
    }

    public static String getBookDownloadId(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(BOOK_DOWNLOAD_ID, "false");
    }

    public static void saveMobileVerificationStatus(Context context, boolean b) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(MOBILE_VERIFICATION_STATUS, b);
        editor.commit();
    }

    public static boolean getMobileVerificationStatus(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(MOBILE_VERIFICATION_STATUS, false);
    }
}
