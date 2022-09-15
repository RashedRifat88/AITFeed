package com.egsystembd.aitfeed.credential;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.egsystembd.aitfeed.MainActivity;
import com.egsystembd.aitfeed.R;
import com.egsystembd.aitfeed.data.SharedData;
import com.egsystembd.aitfeed.model.DeviceVerifyLoginModel;
import com.egsystembd.aitfeed.model.LoginModel;
import com.egsystembd.aitfeed.model.UserDetails;
import com.egsystembd.aitfeed.retrofit.RetrofitApiClient;
import com.egsystembd.aitfeed.utils.CustomProgress;
import com.egsystembd.aitfeed.utils.NetUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {


    EditText userNameInput;
    EditText passwordInput;
    Button btnVerify;
    TextView txtRegister, txtForgetPassword;

    String username;
    String password;
    String message1 = "";

    String verification_code = "";

    String versionName = "";
    String versionNameFromServer = "";
    int versionCode = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initStatusBar();
        getVersionInfo();

        userNameInput = findViewById(R.id.userNameInput);
        passwordInput = findViewById(R.id.passwordInput);
        btnVerify = findViewById(R.id.button_verify);
//        txtRegister = findViewById(R.id.txt_register_dealer);
        txtForgetPassword = findViewById(R.id.txt_forget_password);


        userNameInput.setText(Credential.getUserEmail(LoginActivity.this));
        username = userNameInput.getText().toString();
        password = passwordInput.getText().toString();
        Log.d("tag_u_n", "username  :  " + username + "password  :  " + password);


//        if (!Credential.getMobileVerificationStatus(this)) {
//            txtForgetPassword.setVisibility(View.GONE);
//        }


        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (NetUtils.isNetworkAvailable(LoginActivity.this)) {
//                    onClickVerify(userNameInput.getText().toString(), passwordInput.getText().toString());
//                    getUserInfo();
//                } else {
//                    NetUtils.noInternetWarning(v, LoginActivity.this);
//                }

                onClickVerify(userNameInput.getText().toString(), passwordInput.getText().toString());
                getUserInfo();

            }
        });


        txtForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
//                startActivity(i);
            }
        });


        /////

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
//                && checkSelfPermission(Manifest.permission.RECEIVE_SMS)
//                != PackageManager.PERMISSION_GRANTED) {
//            requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, 1000);
//
//        }


    }



    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary2, this.getTheme()));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary2));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
        }

    }


    //////////////////////////


//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == 1000) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Permission Granted.", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(this, "Permission is not Granted!", Toast.LENGTH_SHORT).show();
//                finish();
//            }
//        }
//    }



    @SuppressLint("CheckResult")
    public void onClickVerify(String uname, String passwd) {
//        showProgress();
        CustomProgress customProgress = CustomProgress.getInstance();
        customProgress.showProgress(this, "Please wait...", true);

        String device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        Credential.saveDeviceId(LoginActivity.this, device_id);
        String verify = "0";
        SharedData.saveDeviceId(this, device_id);
        Log.d("tag20", "device id  :  " + device_id);
        Log.d("tag20", "In api call username  :  " + uname + "password  :  " + passwd);

        RetrofitApiClient.getApiInterface().verifyAccount(uname, passwd, device_id, verify)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.code() == 200) {
                                Log.d("tag21", "device id  :  " + device_id);
//                                hideProgress();
//                                customProgress.hideProgress();
                                String responseString = response.message();
                                Log.d("tag3344", "Response String:" + responseString);

//                                Response<AccountVerificationModel> loginModel1 = response;
                                LoginModel loginModel = response.body();
//                                boolean status = loginModel.getStatus();
                                boolean status = loginModel.getSuccess();
                                String status2 = loginModel.getMessage();
                                String token = loginModel.getData().getToken().toString();
                                String message = loginModel.getMessage();
                                String user_name = loginModel.getData().getName();
                                String email = loginModel.getData().getEmail();
                                String address = loginModel.getData().getAddress();
                                String verification = loginModel.getData().getVerification();
                                versionNameFromServer = loginModel.getData().getVersion_name();

                                Log.d("tag3344", "Response Status: " + status);
                                Log.d("tag20", "Response Status1: " + status);
                                Log.d("tag20", "message " + message);
                                Log.d("tag20", "address " + address);
                                Log.d("tag20", "versionNameFromServer: " + versionNameFromServer);
                                Log.d("tag20", "versionName: " + versionName);

                                Log.d("tag20", "token in onClickVerify: " + token);

                                Credential.saveToken(LoginActivity.this, token);

//                                customProgress.showProgress(LoginActivity.this, "Verifying... Please wait...", true);


                                if (versionNameFromServer.equalsIgnoreCase(versionName)) {

                                    if (status) {

                                        if (!verification.equalsIgnoreCase("success")) {
                                            Log.d("tag21", "verification: " + verification);
                                            Credential.saveToken(LoginActivity.this, token);

                                        } else {
                                            Credential.saveUserName(LoginActivity.this, user_name);
                                            Credential.saveUserEmail(LoginActivity.this, email);
                                            Credential.saveUserAddress(LoginActivity.this, address);
                                            Credential.savePin(LoginActivity.this, passwd);
                                            Credential.saveToken(LoginActivity.this, token);
//
                                            UserState.setToLoggedInState(LoginActivity.this);

                                            Intent intent = new Intent(this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }

                                    } else {
                                        new MaterialDialog.Builder(LoginActivity.this)
                                                .title("Status")
                                                .content("Login Status: " + message)
                                                .positiveText("")
                                                .negativeText("Ok")
                                                .show();
                                    }


                                } else {
                                    new MaterialDialog.Builder(LoginActivity.this)
                                            .title("ভার্সন আপডেট")
                                            .content("আপনি AIT Feed অ্যাপ এর পুরনো ভার্সন ব্যবহার করছেন। দয়াকরে আপডেট করুন।")
                                            .positiveText("")
                                            .negativeText("Update")
                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
                                                @Override
                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//
                                                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                                                    try {
                                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                                                    } catch (android.content.ActivityNotFoundException anfe) {
                                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                                                    }

                                                }
                                            })
                                            .show();
                                }

                            } else {


                                String responseString = new String(response.errorBody().bytes());
//                                String responseString = response.message();
                                if (responseString.equalsIgnoreCase("{\"success\":false,\"message\":\"Username or Password does not match.\"}"))
                                    responseString = "Username or Password does not match.";

                                new MaterialDialog.Builder(LoginActivity.this)
                                        .title("Status")
                                        .content("Login Status: " + responseString)
                                        .positiveText("")
                                        .negativeText("Ok")
                                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                                            @Override
                                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                                customProgress.hideProgress();
                                            }
                                        })
                                        .show();


                                Log.d("tag20", "responseString " + responseString);


                            }
                        },
                        error -> {
//                            customProgress.hideProgress();
                            new MaterialDialog.Builder(LoginActivity.this)
                                    .title("Status")
                                    .content("Login Status: " + error.getMessage())
                                    .positiveText("")
                                    .negativeText("Ok")
                                    .show();

                            Log.d("tag20", "error.getMessage(): " + error.getMessage());

                        },
                        () -> {
                            Log.d("tag3344", "onComplete");
//                            customProgress.hideProgress();


                        }
                );


    }




//    @SuppressLint("CheckResult")
//    public void onClickVerify(String uname, String passwd) {
////        showProgress();
//        CustomProgress customProgress = CustomProgress.getInstance();
//        customProgress.showProgress(this, "Please wait...", true);
//
//        String device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
//        Credential.saveDeviceId(LoginActivity.this, device_id);
//        String verify = "0";
//        SharedData.saveDeviceId(this, device_id);
//        Log.d("tag20", "device id  :  " + device_id);
//        Log.d("tag20", "In api call username  :  " + uname + "password  :  " + passwd);
//
//        RetrofitApiClient.getApiInterface().verifyAccount(uname, passwd, device_id, verify)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//                            if (response.code() == 200) {
//                                Log.d("tag21", "device id  :  " + device_id);
////                                hideProgress();
////                                customProgress.hideProgress();
//                                String responseString = response.message();
//                                Log.d("tag20", "Response String:" + responseString);
//
////                                Response<AccountVerificationModel> loginModel1 = response;
//                                LoginModel loginModel = response.body();
////                                boolean status = loginModel.getStatus();
//                                boolean status = loginModel.getSuccess();
//                                String status2 = loginModel.getMessage();
//                                String token = loginModel.getData().getToken();
//                                String message = loginModel.getMessage();
//                                String user_name = loginModel.getData().getName();
//                                String email = loginModel.getData().getEmail();
//                                String address = loginModel.getData().getAddress();
//                                String verification = loginModel.getData().getVerification();
//                                versionNameFromServer = loginModel.getData().getVersion_name();
//
//                                Log.d("tag20", "Response Status: " + status);
//                                Log.d("tag20", "Response Status1: " + status);
//                                Log.d("tag20", "message " + message);
//                                Log.d("tag20", "address " + address);
//                                Log.d("tag20", "versionNameFromServer: " + versionNameFromServer);
//                                Log.d("tag20", "versionName: " + versionName);
//
//                                Log.d("tag20", "token in onClickVerify: " + token);
//
//                                Credential.saveToken(LoginActivity.this, token);
//
////                                customProgress.showProgress(LoginActivity.this, "Verifying... Please wait...", true);
//
//
//                                if (versionNameFromServer.equalsIgnoreCase(versionName)) {
//
//                                    if (status) {
//
//                                        if (!verification.equalsIgnoreCase("success")) {
//                                            Log.d("tag21", "verification: " + verification);
//                                            Credential.saveToken(LoginActivity.this, token);
//
//                                        } else {
//                                            Credential.saveUserName(LoginActivity.this, user_name);
//                                            Credential.saveUserEmail(LoginActivity.this, email);
//                                            Credential.saveUserAddress(LoginActivity.this, address);
//                                            Credential.savePin(LoginActivity.this, passwd);
//                                            Credential.saveToken(LoginActivity.this, token);
////
//                                            UserState.setToLoggedInState(LoginActivity.this);
//
//                                            Intent intent = new Intent(this, MainActivity.class);
//                                            startActivity(intent);
//                                            finish();
//                                        }
//
//                                    } else {
//                                        new MaterialDialog.Builder(LoginActivity.this)
//                                                .title("Status")
//                                                .content("Login Status: " + message)
//                                                .positiveText("")
//                                                .negativeText("Ok")
//                                                .show();
//                                    }
//
//
//                                } else {
//                                    new MaterialDialog.Builder(LoginActivity.this)
//                                            .title("ভার্সন আপডেট")
//                                            .content("আপনি AIT Feed অ্যাপ এর পুরনো ভার্সন ব্যবহার করছেন। দয়াকরে আপডেট করুন।")
//                                            .positiveText("")
//                                            .negativeText("Update")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
////
//                                                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
//                                                    try {
//                                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
//                                                    } catch (android.content.ActivityNotFoundException anfe) {
//                                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
//                                                    }
//
//                                                }
//                                            })
//                                            .show();
//                                }
//
//                            } else {
//
//
//                                String responseString = new String(response.errorBody().bytes());
////                                String responseString = response.message();
//                                if (responseString.equalsIgnoreCase("{\"success\":false,\"message\":\"Username or Password does not match.\"}"))
//                                    responseString = "Username or Password does not match.";
//
//                                new MaterialDialog.Builder(LoginActivity.this)
//                                        .title("Status")
//                                        .content("Login Status: " + responseString)
//                                        .positiveText("")
//                                        .negativeText("Ok")
//                                        .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                            @Override
//                                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                                                customProgress.hideProgress();
//                                            }
//                                        })
//                                        .show();
//
//
//                                Log.d("tag20", "responseString " + responseString);
//
//
//                            }
//                        },
//                        error -> {
////                            customProgress.hideProgress();
//                            new MaterialDialog.Builder(LoginActivity.this)
//                                    .title("Status")
//                                    .content("Login Status: " + error.getMessage())
//                                    .positiveText("")
//                                    .negativeText("Ok")
//                                    .show();
//
//                            Log.d("tag20", "error.getMessage(): " + error.getMessage());
//
//                        },
//                        () -> {
//                            Log.d("tag20", "onComplete");
////                            customProgress.hideProgress();
//
//
//                        }
//                );
//
//
//    }




//    @SuppressLint("CheckResult")
//    public void onClickVerify(String uname, String passwd) {
////        showProgress();
//        CustomProgress customProgress = CustomProgress.getInstance();
//        customProgress.showProgress(this, "Please wait...", true);
//
//        String device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
//        Credential.saveDeviceId(LoginActivity.this, device_id);
//        String verify = "0";
//        SharedData.saveDeviceId(this, device_id);
//        Log.d("tag20", "device id  :  " + device_id);
//        Log.d("tag20", "In api call username  :  " + uname + "password  :  " + passwd);
//
//        RetrofitApiClient.getApiInterface().verifyAccount(uname, passwd, device_id, verify)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//                            if (response.code() == 200) {
//                                Log.d("tag21", "device id  :  " + device_id);
////                                hideProgress();
////                                customProgress.hideProgress();
//                                String responseString = response.message();
//                                Log.d("tag333", "Response String:" + responseString);
//
////                                Response<AccountVerificationModel> loginModel1 = response;
//                                LoginModel loginModel = response.body();
////                                boolean status = loginModel.getStatus();
//                                boolean status = loginModel.getSuccess();
//                                String status2 = loginModel.getMessage();
//                                String token = loginModel.getData().getToken();
//                                String message = loginModel.getMessage();
//                                String user_name = loginModel.getData().getName();
//                                String email = loginModel.getData().getEmail();
//                                String address = loginModel.getData().getAddress();
//                                String verification = loginModel.getData().getVerification();
//                                versionNameFromServer = loginModel.getData().getVersion_name();
//
//                                Log.d("tag333", "Response Status: " + status);
//                                Log.d("tag20", "Response Status1: " + status);
//                                Log.d("tag20", "message " + message);
//                                Log.d("tag20", "address " + address);
//                                Log.d("tag20", "versionNameFromServer: " + versionNameFromServer);
//                                Log.d("tag20", "versionName: " + versionName);
//
//                                Log.d("tag20", "token in onClickVerify: " + token);
//
//                                Credential.saveToken(LoginActivity.this, token);
//
////                                customProgress.showProgress(LoginActivity.this, "Verifying... Please wait...", true);
//
//
//                                if (versionNameFromServer.equalsIgnoreCase(versionName)) {
//
//                                    if (status) {
//
//                                        if (!verification.equalsIgnoreCase("success")) {
//                                            Log.d("tag21", "verification: " + verification);
//                                            Credential.saveToken(LoginActivity.this, token);
//
//                                        } else {
//                                            Credential.saveUserName(LoginActivity.this, user_name);
//                                            Credential.saveUserEmail(LoginActivity.this, email);
//                                            Credential.saveUserAddress(LoginActivity.this, address);
//                                            Credential.savePin(LoginActivity.this, passwd);
//                                            Credential.saveToken(LoginActivity.this, token);
////
//                                            UserState.setToLoggedInState(LoginActivity.this);
//
//                                            Intent intent = new Intent(this, MainActivity.class);
//                                            startActivity(intent);
//                                            finish();
//                                        }
//
//                                    } else {
//                                        new MaterialDialog.Builder(LoginActivity.this)
//                                                .title("Status")
//                                                .content("Login Status: " + message)
//                                                .positiveText("")
//                                                .negativeText("Ok")
//                                                .show();
//                                    }
//
//
//                                } else {
//                                    new MaterialDialog.Builder(LoginActivity.this)
//                                            .title("ভার্সন আপডেট")
//                                            .content("আপনি AIT Feed অ্যাপ এর পুরনো ভার্সন ব্যবহার করছেন। দয়াকরে আপডেট করুন।")
//                                            .positiveText("")
//                                            .negativeText("Update")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
////
//                                                    final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
//                                                    try {
//                                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
//                                                    } catch (android.content.ActivityNotFoundException anfe) {
//                                                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
//                                                    }
//
//                                                }
//                                            })
//                                            .show();
//                                }
//
//                            } else {
//
//
//                                String responseString = new String(response.errorBody().bytes());
////                                String responseString = response.message();
//                                if (responseString.equalsIgnoreCase("{\"success\":false,\"message\":\"Username or Password does not match.\"}"))
//                                    responseString = "Username or Password does not match.";
//
//                                new MaterialDialog.Builder(LoginActivity.this)
//                                        .title("Status")
//                                        .content("Login Status: " + responseString)
//                                        .positiveText("")
//                                        .negativeText("Ok")
//                                        .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                            @Override
//                                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                                                customProgress.hideProgress();
//                                            }
//                                        })
//                                        .show();
//
//
//                                Log.d("tag20", "responseString " + responseString);
//
//
//                            }
//                        },
//                        error -> {
////                            customProgress.hideProgress();
//                            new MaterialDialog.Builder(LoginActivity.this)
//                                    .title("Status")
//                                    .content("Login Status: " + error.getMessage())
//                                    .positiveText("")
//                                    .negativeText("Ok")
//                                    .show();
//
//                            Log.d("tag20", "error.getMessage(): " + error.getMessage());
//
//                        },
//                        () -> {
//                            Log.d("tag333", "onComplete");
////                            customProgress.hideProgress();
//
//
//                        }
//                );
//
//
//    }


    @SuppressLint("CheckResult")
    public void deviceVerifyApiCall(Context context, String verification_code, String device_id, String token) {


        String verification_code_trim = verification_code;
        Log.d("tag20", "verification_code_trim in deviceVerifyApiCall: " + verification_code_trim);

        Log.d("tag20", "device id in deviceVerifyApiCall :  " + device_id);
        String verify = "0";
        Log.d("tag20", "token in deviceVerifyApiCall: " + token);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

        RetrofitApiClient.getApiInterface().verifyDevice(authorization, accept, device_id, verification_code_trim)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {

                            Log.d("tag20", "response.code() in deviceVerifyApiCall:" + response.code());
                            if (response.code() == 200) {

                                String responseString = response.message();
                                Log.d("tag20", "Response String:" + responseString);

                                DeviceVerifyLoginModel loginModel = response.body();
                                boolean status = loginModel.getSuccess();
                                String message = loginModel.getMessage();
                                String token2 = loginModel.getData().getToken();

                                Log.d("tag20", "Response message:" + message);
                                Log.d("tag3", "token2:" + token2);

                                if (message.equalsIgnoreCase("Login successful.")) {
//                                    Credential.saveUserName(LoginActivity.this, user_name);
//                                    Credential.saveUserEmail(LoginActivity.this, email);
//
//                                    Credential.savePin(LoginActivity.this, passwd);
                                    Credential.saveToken(context, token2);
                                    Credential.saveMobileVerificationStatus(context, true);
                                    Log.d("tag3", "token : " + Credential.getToken(context));
                                    Log.d("tag3", "context : " + context);

//                                    gotoMainActivity();
                                    Intent intent = new Intent(context, MainActivity.class);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    context.startActivity(intent);
                                    UserState.setToLoggedInState(context);
                                    finish();
                                }


                                Log.d("tag333", "Response Status: " + status);
                                Log.d("tag20", "message in erification call " + message);
                            } else {

                                String responseString = new String(response.errorBody().bytes());
//                                new MaterialDialog.Builder(context)
//                                        .title("Status....")
//                                        .content("Login Status: " + responseString)
//                                        .positiveText("")
//                                        .negativeText("Ok")
//                                        .show();
//                                customProgress.hideProgress();

                            }
                        },
                        error -> {
//                            customProgress.hideProgress();
//                            new MaterialDialog.Builder(context)
//                                    .title("Error Status...")
//                                    .content(error.getMessage())
//                                    .positiveText("")
//                                    .negativeText("Ok")
//                                    .show();
                        },
                        () -> {
                            Log.d("tag333", "onComplete");
                        }
                );


    }

    private void gotoMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        UserState.setToLoggedInState(LoginActivity.this);
        finish();
    }


    @SuppressLint("CheckResult")
    public void getUserInfo() {
//        showProgress();
        String device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        String token = Credential.getToken(this);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

        RetrofitApiClient.getApiInterface().getUserDetailsInfo(authorization, accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.code() == 200) {

                                String responseString = response.message();
                                Log.d("tag333", "Response String:" + responseString);

//                                Response<AccountVerificationModel> loginModel1 = response;
                                UserDetails userDetailModel = response.body();
                                UserDetails.Success userDetailModelSuccess = userDetailModel.getSuccess();
                                List<UserDetails.Role> userDetailModelRoleList = userDetailModel.getSuccess().getRoles();
                                UserDetails.Role userRoleObj = userDetailModelRoleList.get(0);

                                String userName = userDetailModelSuccess.getName();
                                String userAddress = userDetailModelSuccess.getAddress().toString();
                                Log.d("tag333", "userName:" + userName);
                                String userEmail = userDetailModelSuccess.getEmail();
                                String userRole = userRoleObj.getName();


                                Credential.saveToken(LoginActivity.this, userName);
                                Credential.saveUserName(LoginActivity.this, userName);
                                Credential.saveUserEmail(LoginActivity.this, userEmail);
                                Credential.saveUserRole(LoginActivity.this, userRole);


//                                Log.d("tag333", "Response Status:" + status);


                            } else {
                                String responseString = new String(response.errorBody().bytes());
                                Log.d("tag333", "Error body:" + responseString);
                            }
                        },
                        error -> {
                            Log.d("tag333", "Error getting userdata :", error);

                        },
                        () -> {
                            Log.d("tag333", "onComplete");
                        }
                );


    }


    public void showProgress() {
        progress = new ProgressDialog(this);
        progress.setMessage("please wait...");
        progress.show();
    }

    public void hideProgress() {

        if (progress != null && progress.isShowing()) {
            progress.dismiss();
        }
    }


    private ProgressDialog progress;

    public void setOtp(Context context, String otp, String device_id, String token) {
        verification_code = otp;
        Log.d("tag20", "otp received:" + otp);
        Log.d("tag20", "verification_code received:" + verification_code);

//        methodForApiCall(otp);
        if (!otp.isEmpty()) {
            hideProgress();
        }
        deviceVerifyApiCall(context, otp, device_id, token);
    }


    //get the current version number and name
    private void getVersionInfo() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            versionName = packageInfo.versionName;
            versionCode = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


    }

}