package com.egsystembd.aitfeed.cart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.egsystembd.aitfeed.R;
import com.egsystembd.aitfeed.data.DatabaseHelper;
import com.egsystembd.aitfeed.data.SharedData;
import com.egsystembd.aitfeed.retrofit.RetrofitApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CheckoutActivity extends AppCompatActivity {

    private static double dTotalPrice = 0.0;
    private List<CartModel> mCartList;
    private List<String> deliveryAreaList = new ArrayList<>();


    ArrayList<String> productIds = new ArrayList<>();
    ArrayList<String> productNames = new ArrayList<>();
    ArrayList<String> prices = new ArrayList<>();
    ArrayList<String> quantities = new ArrayList<>();
    ArrayList<String> totalPrices = new ArrayList<>();
    ArrayList<String> productVolumes = new ArrayList<>();
    private static String subTotalPrice;
    private Double sumOfPrice = 0.0;

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

        initview();
        loadArrayData();
        setTextData();
        addTable1();

        getDeliveryArea();
        loadSpinnerArea();

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


        btn_order_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                clearCartList();

                String clientId = userId;
                String name1 = name;
                String phone1 = phone;
                String email1 = email;
                String address1 = address;
                String comments = "";
                String cartTotalItem = String.valueOf(mCartList.size());
                String cartTotalTaka = String.valueOf(dTotalPrice);
                String deliveryArea = sp1SelectedValue;
                String orderItems = finalobject.toString();

                Log.d("infonnn", " clientId: " + clientId);
                Log.d("infonnn", " name1: " + name1);
                Log.d("infonnn", " phone1: " + phone1);
                Log.d("infonnn", " email1: " + email1);
                Log.d("infonnn", " address1: " + address1);
                Log.d("infonnn", " comments: " + comments);
                Log.d("infonnn", " cartTotalItem: " + cartTotalItem);
                Log.d("infonnn", " cartTotalTaka: " + cartTotalTaka);
                Log.d("infonnn", " deliveryArea: " + deliveryArea);
                Log.d("infonnn", " orderItems: " + orderItems);

                sendCheckedoutData(clientId, name1, phone1, email1,
                        address1, comments, cartTotalItem, cartTotalTaka,
                        deliveryArea, orderItems);
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

            totalPrices.add(String.valueOf(Double.parseDouble(m.getSub_category_price()) * Double.parseDouble(m.getQuantity())));

            sumOfPrice = sumOfPrice + Double.parseDouble(m.getSub_category_price()) * Double.parseDouble(m.getQuantity());
        }

        dTotalPrice = sumOfPrice;
        subTotalPrice = "TK " + String.valueOf(dTotalPrice);
    }


    /////


    private void addTable1() {
        addHeaders();
        addData();
        addFooters();
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
        TableLayout tl = findViewById(R.id.table1);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "Product", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_200)));
        tr.addView(getTextView(0, "Price", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_200)));
        tr.addView(getTextView(0, "Quantity", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_200)));
        tr.addView(getTextView(0, "Total", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_200)));
        tl.addView(tr, getTblLayoutParams());
    }

    /**
     * This function add the headers to the table
     **/
    public void addFooters() {
        TableLayout tl = findViewById(R.id.table1);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "Total Price", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_200)));
        tr.addView(getTextView(0, "", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_200)));
        tr.addView(getTextView(0, "", Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_200)));
        tr.addView(getTextView(0, subTotalPrice, Color.BLACK, Typeface.BOLD, ContextCompat.getColor(this, R.color.light_green_200)));
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
    public void sendCheckedoutData(String clientId, String name, String phone, String email,
                                   String address, String comments, String cartTotalItem, String cartTotalTaka,
                                   String deliveryArea, String orderItems) {
        String action = "checkout";
        String accept = "application/json";
        String device_id = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);


        Log.d("resCode", " clientId: " + clientId);
        Log.d("resCode", " name: " + name);
        Log.d("resCode", " phone: " + phone);
        Log.d("resCode", " email: " + email);
        Log.d("resCode", " address: " + address);
        Log.d("resCode", " comments: " + comments);
        Log.d("resCode", " cartTotalItem: " + cartTotalItem);
        Log.d("resCode", " cartTotalTaka: " + cartTotalTaka);
        Log.d("resCode", " deliveryArea: " + deliveryArea);
        Log.d("resCode", " orderItems: " + orderItems);

//        RetrofitApiClient.getApiInterface().send_checked_out_data(action, clientId, name, phone, email, address, comments, cartTotalItem, cartTotalTaka, deliveryArea, orderItems)
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
//                                Checkout body = response.body();
//
//                                Log.d("resCode", " body: " + body.getResult());
//
//                                if (response.code() == 200) {
//                                    String responseString = response.message();
//
//                                    List<Checkout.Result> list = body.getResult();
////                                    String message = list.get(0).getMessage();
//
//                                    String order_items = list.get(0).getOrderItems().toString();
//
////                                    Log.d("resCode", " message: " + message);
//                                    Log.d("resCode", " order_items: " + order_items);
//
//                                    Intent intent = new Intent(CheckoutActivity.this, OrderConfirmationActivity.class);
//                                    startActivity(intent);
//
////                                    if (result.equalsIgnoreCase("success")) {
////                                        Intent intent = new Intent(CheckoutActivity.this, OrderConfirmationActivity.class);
////                                        intent.putExtra("order_Id", orderId);
////                                        startActivity(intent);
////
////                                    }
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