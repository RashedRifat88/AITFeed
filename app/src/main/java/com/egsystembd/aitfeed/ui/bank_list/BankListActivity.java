package com.egsystembd.aitfeed.ui.bank_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.egsystembd.aitfeed.R;
import com.egsystembd.aitfeed.credential.Credential;
import com.egsystembd.aitfeed.model.AitBankList;
import com.egsystembd.aitfeed.retrofit.RetrofitApiClient;
import com.egsystembd.aitfeed.ui.bank_list.adapter.BankListAdapter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BankListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    BankListAdapter bankListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);

        initStatusBar();
        initView();
        getProductListData();
    }

    private void initStatusBar() {
        View decor = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary, this.getTheme()));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
//            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            decor.setSystemUiVisibility(decor.getSystemUiVisibility() & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //set status text  light
        }

    }


    private void initView() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bankListAdapter = new BankListAdapter(this);
        recyclerView.setAdapter(bankListAdapter);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);

    }

    @SuppressLint("CheckResult")
    private void getProductListData() {

        showProgressDialog();

        String token =  Credential.getToken(this);
        String authorization = "Bearer"+" "+ token;
        String accept = "application/json";

        RetrofitApiClient.getApiInterface().getAitBankList(authorization, accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.code() == 200) {
                                closeProgressDialog();
                                String responseString = new String(response.message());
                                Log.d("tag22222", "Response String:" + responseString);
                                AitBankList aitBankList = response.body();

                                List<AitBankList.Data> bankLists = aitBankList.getData();
//
//                                }
                                if (bankLists.isEmpty() || bankLists == null) {
                                    closeProgressDialog();

                                    new MaterialDialog.Builder(this)
                                            .title("No Data Found For This Account")
                                            .content("")
                                            .positiveText("")
                                            .negativeText("Ok")
                                            .show();
                                } else {
                                    bankListAdapter.setData(bankLists);
                                    bankListAdapter.notifyDataSetChanged();
//                                    new MaterialDialog.Builder(this)
//                                            .title("Problem in bank list data")
//                                            .content("")
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .show();
                                }

//                                List<ProductGasCustomer> bankResponse = response.body();


                            } else {
                                Log.d("tag1", "Primary block error ");
                            }
                        },error -> {
//                            closeProgressDialog();
                            Log.d("tag1", "some error ", error);
                        },
                        () -> {
                            Log.d("tag1", "final block error ");
                        }
                );
    }



    ProgressDialog progressDialog;

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait ...");
        progressDialog.show();
    }

    private void closeProgressDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }




}