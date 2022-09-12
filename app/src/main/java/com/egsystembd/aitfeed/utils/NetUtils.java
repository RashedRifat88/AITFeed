package com.egsystembd.aitfeed.utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.egsystembd.aitfeed.R;
import com.google.android.material.snackbar.Snackbar;


public class NetUtils {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }


//    public static boolean showDialoog(Context context) {
//        new MaterialDialog.Builder(context)
//                .title("ইন্টারনেট সমস্যা")
//                .content("দয়াকরে আপনার ইন্টারনেট কানেকশন চেক করুন।")
//                .positiveText("")
//                .negativeText("Ok")
//                .onNegative(new MaterialDialog.SingleButtonCallback() {
//                    @Override
//                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                        context.getApplicationContext().finish();
//                    }
//                })
//                .show();
//    }

//    public static void noInternetWarning(View view, final Context context) {
//        if (!isNetworkAvailable(context)) {
//            Snackbar snackbar = Snackbar.make(view,"No internet Connection",Snackbar.LENGTH_INDEFINITE);
//            snackbar.setActionTextColor((int) InputDeviceCompat.SOURCE_ANY);
//            View snackbarView = snackbar.getView();
//            snackbarView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
//            ((TextView) snackbarView.findViewById(R.id.snackbar_text)).setTextColor(-1);
//            snackbar.setAction("connect", new View.OnClickListener() {
//                public void onClick(View v) {
//                    Intent intent = new Intent("android.settings.SETTINGS");
//                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//                    context.startActivity(intent);
//                }
//            });
//            FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)snackbarView.getLayoutParams();
//            params.gravity = Gravity.TOP;
//            params.setMargins(10, 100, 10, 10);
//            snackbarView.setLayoutParams(params);
//            snackbar.show();
//        }
//    }


}

