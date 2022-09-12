package com.egsystembd.aitfeed.utils;//package com.swotsystemltd.agroindustrialtrust.utils;
//
//import android.app.DatePickerDialog;
//import android.app.Dialog;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v4.app.DialogFragment;
//
//import java.util.Calendar;
//
//
//public class DatePickerFragment extends DialogFragment {
//
//    public static final int FLAG_START_DATE = 0;
//    public static final int FLAG_END_DATE = 1;
//
//    private int flag = 0;
//
//
//    @NonNull
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        Calendar c = Calendar.getInstance();
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH);
//        int day = c.get(Calendar.DAY_OF_MONTH);
//
//        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
//    }
//
//
//    public  void setFlag(int i) {
//        flag = i;
//    }
//
//
//}