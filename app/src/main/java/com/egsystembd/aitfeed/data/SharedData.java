package com.egsystembd.aitfeed.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedData {

    public static final String previous_index = "previous_index";

    public static final String DEVICE_ID = "device_id";
    public static final String ITEM_TOTAL_PRICE = "item_total_price";
    public static final String ITEM_PAID_AMOUNT = "item_paid_amount";

    public static final String PHONE_CUSTOMER = "phone_customer";
    public static final String CUSTOMER_LOCATION = "customer_location";
    public static final String ADDRESS_CUSTOMER_AREA = "address_customer_area";
    public static final String ADDRESS_CUSTOMER_THANA = "address_customer_thana";
    public static final String ADDRESS_CUSTOMER_DISTRICT = "address_customer_district";
    public static final String ADDRESS_CUSTOMER_DIVISION = "address_customer_division";


    public static final String CUSTOMER_ID = "customer_id";
    public static final String CUSTOMER_NAME = "customer_name";
    public static final String CUSTOMER_PHONE = "customer_phone";
    public static final String CUSTOMER_EMAIL = "customer_email";
    public static final String CUSTOMER_ADDRESS = "customer_address";
    public static final String CUSTOMER_PASSWORD = "customer_password";

    public static final String CUSTOMER_AREA_ID = "customer_area_id";


    public static void saveCustomerAreaId(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(CUSTOMER_PASSWORD, value);
        editor.commit();
    }

    public static String getCustomerAreaId(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(CUSTOMER_PASSWORD, null);
    }


    public static void savePrevious_index(Context context, int value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putInt(previous_index, value);
        editor.commit();
    }

    public static int getPrevious_index(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(previous_index, 0);
    }
  public static void saveDeviceId(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(DEVICE_ID, value);
        editor.commit();
    }

    public static String getDeviceId(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(DEVICE_ID, null);
    }

    public static void saveItemTotalPrice(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(ITEM_TOTAL_PRICE, value);
        editor.commit();
    }

    public static String getItemTotalPrice(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(ITEM_TOTAL_PRICE, null);
    }


    public static void saveItemPaidAmount(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(ITEM_PAID_AMOUNT, value);
        editor.commit();
    }

    public static String getItemPaidAmount(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(ITEM_PAID_AMOUNT, null);
    }


    //customer
    public static void saveCustomerId(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(CUSTOMER_ID, value);
        editor.commit();
    }

    public static String getCustomerId(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(CUSTOMER_ID, null);
    }

    public static void saveCustomerName(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(CUSTOMER_NAME, value);
        editor.commit();
    }

    public static String getCustomerName(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(CUSTOMER_NAME, null);
    }


    public static void saveCustomerPhone(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(CUSTOMER_PHONE, value);
        editor.commit();
    }

    public static String getCustomerPhone(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(CUSTOMER_PHONE, null);
    }

    public static void saveCustomerEmail(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(CUSTOMER_EMAIL, value);
        editor.commit();
    }

    public static String getCustomerEmail(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(CUSTOMER_EMAIL, null);
    }

    public static void saveCustomerAddress(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(CUSTOMER_ADDRESS, value);
        editor.commit();
    }

    public static String getCustomerAddress(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(CUSTOMER_ADDRESS, null);
    }

    public static void saveCustomerPassword(Context context, String value) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString(CUSTOMER_PASSWORD, value);
        editor.commit();
    }

    public static String getCustomerPassword(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(CUSTOMER_PASSWORD, null);
    }


}
