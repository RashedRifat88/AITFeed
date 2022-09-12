//package com.egsystembd.aitfeed.credential;
//
//import android.annotation.SuppressLint;
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.provider.Settings;
//import android.support.annotation.NonNull;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import com.afollestad.materialdialogs.DialogAction;
//import com.afollestad.materialdialogs.MaterialDialog;
//import com.swotsystemltd.agroindustrialtrust.R;
//import com.swotsystemltd.agroindustrialtrust.model.ChangePassword;
//import com.swotsystemltd.agroindustrialtrust.retrofit.RetrofitApiClient;
//import com.swotsystemltd.agroindustrialtrust.utils.Constants;
//import com.swotsystemltd.agroindustrialtrust.utils.CustomProgress;
//import com.swotsystemltd.agroindustrialtrust.utils.NetUtils;
//
//import java.util.concurrent.atomic.AtomicReference;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//
//public class ChangePasswordActivity extends AppCompatActivity {
//
//    @BindView(R.id.emailInput)
//    EditText emailInput;
//    @BindView(R.id.et_old_passwd)
//    EditText et_old_passwd;
//    @BindView(R.id.et_new_password)
//    EditText et_new_password;
//    @BindView(R.id.et_new_password_retype)
//    EditText et_new_password_retype;
//
//    @BindView(R.id.btn_send)
//    Button btnSend;
//
//    String given_mobile_number,new_password,new_password_retype;
//    String mobile_number="";
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_change_password);
//        ButterKnife.bind(this);
//
//        ActionBar ab = ((AppCompatActivity) this).getSupportActionBar();
//        if (ab != null) {
//            ab.setDisplayHomeAsUpEnabled(true);
//        }
//
//        init();
//
////        mobile_number = com.mygasbd.mygascustomernew2.data_source.SharedData.getCustomerPhone(this);
////        Log.d("tag13", "mobile_number: "+mobile_number);
////        if (mobile_number.equals(null) || mobile_number.isEmpty()){
////
////            new MaterialDialog.Builder(this)
////                    .title("Password Status")
////                    .content("You have to register to get password")
////                    .positiveText("")
////                    .negativeText("Ok")
////                    .show();
////
////        }else {
////            requestPasswordReset(mobile_number);
////        }
//
//    }
//
//    private void init() {
//        et_old_passwd = findViewById(R.id.et_old_passwd);
//        et_new_password = findViewById(R.id.et_new_password);
//        et_new_password_retype = findViewById(R.id.et_new_password_retype);
//        btnSend = findViewById(R.id.btn_send);
//
//        given_mobile_number = et_old_passwd.getText().toString().trim();
//        new_password = et_new_password.getText().toString().trim();
//        new_password_retype = et_new_password_retype.getText().toString().trim();
//
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("tag13", "et_old_passwd: "+et_old_passwd +" new_password: "+new_password +" new_password_retype: "+new_password_retype );
//
//                if (NetUtils.isNetworkAvailable(ChangePasswordActivity.this)){
//                    passwordReset(et_old_passwd.getText().toString().trim(),et_new_password.getText().toString().trim(),
//                            et_new_password_retype.getText().toString().trim());
//                }else {
//                    NetUtils.noInternetWarning(v,ChangePasswordActivity.this);
//                }
//
//            }
//        });
//
//    }
//
//
//
//    @SuppressLint("CheckResult")
//    public AtomicReference<String> passwordReset(String et_old_passwd, String et_new_password, String et_retype_new_password) {
////        showProgress();
//        CustomProgress customProgress = CustomProgress.getInstance();
//        customProgress.showProgress(this, "Please wait...", true);
//
//        String token =  Credential.getToken(this);
//        String authorization = "Bearer"+" "+ token;
//        String accept = "application/json";
//
//        String deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
//
//        AtomicReference<String> flag = new AtomicReference<>("");
//        RetrofitApiClient.getApiInterface().change_password(authorization, accept, et_old_passwd,et_new_password, et_retype_new_password)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        response -> {
////                            hideProgress();
//                            customProgress.hideProgress();
//
//                            if (response.code() == 200) {
//                                flag.set("true");
//                                String responseString = new String(response.body().toString());
//                                Log.d(Constants.tag, "Response String:" + responseString);
////                                Toast.makeText(ChangePasswordActivity.this,"Your pin is submitted to the mobile", Toast.LENGTH_SHORT).show();
//
//                                ChangePassword changePasswordResponse = response.body();
//                                boolean success = changePasswordResponse.getSuccess();
//                                String message = changePasswordResponse.getMessage();
//
//                                if (success){
//                                    new MaterialDialog.Builder(this)
//                                            .title("Password Status")
//                                            .content(message)
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                                                    Intent i = new Intent(ChangePasswordActivity.this, AccountVerificationActivity.class);
//                                                    startActivity(i);
//                                                    finish();
//                                                }
//                                            }).show();
//
//
//
//
//
//                                }else {
//                                    new MaterialDialog.Builder(this)
//                                            .title("Password Status")
//                                            .content(message)
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .show();
//                                }
//
//
//
////
//
//                            } else {
//                                String responseString = new String(response.errorBody().bytes());
//                                Log.d(Constants.tag, "Error body:" + responseString);
//                                new MaterialDialog.Builder(this)
//                                        .title("Please type mobile number correctly")
//                                        .content("")
//                                        .positiveText("")
//                                        .negativeText("Ok")
//                                        .show();
//                            }
//                        },
//                        error -> {
//                            hideProgress();
//                            Log.d(Constants.tag, "Error on Reset Pin:", error);
//                            new MaterialDialog.Builder(this)
//                                    .title("Please type right mobile number")
//                                    .content("")
//                                    .positiveText("")
//                                    .negativeText("Ok")
//                                    .show();
//                        },
//                        () -> {
//
//                        }
//                );
//
//        return flag;
//    }
//
//
//
//
//
//
//    public void showProgress() {
//        progress = new ProgressDialog(this);
//        progress.setMessage("please wait.");
//        progress.show();
//    }
//
//    public void hideProgress() {
//
//        if (progress != null && progress.isShowing()) {
//            progress.dismiss();
//        }
//    }
//
//    private ProgressDialog progress;
//
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
//                    getSupportFragmentManager().popBackStack();
//                }
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//
//
//
//
//}
