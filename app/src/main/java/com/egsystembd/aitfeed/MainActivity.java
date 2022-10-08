package com.egsystembd.aitfeed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.egsystembd.aitfeed.adapter.ProductShowAdapter;
import com.egsystembd.aitfeed.cart.CartActivity;
import com.egsystembd.aitfeed.cart.CartAdapter;
import com.egsystembd.aitfeed.cart.CartModel;
import com.egsystembd.aitfeed.credential.Credential;
import com.egsystembd.aitfeed.credential.LoginActivity;
import com.egsystembd.aitfeed.data.DatabaseHelper;
import com.egsystembd.aitfeed.data.SharedData;
import com.egsystembd.aitfeed.model.ProductCategory;
import com.egsystembd.aitfeed.model.ProductList;
import com.egsystembd.aitfeed.retrofit.RetrofitApiClient;
import com.egsystembd.aitfeed.ui.bank_list.BankListActivity;
import com.egsystembd.aitfeed.ui.ledger.LedgerActivity;
import com.egsystembd.aitfeed.ui.payment.PaymentActivity;
import com.egsystembd.aitfeed.ui.payment_list.PaymentListActivity;
import com.egsystembd.aitfeed.utils.NetUtils;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Context context;
    private static View mView;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    ProductShowAdapter adapter;
    private SearchView searchView;
    private EditText etSearch;
    private SearchView.OnQueryTextListener queryTextListener;
    private int previousLength;
    private boolean backSpace;
    String areaId = "";
    Spinner spinner1;
    ArrayAdapter<String> dataAdapter;
    String sp1SelectedValue = "";
    List<String> categories;
    HashMap<String, String> categoryIdMap;
    String categoryId;

    private FrameLayout frame_cart;
    private TextView tv_cart_badge_count;
    private ImageView iv_menu_top, iv_cart;
    private Runnable runnable = null;
    private Handler handler = new Handler();
    static int mNotificationsCount = 0;
    static int cartItemNumber = 0;

    static TextView tv_user_name, tv_user_profile_completion_status;
    View headerView;
    static ImageView iv_profile_image;
    String userName;
    LinearLayout linear1, linear10;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationViewDrawer;
    Toolbar toolbar;

    private List<CartModel> mCartList;
    private DatabaseHelper db;
    private static CartAdapter mCartAdapter;
    int cartItemNumberN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cartItems();

        initStatusBar();
        initComponents();
        loadSpinner();
        search();
        initNavigationMenu();

//        updateNotificationsBadge(cartItemNumber);

        new FetchCountTask().execute();
        android.os.Handler customHandler = new android.os.Handler();
        customHandler.postDelayed(updateTimerThread, 0);
    }

    private void cartItems() {
        db = new DatabaseHelper(this);
        mCartList = db.getAllCartItems();
        Log.d("tag444", "mCartList: " + mCartList);
        cartItemNumber = mCartList.size();

        updateNotificationsBadge(cartItemNumber);
    }

    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            new FetchCountTask().execute();

            android.os.Handler customHandler = new android.os.Handler();
            customHandler.postDelayed(this, 1000);
        }
    };


    private void search() {

        getProductListData();

        if (etSearch.getText().toString().equals("")) {
            getProductListData();
        }

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                previousLength = s.length();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s);

                if (count == 0) {
                    getProductListData();

                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                backSpace = previousLength > s.length();

                if (backSpace) {
                    getProductListData();
                }
            }
        });

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

    public void initComponents() {

        etSearch = (EditText) findViewById(R.id.etSearch);
        spinner1 = findViewById(R.id.spinnerCategory);
        iv_menu_top = findViewById(R.id.iv_menu_top);
//        iv_cart = findViewById(R.id.iv_cart);
        frame_cart = findViewById(R.id.frame_cart);
        tv_cart_badge_count = findViewById(R.id.tv_cart_badge_count);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //recyclerView.addItemDecoration(dividerItemDecoration);
        adapter = new ProductShowAdapter(this, areaId);
        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);

        if (NetUtils.isNetworkAvailable(this)) {
            getProductCategory();
        } else {
            new MaterialDialog.Builder(this)
                    .title("ইন্টারনেট সমস্যা")
                    .content("দয়াকরে আপনার ইন্টারনেট কানেকশন চেক করুন।")
                    .positiveText("")
                    .negativeText("Ok")
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            finish();
                        }
                    })
                    .show();
        }


        iv_menu_top.setOnClickListener(view -> {

            if (cartItemNumber < 1) {
                new MaterialDialog.Builder(this)
                        .title("Status")
                        .content("You should select at least one product for going next step!")
                        .positiveText("")
                        .negativeText("Cancel")
                        .onPositive(new MaterialDialog.SingleButtonCallback() {
                            @Override
                            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                            }
                        })
                        .show();
            } else {
                gotoCartActivity();
            }

        });

    }


    public void loadSpinner() {
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3) {
                String item = parent.getItemAtPosition(position).toString();
                sp1SelectedValue = item;
                String id2 = parent.getItemAtPosition(position).toString();
                categoryId = categoryIdMap.get(item);

                Log.d("4444tag", "categoryId: " + categoryId);

                ((TextView) arg1).setTextColor(Color.parseColor("#ff403a"));

//                if (categoryId != null){
//                    getProductListData();

                if (sp1SelectedValue.equalsIgnoreCase("প্রোডাক্ট ক্যাটাগরি নির্বাচন করুন")) {
                    etSearch.setVisibility(View.GONE);
                } else {
                    etSearch.setVisibility(View.VISIBLE);
                }
//                }
//                showProgressDialog();
                getProductListData();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }


    @SuppressLint("CheckResult")
    private void getProductListData() {


        String token = Credential.getToken(this);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

        Log.d("tag1", "authorization : " + authorization);

        if (NetUtils.isNetworkAvailable(this)) {


            RetrofitApiClient.getApiInterface().getProductList(authorization, accept)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(response -> {
                                if (response.code() == 200) {
//                                    closeProgressDialog();

                                    ProductList productResponse = response.body();
                                    Log.d("tag1", "ProductList response : " + productResponse.toString());
                                    Log.d("tag1", "response code : " + response.code());


                                    List<ProductList.Data> productList = productResponse.getData();
                                    Log.d("tag1", "ProductList getProductList : " + productList);


                                    if (productList.isEmpty() || productList == null) {
//                                        closeProgressDialog();

                                        new MaterialDialog.Builder(context)
                                                .title("No data found for this account")
                                                .content("")
                                                .positiveText("")
                                                .negativeText("Ok")
                                                .show();
                                    } else {
                                        adapter.setData(productList);
                                        adapter.notifyDataSetChanged();
                                    }


                                    List<ProductList.Data> productList2 = new ArrayList<>();
                                    List<ProductList.Data> productList3 = new ArrayList<>();
                                    for (ProductList.Data detail : productList) {

                                        if (categoryId != null) {
                                            if (categoryId.equalsIgnoreCase(detail.getProduct_category_id())) {
                                                productList2.add(detail);
                                                Log.d("tag111", "productList2 : " + productList2);
                                            }
//                                        adapter = new ProductShowAdapter(this, areaId);
//                                        recyclerView.setAdapter(adapter);

                                            adapter.setData(productList2);
                                            adapter.notifyDataSetChanged();
                                        } else {
                                            productList3.clear();
                                            adapter.setData(productList3);
                                            adapter.notifyDataSetChanged();
                                        }

                                    }


                                } else {


                                }
                            }, error -> {


                                String rm2 = error.getMessage();
                                Log.d("tag1", "error: " + rm2);
                            },
                            () -> {
                                Log.d("tag1", "final block error ");
                            }
                    );

        } else {
            new MaterialDialog.Builder(this)
                    .title("ইন্টারনেট সমস্যা")
                    .content("দয়াকরে আপনার ইন্টারনেট কানেকশন চেক করুন।")
                    .positiveText("")
                    .negativeText("Ok")
                    .onNegative(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                            finish();
                        }
                    })
                    .show();
        }


    }

    private void showAllert(String message) {

        new MaterialDialog.Builder(this)
                .title("Api Status")
                .content(message)
                .positiveText("")
                .negativeText("Ok")
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).show();
    }


    @SuppressLint("CheckResult")
    public Void getProductCategory() {
////        showProgressDialog();
        categories = new ArrayList<String>();
        List<String> ids = new ArrayList<String>();
        categoryIdMap = new HashMap<String, String>();


        String token = Credential.getToken(this);
        String authorization = "Bearer" + " " + token;
        String accept = "application/json";

        RetrofitApiClient.getApiInterface().productCategoryObtained(authorization, accept)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                            if (response.code() == 200) {
//                                closeProgressDialog();
                                String responseString = new String(response.message());
                                ProductCategory productCategoryModel = response.body();


                                List<ProductCategory.Data> productCategories = productCategoryModel.getData();

                                categories.add("প্রোডাক্ট ক্যাটাগরি নির্বাচন করুন");

                                for (ProductCategory.Data productCategoryList : productCategories) {
                                    categories.add(productCategoryList.getProductCategoryName());
                                    ids.add(productCategoryList.getProductCategoryId().toString());
                                    categoryIdMap.put(productCategoryList.getProductCategoryName(), productCategoryList.getProductCategoryId().toString());
                                }

                                dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
                                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                spinner1.setAdapter(dataAdapter);
                            }
                        },
                        error -> {

////                            closeProgressDialog();

                        },
                        () -> {

////                            closeProgressDialog();
//                            showDialog("Problem 3 in main server3");

                        }
                );
        return null;
    }


    @Override
    public void onDestroy() {
        if (runnable != null) handler.removeCallbacks(runnable);
        super.onDestroy();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

//            case R.id.action_notification: {
//                gotoCartActivity();
//                return true;
//            }

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


    private void gotoCartActivity() {

        if (cartItemNumber < 1) {
            new MaterialDialog.Builder(this)
                    .title("Status")
                    .content("You should select at least one product for going next step!")
                    .positiveText("")
                    .negativeText("Cancel")
                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                        @Override
                        public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        }
                    })
                    .show();
        } else {
            Intent viewShoppingCartIntent = new Intent(this, CartActivity.class);
//            viewShoppingCartIntent.putExtra("TITLE_NAME", title);
//            viewShoppingCartIntent.putExtra("CATEGORY_ID", category_id);
            startActivity(viewShoppingCartIntent);
            finish();
        }


    }


    private void updateNotificationsBadge(int count) {
        mNotificationsCount = count;

//        // force the ActionBar to relayout its MenuItems.
//        // onCreateOptionsMenu(Menu) will be called again.
//        invalidateOptionsMenu();


        if (tv_cart_badge_count != null) {
            if (mNotificationsCount == 0) {
                if (tv_cart_badge_count.getVisibility() != View.GONE) {
                    tv_cart_badge_count.setVisibility(View.GONE);
                }
            } else {
                tv_cart_badge_count.setText(String.valueOf(Math.min(mNotificationsCount, 99)));
                if (tv_cart_badge_count.getVisibility() != View.VISIBLE) {
                    tv_cart_badge_count.setVisibility(View.VISIBLE);
                }

                frame_cart.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, CartActivity.class);
                    startActivity(intent);
                });

            }

        }

    }

    /*
    AsyncTask to fetch the notifications count
    */
    public class FetchCountTask extends AsyncTask<Void, Void, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Void... params) {


            int count = cartItemNumber;
            Log.d("tag222", "count: " + count);

            return count;
        }

        @Override
        public void onPostExecute(Integer count) {
            updateNotificationsBadge(count);
        }
    }

    public static void getCartItemsNumber(int getCartItemsNumber) {
        cartItemNumber = getCartItemsNumber;
//        mNotificationsCount = cartItemNumber;
        Log.d("tag222", "getCartItemsNumber: " + cartItemNumber);
    }


    private void initNavigationMenu() {

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationViewDrawer = findViewById(R.id.nav_view_drawer);
        navigationViewDrawer.setNavigationItemSelectedListener(this);

        navigationViewDrawer.setItemIconTintList(null);

        iv_menu_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

//        navigationViewDrawer.getMenu().getItem(0).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(1).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(2).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(3).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(4).setActionView(R.layout.layout_arrow_right);
//        navigationViewDrawer.getMenu().getItem(5).setActionView(R.layout.layout_arrow_right);


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();


        headerView = navigationViewDrawer.getHeaderView(0);
        tv_user_profile_completion_status = headerView.findViewById(R.id.tv_user_profile_completion_status);
        tv_user_name = headerView.findViewById(R.id.tv_user_name);
        iv_profile_image = headerView.findViewById(R.id.iv_profile_image);
        linear10 = headerView.findViewById(R.id.linear10);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

//        if (item.getItemId() == R.id.menu1) {
//            Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
//            startActivity(intent);
//        }
//
//        if (item.getItemId() == R.id.menu2) {
//            Intent intent = new Intent(MainActivity.this, InviteOthersActivity.class);
//            String menu_name = "1";
//            intent.putExtra("menuName", menu_name);
//            startActivity(intent);
//        }
//
//
//        if (item.getItemId() == R.id.menu3) {
//            rateApp();
//        }


        if (item.getItemId() == R.id.menu1) {
            Intent intent = new Intent(MainActivity.this, PaymentActivity.class);;
            intent.putExtra("menuName", "PaymentActivity");
            startActivity(intent);
        }


        if (item.getItemId() == R.id.menu2) {
            Intent intent = new Intent(MainActivity.this, PaymentListActivity.class);;
            intent.putExtra("menuName", "PaymentListActivity");
            startActivity(intent);
        }


        if (item.getItemId() == R.id.menu3) {
//            Intent intent = new Intent(MainActivity.this, InviteOthersActivity.class);;
//            intent.putExtra("menuName", menu_name);
//            startActivity(intent);
        }


        if (item.getItemId() == R.id.menu4) {
//            Intent intent = new Intent(MainActivity.this, InviteOthersActivity.class);;
//            intent.putExtra("menuName", menu_name);
//            startActivity(intent);
        }


        if (item.getItemId() == R.id.menu5) {
            Intent intent = new Intent(MainActivity.this, BankListActivity.class);
            intent.putExtra("menuName", "BankListActivity");
            startActivity(intent);
        }


        if (item.getItemId() == R.id.menu6) {
            Intent intent = new Intent(MainActivity.this, LedgerActivity.class);;
//            intent.putExtra("menuName", menu_name);
            startActivity(intent);
        }


        if (item.getItemId() == R.id.menu7) {
//            Intent intent = new Intent(MainActivity.this, InviteOthersActivity.class);;
//            intent.putExtra("menuName", menu_name);
//            startActivity(intent);
        }


        if (item.getItemId() == R.id.nav_logout) {

            Credential.saveToken(MainActivity.this, "");
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.putExtra("from_where", "MainActivity");
            finish();


        }

        return false;

    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
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


}