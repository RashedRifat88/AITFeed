// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) nolvt fieldsfirst noconv 

package com.egsystembd.aitfeed.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MySharedPreferences {

    Context context;

    public MySharedPreferences(Context context1) {
        context = context1;
    }

    public static void savePreferences(Context context, String s, float f) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putFloat(s, f);
        editor.commit();
    }

    public static void savePreferences(Context context, String s, int i) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(s, i);
        editor.commit();
    }

    public static void savePreferences(Context context, String s, long l) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putLong(s, l);
        editor.commit();
    }

    public static void savePreferences(Context context, String s, String s1) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(s, s1);
        editor.commit();
    }

    public static void savePreferences(Context context, String s, boolean flag) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(s, flag);
        editor.commit();
    }

    public static int getInt(Context context, String s) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getInt(s, -1);

    }

    public static boolean getBoolean(Context context, String s) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getBoolean(s, false);

    }

    public static float getFloat(Context context, String s) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getFloat(s, 0.0f);

    }

    public static String getString(Context context, String s) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        return sharedPreferences.getString(s, "");

    }


}
