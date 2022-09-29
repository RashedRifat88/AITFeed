package com.egsystembd.aitfeed.cart;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.egsystembd.aitfeed.R;
import com.egsystembd.aitfeed.credential.LoginActivity;
import com.egsystembd.aitfeed.data.DatabaseHelper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {


    String title;
    String category_id;
    //    private List<Service> mCartList;
    private List<CartModel> mCartList;
    private DatabaseHelper db;
    private static CartAdapter mCartAdapter;
    int cartItemNumber;
    private static RecyclerView recyclerView;
    static double totalPrice = 0;
    static TextView tv_total_price, tv_total_payable_price;
    Button btn_checkout;

    ArrayList<String> productIds = new ArrayList<>();
    ArrayList<String> productNames = new ArrayList<>();
    ArrayList<String> prices = new ArrayList<>();
    ArrayList<String> quantities = new ArrayList<>();
    ArrayList<String> bagSizes = new ArrayList<>();
    ArrayList<String> totalPrices = new ArrayList<>();
    ArrayList<String> productDirectRecoveries = new ArrayList<>();
    ArrayList<String> productVolumes = new ArrayList<>();
    private static String subTotalPrice;
    private static double totalPayableNetPrice;
    private Double sumOfPrice = 0.0;
    private static double dTotalPrice = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        title = getIntent().getStringExtra("TITLE_NAME");
        category_id = getIntent().getStringExtra("CATEGORY_ID");

//        ActionBar ab = ((AppCompatActivity) this).getSupportActionBar();
//        if (ab != null) {
//            ab.setDisplayHomeAsUpEnabled(true);
//        }
//        ab.setTitle("Cart");

        initStatusBar();

//        mCartList = ShoppingCartHelper.getCart();
        db = new DatabaseHelper(this);
        mCartList = db.getAllCartItems();
        Log.d("tag444", "mCartList: "+mCartList);
        cartItemNumber = mCartList.size();

        loadRecyclerView();
        loadTotalPrice();
        checkout();

//        loadArrayData();
//        setTotalPayableNetPrice();

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




    public void loadArrayData() {
        for (CartModel m : mCartList) {
            productIds.add(m.getSub_category_id());
            productNames.add(m.getCategory_name());
            prices.add(m.getSub_category_price());
            quantities.add(m.getQuantity());
            bagSizes.add(m.getBag_size());
            productDirectRecoveries.add(m.getDirect_recovery());

            totalPrices.add(String.valueOf(Double.parseDouble(m.getSub_category_price()) * Double.parseDouble(m.getQuantity())));

            sumOfPrice = sumOfPrice + Double.parseDouble(m.getSub_category_price()) * Double.parseDouble(m.getQuantity());
        }

        dTotalPrice = sumOfPrice;
        subTotalPrice = "\u09F3 " + String.valueOf(dTotalPrice);
    }


    //payable price
    public void setTotalPayableNetPrice() {

        totalPayableNetPrice = 0.0;

        for (int i = 0; i < prices.size(); i++) {

            String price = prices.get(i);
            String priceWithOutComma = price.replace(",", "");

            totalPayableNetPrice = (Double.parseDouble(priceWithOutComma) * Double.parseDouble(bagSizes.get(i))) +
                    (totalPayableNetPrice + Double.parseDouble(bagSizes.get(i)) *
                            Double.parseDouble(productDirectRecoveries.get(i)));

            totalPayableNetPrice = Double.parseDouble(new DecimalFormat("##.##").format(totalPayableNetPrice));
            Log.d("tag3", "productDirectRecoveries.get(i): " + productDirectRecoveries.get(i));

        }

        tv_total_payable_price.setText(String.valueOf("\u09F3 " + totalPayableNetPrice));
    }



    private void checkout() {
        btn_checkout = findViewById(R.id.btn_checkout);
        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(CartActivity.this, LoginActivity.class);
                Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadTotalPrice() {
        tv_total_price = findViewById(R.id.tv_total_price);
        tv_total_payable_price = findViewById(R.id.tv_total_payable_price);
//        totalPrice = CartAdapter.sumOfPrice;
//        tv_total_price.setText("TK "+totalPrice);
    }

    public static void setTotalPrice(double total_price){
//        totalPrice = total_price;

        DecimalFormat df = new DecimalFormat("####0.00");

        tv_total_price.setText("\u09F3 "+ df.format(total_price));

//        loadArrayData();
//        setTotalPayableNetPrice();
    }

    private void loadRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mCartAdapter = new CartAdapter(this);
        recyclerView.setAdapter(mCartAdapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        mCartAdapter.setData2(mCartList);
        mCartAdapter.notifyDataSetChanged();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

//            case android.R.id.home:
//                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
//                    getSupportFragmentManager().popBackStack();
//
//                    SubItemActivity.getCartItemsNumber(cartItemNumber);
//
//                    Intent intent = new Intent(CartActivity.this, SubItemActivity.class);
//                    intent.putExtra("FRAGMENT_NAME", title);
//                    intent.putExtra("CATEGORY_ID", category_id);
//                    startActivity(intent);
//
//                } else {
//                    onBackPressed();
//                }
////                finish();
//                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}