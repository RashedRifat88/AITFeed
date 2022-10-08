package com.egsystembd.aitfeed.ui.ledger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.egsystembd.aitfeed.R;
import com.egsystembd.aitfeed.credential.Credential;
import com.egsystembd.aitfeed.model.Ledger;
import com.egsystembd.aitfeed.retrofit.RetrofitApiClient;
import com.egsystembd.aitfeed.ui.ledger.adapter.LedgerAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LedgerActivity extends AppCompatActivity {

    Context context;
    private static View mView;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    LedgerAdapter ledgerAdapter;
    private SearchView searchView;
    private EditText etSearch;
    private SearchView.OnQueryTextListener queryTextListener;
    boolean keyDel = false;
    private int previousLength;
    private boolean backSpace;

    ArrayList<String> transactionDates = new ArrayList<>();
    ArrayList<String> transactionIds = new ArrayList<>();
    ArrayList<String> transactionTypes = new ArrayList<>();
    ArrayList<String> saleAmounts = new ArrayList<>();
    ArrayList<String> paidAmounts = new ArrayList<>();
    ArrayList<String> balances = new ArrayList<>();

    List<Ledger.DealerLedgerList> dealerLedgerList;

    static TextView txtStartDate, txtEndDate, txtOpeningBalance, txt_total_sale, txt_total_collection;
    LinearLayout linear1, linear2, linear3;
    Button btnSearch;
    static String startDate = "", endDate = "", openingBalance = "";
    TableLayout tl;
    HorizontalScrollView horizontal1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledger);

        initView();
        datePickerAndSearch();

    }


    private void buildArrayLists() {
        for (Ledger.DealerLedgerList m : dealerLedgerList) {
            transactionDates.add(m.getDate());
            transactionIds.add(m.getTransactionId());
            transactionTypes.add(m.getTransactionType());
            saleAmounts.add(m.getSaleAmount());
            paidAmounts.add(m.getPaidAmount());
            balances.add(m.getBalance());
        }
    }



    private void clearArrayLists() {
        transactionDates.clear();
        transactionIds.clear();
        transactionTypes.clear();
        saleAmounts.clear();
        paidAmounts.clear();
        balances.clear();

    }




    private void initView() {
        txtStartDate = findViewById(R.id.txtStartDate);
        txtEndDate = findViewById(R.id.txtEndDate);
        txtOpeningBalance = findViewById(R.id.txtOpeningBalance);
        txt_total_sale = findViewById(R.id.txt_total_sale);
        txt_total_collection = findViewById(R.id.txt_total_collection);
        btnSearch = findViewById(R.id.btnSearch);
        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);

        tl = findViewById(R.id.table);
        horizontal1 = findViewById(R.id.horizontal1);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //recyclerView.addItemDecoration(dividerItemDecoration);
        //txtMessage = (TextView)view.findViewById(R.id.txtMessage);
        ledgerAdapter = new LedgerAdapter(this);
        recyclerView.setAdapter(ledgerAdapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);

    }

    private void datePickerAndSearch() {

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.setFlag(DatePickerFragment.FLAG_START_DATE);
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.setFlag(DatePickerFragment.FLAG_END_DATE);
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFilteredDataFromWeb();
            }
        });

    }


//    @Override
//    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//        Calendar c = Calendar.getInstance();
//        c.set(Calendar.YEAR, year);
//        c.set(Calendar.MONTH, month);
//        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
//
//        txtStartDate.setText(currentDateString);
//        startDate = dayOfMonth+"/"+String.valueOf(month)+"/"+String.valueOf(year);
//        Log.d("tag9999","startDate: "+startDate+ "view: "+view);
//
//    }


    @SuppressLint("ValidFragment")
    public static class DatePickerFragment extends DialogFragment implements
            DatePickerDialog.OnDateSetListener {
        public static final int FLAG_START_DATE = 0;
        public static final int FLAG_END_DATE = 1;

        private int flag = 0;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void setFlag(int i) {
            flag = i;
        }

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(year, monthOfYear, dayOfMonth);
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            if (flag == FLAG_START_DATE) {
                startDate = format.format(calendar.getTime());
                txtStartDate.setText(format.format(calendar.getTime()));
                Log.d("tag9999", "startDate: " + startDate);
            } else if (flag == FLAG_END_DATE) {
                endDate = format.format(calendar.getTime());
                txtEndDate.setText(format.format(calendar.getTime()));
                Log.d("tag9999", "endDate: " + endDate);
            }
        }


    }


    private void getData() {
        showProgressDialog();

        getLedgerData();

    }


    @SuppressLint("CheckResult")
    private void getLedgerData() {

//        showProgressDialog();
        String token = Credential.getToken(this);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";


        RetrofitApiClient.getApiInterface().getLedger(authorization, accept, startDate, endDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            Log.d("tag1111", "response code : " + response.code());
                            Log.d("tag1111", "response message() : " + response.message());
                            if (response.code() == 200) {
                                closeProgressDialog();

                                Ledger productResponse = response.body();
                                Log.d("tag1111", "OrderList response : " + productResponse.toString());
                                Log.d("tag1111", "response code : " + response.code());
                                Log.d("tag1111", "response getMessage : " + productResponse.getMessage());
                                Log.d("tag1111", "response getSuccess : " + productResponse.getSuccess());

                                dealerLedgerList = productResponse.getDealerLedgerList();
                                Log.d("tag1111", "OrderList getOrderList : " + dealerLedgerList);

                                if (dealerLedgerList.isEmpty() || dealerLedgerList == null) {
                                    closeProgressDialog();

                                    new MaterialDialog.Builder(context)
                                            .title("No Data Found For This Account")
                                            .content("")
                                            .positiveText("")
                                            .negativeText("Ok")
                                            .show();
                                } else {
                                    ledgerAdapter.setData(dealerLedgerList);
                                    ledgerAdapter.notifyDataSetChanged();
//                                    new MaterialDialog.Builder(context)
//                                            .title("Problem in product list data")
//                                            .content("")
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .show();

                                    buildArrayLists();
                                    addTable1();

                                    txtOpeningBalance.setText(productResponse.getTotal().getOpening_balance());
                                    txt_total_sale.setText(productResponse.getTotal().getTotal_sale());
                                    txt_total_collection.setText(productResponse.getTotal().getTotal_paid());
                                }


                            } else {
                                Log.d("tag1111", "Primary block error ");
                            }
                        }, error -> {
                            closeProgressDialog();
                            Log.d("tag1111", "some error ", error);
                        },
                        () -> {
                            Log.d("tag1", "final block error ");
                        }
                );
    }




    @SuppressLint("CheckResult")
    private void getFilteredDataFromWeb() {

        showProgressDialog();
        String token = Credential.getToken(this);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";


        RetrofitApiClient.getApiInterface().getLedger(authorization, accept, startDate, endDate)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.code() == 200) {
                                closeProgressDialog();

                                Ledger productResponse = response.body();
                                Log.d("tag1111", "OrderList response : " + productResponse.toString());
                                Log.d("tag1111", "response code : " + response.code());
                                Log.d("tag1111", "response getMessage : " + productResponse.getMessage());
                                Log.d("tag1111", "response getSuccess : " + productResponse.getSuccess());
                                Log.d("tag1111", "startDate : " + startDate);
                                Log.d("tag1111", "endDate : " + endDate);

                                dealerLedgerList = productResponse.getDealerLedgerList();
                                Log.d("tag1111", "OrderList getOrderList : " + dealerLedgerList);

                                if (dealerLedgerList.isEmpty() || dealerLedgerList == null) {
                                    closeProgressDialog();

                                    new MaterialDialog.Builder(context)
                                            .title("No Data Found For This Account")
                                            .content("")
                                            .positiveText("")
                                            .negativeText("Ok")
                                            .show();
                                } else {

                                    clearArrayLists();
                                    removeTable();


                                    ledgerAdapter.setData(dealerLedgerList);
                                    ledgerAdapter.notifyDataSetChanged();


                                    buildArrayLists();
                                    addTable1();
                                }


                            } else {
                                Log.d("tag1", "Primary block error ");
                            }
                        }, error -> {
                            closeProgressDialog();
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
        progressDialog.setMessage("Please wait ....");
        progressDialog.show();
    }

    private void closeProgressDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }


    /////


    private void removeTable(){
//        horizontal1.t1.removeAllViews();
        tl.removeAllViews();
    }


    private void addTable1() {
        addHeaders();
        addData();
    }


    private TextView getTextView(int id, String title, int color, int typeface, int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextSize(12);
        tv.setTextColor(color);
        tv.setPadding(10, 25, 10, 25);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundColor(bgColor);
        tv.setLayoutParams(getLayoutParams());
//        tv.setOnClickListener(LedgerActivity.this);
        return tv;
    }

    @NonNull
    private TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(2, 0, 0, 2);
        return params;
    }

    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT);
    }

    /**
     * This function add the headers to the table
     **/
    public void addHeaders() {
        tl = findViewById(R.id.table);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "Date", Color.WHITE, Typeface.BOLD, Color.DKGRAY));
        tr.addView(getTextView(0, "Tran. Id", Color.WHITE, Typeface.BOLD, Color.DKGRAY));
        tr.addView(getTextView(0, "Tran. Type", Color.WHITE, Typeface.BOLD, Color.DKGRAY));
        tr.addView(getTextView(0, "Sale Amount", Color.WHITE, Typeface.BOLD, Color.DKGRAY));
        tr.addView(getTextView(0, "Paid Amount", Color.WHITE, Typeface.BOLD, Color.DKGRAY));
        tr.addView(getTextView(0, "Balance", Color.WHITE, Typeface.BOLD, Color.DKGRAY));
        tl.addView(tr, getTblLayoutParams());
    }


    public void addData() {
        int numProducts = transactionDates.size();
        tl = findViewById(R.id.table);
        for (int i = 0; i < numProducts; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(getLayoutParams());
//
//            tr.addView(getTextView(i + 1, transactionDates.get(i), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.textHintColorPrimary)));
//            tr.addView(getTextView(i + numProducts, transactionIds.get(i), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent2)));
//            tr.addView(getTextView(i + numProducts, transactionTypes.get(i), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent2)));
//            tr.addView(getTextView(i + numProducts, saleAmounts.get(i), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent2)));
//            tr.addView(getTextView(i + numProducts, paidAmounts.get(i), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent2)));


            tr.addView(getTextView(i, transactionDates.get(i), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.textHintColorPrimary)));
            tr.addView(getTextView(i, transactionIds.get(i), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i, transactionTypes.get(i), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i, saleAmounts.get(i), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i, paidAmounts.get(i), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));
            tr.addView(getTextView(i, balances.get(i), Color.WHITE, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)));

            tl.addView(tr, getTblLayoutParams());
        }
    }


    //////


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                }
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}