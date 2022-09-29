package com.egsystembd.aitfeed.cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.egsystembd.aitfeed.R;
import com.egsystembd.aitfeed.credential.Credential;
import com.egsystembd.aitfeed.data.DatabaseHelper;
import com.egsystembd.aitfeed.data.SharedData;
import com.egsystembd.aitfeed.model.ErrorResponse;
import com.egsystembd.aitfeed.model.MakeOrder;
import com.egsystembd.aitfeed.retrofit.RetrofitApiClient;
import com.egsystembd.aitfeed.ui.payment.PaymentActivity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CheckoutActivity extends AppCompatActivity {

    private static Double dTotalPrice = 0.0;
    private List<CartModel> mCartList;
    private List<String> deliveryAreaList = new ArrayList<>();


    ArrayList<String> productIds = new ArrayList<>();
    ArrayList<String> productNames = new ArrayList<>();
    ArrayList<String> prices = new ArrayList<>();
    ArrayList<String> quantities = new ArrayList<>();
    ArrayList<String> bagSizes = new ArrayList<>();
    ArrayList<String> totalPrices = new ArrayList<>();
    ArrayList<String> productDirectRecoveries = new ArrayList<>();
    ArrayList<String> productVolumes = new ArrayList<>();
    private static String subTotalPrice;
    private static Double totalPayableNetPrice;
    private Double sumOfPrice = 0.0;

    EditText et_truck_driver_name, et_truck_driver_mobile, et_truck_driver_reg_no;
    TextView tvUserName, tvUserPhone, tvUserAddress;
    String userId, name, email, phone, address;
    Button btn_order_now;

    JSONObject finalobject;
    private DatabaseHelper db;

    Spinner spinnerArea;
    ArrayAdapter<String> dataAdapter;
    String sp1SelectedValue = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);


        db = new DatabaseHelper(this);
        mCartList = db.getAllCartItems();

        initStatusBar();
        initview();
        loadArrayData();
        setTotalPayableNetPrice();
        setTextData();
        addTable1();

        getDeliveryArea();
        loadSpinnerArea();

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

    private void setTextData() {
        userId = SharedData.getCustomerId(this);
        name = SharedData.getCustomerName(this);
        email = SharedData.getCustomerEmail(this);
        phone = SharedData.getCustomerPhone(this);
        address = SharedData.getCustomerAddress(this);

        tvUserName.setText(name);
        tvUserPhone.setText(phone);
        tvUserAddress.setText(address);

    }


    public void loadSpinnerArea() {
        spinnerArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3) {
                String item = parent.getItemAtPosition(position).toString();
                sp1SelectedValue = item;
//                String id2 = parent.getItemAtPosition(position).toString();
//                categoryId = categoryIdMap.get(item);
                Log.d("tag21", "sp1SelectedValue: " + sp1SelectedValue);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }


    private void initview() {
        spinnerArea = findViewById(R.id.spinnerArea);
        btn_order_now = findViewById(R.id.btn_order_now);

        tvUserName = findViewById(R.id.tvUserName);
        tvUserPhone = findViewById(R.id.tvUserPhone);
        tvUserAddress = findViewById(R.id.tvUserAddress);

        et_truck_driver_name = findViewById(R.id.et_truck_driver_name);
        et_truck_driver_mobile = findViewById(R.id.et_truck_driver_mobile);
        et_truck_driver_reg_no = findViewById(R.id.et_truck_driver_reg_no);


        btn_order_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                clearCartList();

                String orderTaka = String.valueOf(totalPayableNetPrice);

//                ArrayList<String> param2 = productPrice;
//                ArrayList<String> param3 = sp1SelectedValue;

//                productQuantities.add("1");
//                productIds.add(productId);
                ArrayList<String> param2 = productIds;
//                ArrayList<String> param3 = productQuantities;


                String param5 = "";
                String param6 = "";
                String param7 = "";
                String param8 = "";
                String param9 = "";


                if (et_truck_driver_name.getText().toString().isEmpty()) {

//                    new MaterialDialog.Builder(getContext())
//                            .title("Order Status")
//                            .content("ট্রাক ড্রাইভারের নাম ঘরটি পূরণ করুন ")
//                            .positiveText("")
//                            .negativeText("Ok")
//                            .show();
                } else {
                    param7 = et_truck_driver_name.getText().toString();
                }
                if (et_truck_driver_mobile.getText().toString().isEmpty()) {

//                    new MaterialDialog.Builder(getContext())
//                            .title("Order Status")
//                            .content("ট্রাক ড্রাইভার মোবাইল নাম্বার ঘরটি পূরণ করুন ")
//                            .positiveText("")
//                            .negativeText("Ok")
//                            .show();
                } else {
                    param8 = et_truck_driver_mobile.getText().toString();
                }
                if (et_truck_driver_reg_no.getText().toString().isEmpty()) {

//                    new MaterialDialog.Builder(getContext())
//                            .title("Order Status")
//                            .content("ট্রাক রেজিস্ট্রেশন নাম্বার ঘরটি পূরণ করুন ")
//                            .positiveText("")
//                            .negativeText("Ok")
//                            .show();
                } else {
                    param9 = et_truck_driver_reg_no.getText().toString();
                }


                int ait_bank_Id = 0;
                String sales_point = "2";
                String payment_type = " ";

                sendProductOrderRequest(orderTaka, productIds, quantities, ait_bank_Id,
                        param5, param6, param7, param8, param9,
                        sales_point, payment_type);


            }
        });
    }

    private void clearCartList() {
        db = new DatabaseHelper(this);
        db.deleteAllRowsFromTAble(CartModel.TABLE_NAME);
    }

    private void loadArrayData() {
        for (CartModel m : mCartList) {
            productIds.add(m.getSub_category_id());
            productNames.add(m.getCategory_name());
            prices.add(m.getSub_category_price());
            quantities.add(m.getQuantity());
            bagSizes.add(m.getBag_size());
            productDirectRecoveries.add(m.getDirect_recovery());

            totalPrices.add(String.valueOf(Double.parseDouble(m.getSub_category_price()) * Double.parseDouble(m.getQuantity()) * Double.parseDouble(m.getBag_size())));

            sumOfPrice = sumOfPrice + Double.parseDouble(m.getSub_category_price()) * Double.parseDouble(m.getQuantity()) * Double.parseDouble(m.getBag_size());
        }

        dTotalPrice = sumOfPrice;

        DecimalFormat df = new DecimalFormat("####0.00");

//        tv_sub_item_price.setText("Price: " +"\u09F3 "+ df.format(price_item_total_d));


//        dTotalPrice = Double.parseDouble(df.format(dTotalPrice));
//        dTotalPrice = Double.parseDouble(new DecimalFormat("##.####").format(sumOfPrice));
        dTotalPrice = Double.parseDouble(new DecimalFormat("####0.00").format(sumOfPrice));
        subTotalPrice = "\u09F3 " + String.valueOf(dTotalPrice);
//        subTotalPrice = String.valueOf(dTotalPrice);
    }


    /////


    private void addTable1() {
        addHeaders();
        addData();
        addFooters();
        addFooters2();
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
        tv.setGravity(Gravity.CENTER);
//        tv.setOnClickListener(CheckoutActivity.this);
        return tv;
    }

    private TextView getTextView2(int id, String title, int color, int typeface, int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title.toUpperCase());
        tv.setTextSize(14);
        tv.setTextColor(color);
        tv.setPadding(10, 25, 10, 25);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundColor(bgColor);
        tv.setLayoutParams(getLayoutParams());
        tv.setGravity(Gravity.CENTER);
//        tv.setOnClickListener(CheckoutActivity.this);
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
     * add the headers to the table
     **/
    public void addHeaders() {
        TableLayout tl = findViewById(R.id.table1);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "Product", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.deep_orange_100)));
        tr.addView(getTextView(0, "Price", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.deep_orange_100)));
        tr.addView(getTextView(0, "Quantity", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.deep_orange_100)));
        tr.addView(getTextView(0, "Total", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.deep_orange_100)));
        tl.addView(tr, getTblLayoutParams());
    }


    public void addFooters() {
        TableLayout tl = findViewById(R.id.table1);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "Total Price", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_100)));
        tr.addView(getTextView(0, "", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_100)));
        tr.addView(getTextView(0, "", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_100)));
        tr.addView(getTextView(0, subTotalPrice, Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_100)));
        tl.addView(tr, getTblLayoutParams());
    }

    public void addFooters2() {
        TableLayout tl = findViewById(R.id.table1);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "Total Payable Price", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.deep_orange_50)));
        tr.addView(getTextView(0, "", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.deep_orange_50)));
        tr.addView(getTextView(0, "", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.deep_orange_50)));
        tr.addView(getTextView2(0, String.valueOf(totalPayableNetPrice), Color.RED, Typeface.BOLD, ContextCompat.getColor(this, R.color.deep_orange_50)));
        tl.addView(tr, getTblLayoutParams());
    }


    /**
     * This function add the data to the table
     **/
    public void addData() {
        int numProducts = productNames.size();
        TableLayout tl = findViewById(R.id.table1);
        for (int i = 0; i < numProducts; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(getLayoutParams());

            tr.addView(getTextView(i, productNames.get(i), Color.BLACK, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorWhite)));
            tr.addView(getTextView(i, prices.get(i), Color.BLACK, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorWhite)));
            tr.addView(getTextView(i, quantities.get(i), Color.BLACK, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorWhite)));
            tr.addView(getTextView(i, totalPrices.get(i), Color.BLACK, Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorWhite)));

            tl.addView(tr, getTblLayoutParams());
        }


        try {
            finalobject = makJsonObject(productIds,
                    productNames,
                    prices,
                    quantities,
                    totalPrices);

            Log.d("tag5656", "checkoutObject: " + finalobject);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    public JSONObject makJsonObject(ArrayList<String> productIds, ArrayList<String> productNames, ArrayList<String> prices, ArrayList<String> quantities, ArrayList<String> totalPrices)
            throws JSONException {
        JSONObject obj = null;
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < productNames.size(); i++) {
            obj = new JSONObject();
            try {

                obj.put("productId", productIds.get(i));
                obj.put("productName", productNames.get(i));
                obj.put("price", prices.get(i));
                obj.put("quantity", quantities.get(i));
                obj.put("totalPrice", totalPrices.get(i));

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            jsonArray.put(obj);
        }

//        JSONObject obj2 = new JSONObject();
//        obj2.put("userId", userId);
//        obj2.put("shippingUserName", name);
//        obj2.put("shippingUserPhone", phone);
//        obj2.put("shippingUserAddress", address);


        JSONObject finalobject = new JSONObject();
        finalobject.put("checkoutProductsInfo", jsonArray);
//        finalobject.put("shippingInfo", obj2);
        return finalobject;
    }


    //payable price
    private void setTotalPayableNetPrice() {

        totalPayableNetPrice = 0.0;

        for (int i = 0; i < prices.size(); i++) {

            String price = prices.get(i);
            String priceWithOutComma = price.replace(",", "");

            totalPayableNetPrice = Double.parseDouble(priceWithOutComma) *
                    Double.parseDouble(quantities.get(i)) *
                    Double.parseDouble(bagSizes.get(i)) +
                    (totalPayableNetPrice + Double.parseDouble(quantities.get(i)) *
                            Double.parseDouble(bagSizes.get(i)) *
                            Double.parseDouble(productDirectRecoveries.get(i)));

//            totalPayableNetPrice = (Double.parseDouble(priceWithOutComma) * Double.parseDouble(bagSizes.get(i))) +
//                    (totalPayableNetPrice + Double.parseDouble(bagSizes.get(i)) *
//                            Double.parseDouble(productDirectRecoveries.get(i)));

            totalPayableNetPrice = Double.parseDouble(new DecimalFormat("####0.00").format(totalPayableNetPrice));
            Log.d("tag3", "productDirectRecoveries.get(i): " + productDirectRecoveries.get(i));

        }

//        tv_payable_total_price.setText(String.valueOf("\u09F3 " + totalPayableNetPrice));
    }


    @SuppressLint("CheckResult")
    public void getDeliveryArea() {
        String param1 = "get_delivery_area";
        String accept = "application/json";
        String device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);


//        RetrofitApiClient.getApiInterface().get_delivery_area(param1)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//
//                            Log.d("resCode", " phone: " + phone);
//                            Log.d("resCode", " device_id: " + device_id);
//
//                            if (response.isSuccessful()) {
//                                response.body(); // do something with that
//                                Log.d("resCode", " response.body(): " + response.body());
//                                Log.d("resCode", " response.code: " + response.code());
//
//                                DeliveryArea body = response.body();
//
//                                if (response.code() == 200) {
//                                    String responseString = response.message();
//
//                                    List<DeliveryArea.Result> areaList = body.getResult();
//                                    Log.d("resCode", "areaList  :  " + areaList);
//                                    Log.d("resCode", "deliveryAreaList  :  " + deliveryAreaList);
//                                    for (DeliveryArea.Result area : areaList) {
//                                        deliveryAreaList.add(area.getDeliveryArea());
//                                    }
//
//                                    Log.d("resCode", "areaList  :  " + areaList);
//                                    Log.d("resCode", "deliveryAreaList  :  " + deliveryAreaList);
//
//                                    dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, deliveryAreaList);
//                                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                                    spinnerArea.setAdapter(dataAdapter);
//
//
//                                } else {
//                                    new MaterialDialog.Builder(CheckoutActivity.this)
//                                            .title("Registration Status")
//                                            .content("")
//                                            .positiveText("")
//                                            .negativeText("Ok")
//                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
//                                                @Override
//                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//
//                                                }
//                                            })
//                                            .show();
//                                }
//
//                            } else {
////                                response.errorBody().string(); // do something with that
//
//                            }
//
//
//                        },
//                        error -> {
//                        },
//                        () -> {
//
//                        }
//                );

    }


    @SuppressLint("CheckResult")
    private void sendProductOrderRequest(String orderTaka, ArrayList<String> param2, ArrayList<String> param3,
                                         int param4, String param5, String param6, String param7,
                                         String param8, String param9, String param10, String payment_type) {


        String token = Credential.getToken(this);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

        Log.d("tag4", "authorization: " + authorization);
        Log.d("tag4", "accept: " + accept);

        showProgress();
        RetrofitApiClient.getApiInterface().makeOrder(authorization, accept, orderTaka,
                        param2, param3, param4, param5, param6, param7, param8, param9, param10, payment_type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {


                            Log.d("tag4", "orderTaka : " + orderTaka);
                            Log.d("tag4", "param2 : " + param2);
                            Log.d("tag4", "param3 : " + param3);
                            Log.d("tag4", "sales_point: " + param10);
                            Log.d("tag4", "param8: " + param8);
                            Log.d("tag4", "param4 : " + param4);
                            Log.d("tag4", "param5 : " + param5);
                            Log.d("tag4", "param6: " + param6);
                            Log.d("tag4", "param6: " + param7);
                            Log.d("tag4", "param6: " + param9);
                            Log.d("tag4", "sales point: " + param10);

                            Log.d("tag4", "response111 : " + response);

                            //////
                            if (response.isSuccessful()) {


                                Log.d("tag4444", "Response String: 1:" + response.toString());

                                String responseString = new String(response.message());
                                Log.d("tag4444", "Response String:" + responseString);
                                MakeOrder makeOrder = response.body();
                                boolean success = makeOrder.getSuccess();

                                String message = makeOrder.getMessage();
                                Log.d("tag4", "message1 : " + message);


                                if (response.code() == 422) {
                                    hideProgress();

                                    new MaterialDialog.Builder(this)
                                            .title("Order Status")
                                            .content(message)
                                            .positiveText("")
                                            .negativeText("Ok")
                                            .show();
                                    Log.d("tag4", "message : " + message);

                                    Log.d("tag4", "Response String: 2:" + response.code());

                                }


                                if (response.code() == 200) {
                                    hideProgress();


                                    Log.d("tag4", "orderTaka : " + orderTaka);
                                    Log.d("tag4", "param2 : " + param2);
                                    Log.d("tag4", "param3 : " + param3);
                                    Log.d("tag4", "param4 : " + param4);
                                    Log.d("tag4", "param5 : " + param5);
                                    Log.d("tag4", "param6: " + param6);
                                    Log.d("tag4", "param6: " + param7);
                                    Log.d("tag4", "param6: " + param8);
                                    Log.d("tag4", "param6: " + param9);


                                    if (success) {

                                        new MaterialDialog.Builder(this)
                                                .title("Order Status")
                                                .content(message + ". Order submitted for review")
                                                .positiveText("")
                                                .negativeText("Ok")
                                                .onNegative(new MaterialDialog.SingleButtonCallback() {
                                                    @Override
                                                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                                                    Intent i = new Intent(getActivity(), TabLayoutOfOrderListActivity.class);
//                                                    startActivity(i);
//                                                    getActivity().finish();

                                                        Intent i = new Intent(CheckoutActivity.this, PaymentActivity.class);
                                                        startActivity(i);
                                                        finish();


                                                    }
                                                }).show();


                                    }
                                    if (!success) {
                                        new MaterialDialog.Builder(this)
                                                .title("Order Status")
                                                .content("Order Not Submitted. " + message)
                                                .positiveText("")
                                                .negativeText("Ok")
                                                .show();

                                    }

                                }

                                if (response.code() < 200) {
                                    hideProgress();

                                    new MaterialDialog.Builder(this)
                                            .title("Order Status")
                                            .content(message)
                                            .positiveText("")
                                            .negativeText("Ok")
                                            .show();

                                    Log.d("tag4", "Response String: 2:" + response.code());


                                }
                                if (response.code() > 200) {
                                    hideProgress();

                                    new MaterialDialog.Builder(this)
                                            .title("Order Status")
                                            .content(message)
                                            .positiveText("")
                                            .negativeText("Ok")
                                            .show();

                                    Log.d("tag4", "Response String: 2:" + response.code());


                                    Log.d("tag5", "message : " + message);
                                }


                            } else {
                                Gson gson = new Gson();
                                ErrorResponse errorResponse = gson.fromJson(
                                        response.errorBody().string(),
                                        ErrorResponse.class);

                                List<String> errorList = errorResponse.getValidationError();

                                String errorNames = "1. ";
                                for (int i = 0; i < errorList.size(); i++) {
                                    int j = i + 2;
                                    errorNames = errorNames
                                            + errorList.get(i);
                                    if (i != errorList.size() - 1) {


                                        errorNames = errorNames + "\n\n" + j + ". ";
                                    }


                                }

                                new MaterialDialog.Builder(this)
                                        .title("Status")
                                        .content(errorNames)
                                        .positiveText("")
                                        .negativeText("Ok")
                                        .onNegative(new MaterialDialog.SingleButtonCallback() {
                                            @Override
                                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                                hideProgress();
                                            }
                                        })
                                        .show();

                            }

                            /////

                        }

                        ,
                        error -> {


                            new MaterialDialog.Builder(this)
                                    .title("Order Status")
                                    .content(" " + error.getMessage())
                                    .positiveText("")
                                    .negativeText("Ok")
                                    .show();

                        },
                        () -> {
                            Log.d("tag4444", "Response String: 5:");
                        }
                );

    }


//    @SuppressLint("CheckResult")
//    public void sendCheckedoutData(String clientId, String name, String phone, String email,
//                                   String address, String comments, String cartTotalItem, String cartTotalTaka,
//                                   String deliveryArea, String orderItems) {
//        String action = "checkout";
//        String accept = "application/json";
//        String device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
//
//
//        Log.d("resCode", " clientId: " + clientId);
//        Log.d("resCode", " name: " + name);
//        Log.d("resCode", " phone: " + phone);
//        Log.d("resCode", " email: " + email);
//        Log.d("resCode", " address: " + address);
//        Log.d("resCode", " comments: " + comments);
//        Log.d("resCode", " cartTotalItem: " + cartTotalItem);
//        Log.d("resCode", " cartTotalTaka: " + cartTotalTaka);
//        Log.d("resCode", " deliveryArea: " + deliveryArea);
//        Log.d("resCode", " orderItems: " + orderItems);
//
////        RetrofitApiClient.getApiInterface().send_checked_out_data(action, clientId, name, phone, email, address, comments, cartTotalItem, cartTotalTaka, deliveryArea, orderItems)
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(response -> {
////
////                            Log.d("resCode", " phone: " + phone);
////                            Log.d("resCode", " device_id: " + device_id);
////
////                            if (response.isSuccessful()) {
////                                response.body(); // do something with that
////                                Log.d("resCode", " response.body(): " + response.body());
////                                Log.d("resCode", " response.code: " + response.code());
////
////                                Checkout body = response.body();
////
////                                Log.d("resCode", " body: " + body.getResult());
////
////                                if (response.code() == 200) {
////                                    String responseString = response.message();
////
////                                    List<Checkout.Result> list = body.getResult();
//////                                    String message = list.get(0).getMessage();
////
////                                    String order_items = list.get(0).getOrderItems().toString();
////
//////                                    Log.d("resCode", " message: " + message);
////                                    Log.d("resCode", " order_items: " + order_items);
////
////                                    Intent intent = new Intent(CheckoutActivity.this, OrderConfirmationActivity.class);
////                                    startActivity(intent);
////
//////                                    if (result.equalsIgnoreCase("success")) {
//////                                        Intent intent = new Intent(CheckoutActivity.this, OrderConfirmationActivity.class);
//////                                        intent.putExtra("order_Id", orderId);
//////                                        startActivity(intent);
//////
//////                                    }
////
////
////                                } else {
////                                    new MaterialDialog.Builder(CheckoutActivity.this)
////                                            .title("Registration Status")
////                                            .content("")
////                                            .positiveText("")
////                                            .negativeText("Ok")
////                                            .onNegative(new MaterialDialog.SingleButtonCallback() {
////                                                @Override
////                                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
////
////                                                }
////                                            })
////                                            .show();
////                                }
////
////                            } else {
//////                                response.errorBody().string(); // do something with that
////
////                            }
////
////
////                        },
////                        error -> {
////                        },
////                        () -> {
////
////                        }
////                );
//
//    }


    public void showDialog(String bodyText) {
        new MaterialDialog.Builder(this)
                .title("Status")
                .content(bodyText)
                .positiveText("")
                .negativeText("Ok")
                .show();
    }

    public void cancelDialog(String titleText) {
        new MaterialDialog.Builder(this)
                .title(titleText)
                .content("")
                .positiveText("")
                .negativeText("Ok")
                .show();
    }

    public void showProgress() {
        progress = new ProgressDialog(this);
        progress.setMessage("please wait.");
        progress.show();
    }

    public void hideProgress() {

        if (progress != null && progress.isShowing()) {
            progress.dismiss();
        }
    }

    private void closeProgressDialog() {
        if (progress.isShowing())
            progress.dismiss();
    }

    private ProgressDialog progress;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                } else {
                    onBackPressed();
                }
//                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}