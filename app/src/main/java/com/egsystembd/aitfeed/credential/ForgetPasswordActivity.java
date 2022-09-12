//package com.egsystembd.aitfeed.credential;
//
//import android.annotation.SuppressLint;
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.provider.Settings;
//import android.util.Log;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.afollestad.materialdialogs.DialogAction;
//import com.afollestad.materialdialogs.MaterialDialog;
//
//
//import java.util.concurrent.atomic.AtomicReference;
//
//
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.schedulers.Schedulers;
//
//public class ForgetPasswordActivity extends AppCompatActivity {
//
//    @BindView(R.id.et_mobile_number)
//    EditText et_mobile_number;
////    @BindView(R.id.et_old_passwd)
////    EditText et_old_passwd;
////    @BindView(R.id.et_new_password)
////    EditText et_new_password;
////    @BindView(R.id.et_new_password_retype)
////    EditText et_new_password_retype;
//
//    @BindView(R.id.btn_send)
//    Button btnSend;
//
//    Button btn_send;
//
//    String given_mobile_number,new_password,new_password_retype;
//    String mobile_number="";
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_forget_password);
//        ButterKnife.bind(this);
//
//        ActionBar ab = ((AppCompatActivity) this).getSupportActionBar();
//        if (ab != null) {
//            ab.setDisplayHomeAsUpEnabled(true);
//        }
//
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
//        et_mobile_number = findViewById(R.id.et_mobile_number);
//        btn_send = findViewById(R.id.btn_send);
//
////        given_mobile_number = et_mobile_number.getText().toString().trim();
//
//
//        btn_send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (NetUtils.isNetworkAvailable(ForgetPasswordActivity.this)){
//                    passwordReset(et_mobile_number.getText().toString().trim());
//                }else {
//                    NetUtils.noInternetWarning(v,ForgetPasswordActivity.this);
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
//    public AtomicReference<String> passwordReset(String mobile_number) {
////        showProgress();
//        CustomProgress customProgress = CustomProgress.getInstance();
//        customProgress.showProgress(this, "Please wait...", true);
//
//        String token =  com.swotsystemltd.agroindustrialtrust.credential.Credential.getToken(this);
//        String authorization = "Bearer"+" "+ token;
//        String accept = "application/json";
//
//        String deviceId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
//
//        AtomicReference<String> flag = new AtomicReference<>("");
//        RetrofitApiClient.getApiInterface().reset_password(mobile_number)
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
//                                ResetPassword changePasswordResponse = response.body();
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
//                                                    Intent i = new Intent(ForgetPasswordActivity.this, AccountVerificationActivity.class);
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
//}
