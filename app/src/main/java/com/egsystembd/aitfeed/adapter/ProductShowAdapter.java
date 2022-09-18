package com.egsystembd.aitfeed.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.egsystembd.aitfeed.MainActivity;
import com.egsystembd.aitfeed.R;
import com.egsystembd.aitfeed.cart.CartModel;
import com.egsystembd.aitfeed.data.DatabaseHelper;
import com.egsystembd.aitfeed.model.ProductList;


import java.util.ArrayList;
import java.util.List;

public class ProductShowAdapter extends RecyclerView.Adapter<ProductShowAdapter.MyViewHolder> {


    private List<ProductList.Data> productListFiltered;
    private String areaId2;
    private ArrayList<String> selectedProductIds = new ArrayList<String>();
    private ArrayList<String> selectedProductQuantities = new ArrayList<String>();
    private ArrayList<String> selectedProductNames = new ArrayList<String>();
    private ArrayList<String> selectedProductPrices = new ArrayList<String>();
    private ArrayList<String> selectedProductAmounts = new ArrayList<String>();
    private ArrayList<String> selectedProductBagSizes = new ArrayList<String>();
    private ArrayList<String> selectedProductDirectRecoveries = new ArrayList<String>();

//    private ProductAdapterListener listener;

    private List<ProductList.Data> dataSet = new ArrayList<>();
    private Context context;
    private DatabaseHelper db;

    public ProductShowAdapter(Context context, String areaId) {

        db = new DatabaseHelper(context);

        this.context = context;
        this.areaId2 = areaId;

        setHasStableIds(true);
    }

    public ProductShowAdapter(Context context, List<ProductList.Data> dataSet) {
        this.context = context;
        this.dataSet = dataSet;

        setHasStableIds(true);
    }
//    public void setData(List<ProductList.Data> dataSet) {
//        this.dataSet = dataSet;
//    }

    public void setData(List<ProductList.Data> dataSet) {
        this.dataSet = dataSet;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_view_product_show, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        TextView txtSlNo = holder.txtSlNo;
        TextView tv_product_name = holder.tv_product_name;
        TextView tv_product_code = holder.tv_product_code;
        TextView tv_bag_size = holder.tv_bag_size;
        TextView productSellPrice = holder.productSellPrice;
        TextView tv_product_price = holder.tv_product_price;
        TextView product_details = holder.product_details;
        TextView quantityTextView = holder.quantityTextView;
        TextView tv_decrement = holder.tv_decrement;
        TextView tv_increment = holder.tv_increment;
        EditText et1 = holder.et1;
        EditText et_quantity = holder.et_quantity;

        CardView cardView = holder.cardView;

        ImageView imageView = holder.imageView;
        CheckBox check = holder.check;

        LinearLayout linear_add_to_cart = holder.linear_add_to_cart;
        TextView tv_add_to_cart = holder.tv_add_to_cart;

        final int[] mQuantity = {1};
        String nQuantity;
        double mTotalPrice;
        ArrayList<String> selectedProductId = new ArrayList<String>();
        ArrayList<String> selectedProductName = new ArrayList<String>();
        ArrayList<String> selectedProductQuantity = new ArrayList<String>();


        ProductList.Data productList = dataSet.get(position);

//        List<ProductList.Data> getDealerProduct = productList.getProduct();


//        for (int j=0; j<dataSet.size(); j++){
//            txtSlNo.setText(j+1);
//        }
//        for (Product order : getDealerProduct) {
//        txtSlNo.setText(String.valueOf(position+1));
        tv_product_name.setText(productList.getProductName());
//        tv_product_code.setText(productList.getProduct_code());
//        tv_bag_size.setText(productList.getProduct_pack_size() + " kg");
//        tv_product_price.setText(productList.getProduct_net_pice());
//        productSellPrice.setText(productList.getProductSalePrice());
//        product_details.setText(productList.getProductDetail());
//        productList.getDirect_recovery();
//
//        nQuantity = et1.getText().toString();
//        if (nQuantity != null || !nQuantity.isEmpty()) {
//
//        }


        Log.d("tag1", "sl:" + position);
//        Log.d("tag10", "sl:" + position +"tag10", "sl:" + productList.getDirect_recovery() );
//        Log.d("tag1", "productList.getName() : "+productList.getName());


//        Glide.with(context)
//                .load(productList.getProduct_image())
//                .into(imageView);


//        check.setChecked(false);
//
//        check.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                for (int i=0; i<dataSet.size(); i++){
//                if (check.isChecked()) {
//                    selectedProductIds.add(productList.getProductId());
//                    selectedProductNames.add(productList.getProductName());
//                    selectedProductPrices.add(productList.getProduct_net_pice());
//                    selectedProductAmounts.add(productList.getProduct_pack_size());
//                    selectedProductBagSizes.add(productList.getProduct_pack_size());
//                    selectedProductDirectRecoveries.add(productList.getDirect_recovery());
//                    Log.d("tag20", "productList.getDirect_recovery(): " + productList.getDirect_recovery());
//                    Log.d("tag20", "productList.getProduct_pack_size(): " + productList.getProduct_pack_size());
//
////                    selectedProductQuantities.add(String.valueOf(mQuantity[0]));
//                    if (!et_quantity.getText().toString().isEmpty()) {
//                        selectedProductQuantities.add(et_quantity.getText().toString());
//                    } else if (et_quantity.getText().toString().isEmpty()) {
//                        selectedProductQuantities.add("1");
//                        et_quantity.setText("1");
//                    }
//
//                    Log.d("tag20", "selectedProductNames from is checked: " + selectedProductNames);
//
//                    et_quantity.setEnabled(false);
//
//                    Log.d("tag20", "selectedProductIds from isChecked: " + selectedProductIds);
//                }
//                if (!check.isChecked()) {
//                    selectedProductIds.remove(productList.getProductId());
//                    selectedProductNames.remove(productList.getProductName());
//                    selectedProductPrices.remove(productList.getProduct_net_pice());
//                    selectedProductAmounts.remove(productList.getProduct_pack_size());
//                    selectedProductBagSizes.remove(productList.getProduct_pack_size());
//                    selectedProductDirectRecoveries.remove(productList.getDirect_recovery());
////                    selectedProductDirectRecoveries.remove(productList.getProduct);
//                    selectedProductQuantities.remove(et_quantity.getText().toString());
//
//
//                    et_quantity.setEnabled(true);
//                    Log.d("tag20", "selectedProductIds from not isChecked: " + selectedProductIds);
//                }
//
////                }
//
//
//            }
//        });

        linear_add_to_cart.setOnClickListener(view -> {
            linear_add_to_cart.setBackground(context.getResources().getDrawable(R.drawable.rounded_corner22));
            tv_add_to_cart.setTextColor(context.getColor(R.color.white));
            tv_add_to_cart.setText("Added");


            String categoryName = productList.getProductName();
            String subCategoryName = "";
            String subCategoryId = "";
            String imgLink = "";
            String sub_category_price = productList.getProductPrice();
            String bag_size = productList.getProduct_pack_size();
            String directRecovery = productList.getDirect_recovery().toString();
            String quantity = "1";

            addItemToCart(categoryName, subCategoryName, subCategoryId, imgLink, sub_category_price, bag_size, quantity, directRecovery);

            int cartItemNumber = db.getCartItemsCount();
            MainActivity.getCartItemsNumber(cartItemNumber);
//            SubItemActivity.getCartItemsNumber(cartItemNumber);
//            ItemDetailActivity.getCartItemsNumber(cartItemNumber);

        });


    }

    private void addItemToCart(String category_name, String sub_category_name, String sub_category_id, String img_link, String sub_category_price,
                               String bag_size, String quantity, String directRecovery) {

        long id = db.insertCartModel(category_name, sub_category_name, sub_category_id, img_link, sub_category_price, bag_size, quantity, directRecovery);

        CartModel n = db.getCartModel(id);

        if (n != null) {
            // adding new note to array list at 0 position
//            notesList.add(0, n);

        }
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtSlNo;
        TextView tv_product_name;
        TextView tv_product_code;
        TextView tv_bag_size;
        TextView product_details;
        TextView productSellPrice;
        TextView tv_product_price;
        TextView quantityTextView;
        TextView tv_decrement;
        TextView tv_increment;
        EditText et1;
        EditText et_quantity;
        Button btn_buy_product;
        Button btn_add_to_cart;
        ImageView imageView;
        CardView cardView;
        CheckBox check;
        CardView card_view;

        LinearLayout linear_add_to_cart;
        TextView tv_add_to_cart;

        public MyViewHolder(View itemView) {
            super(itemView);
//            txtSlNo = itemView.findViewById(R.id.txt_sl);
            tv_product_name = itemView.findViewById(R.id.tv_product_name);
//            tv_product_price = itemView.findViewById(R.id.tv_product_price);
//            tv_product_code = itemView.findViewById(R.id.tv_product_code);
//            tv_bag_size = itemView.findViewById(R.id.tv_bag_size);
//            imageView = itemView.findViewById(R.id.iv_1);
            tv_add_to_cart = itemView.findViewById(R.id.tv_add_to_cart);
            linear_add_to_cart = itemView.findViewById(R.id.linear_add_to_cart);


//            product_details.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent  intent = new Intent(context, AreaSelectActivity.class);
//                    context.startActivity(intent);
//
//                }
//            });

        }
    }


    public ArrayList<String> getSelectedIds() {
        Log.d("tag20", "selectedProductIds from getSelectedIds() method: " + selectedProductIds);
        return selectedProductIds;
    }

    public ArrayList<String> getSelectedProductQuantities() {
        Log.d("tag20", "selectedProductQuantities from getSelectedProductQuantities() method: " + selectedProductQuantities);
        return selectedProductQuantities;
    }

    public ArrayList<String> getSelectedProductBagSizes() {
        Log.d("tag20", "selectedProductBagSizes from getSelectedProductQuantities() method: " + selectedProductQuantities);
        return selectedProductBagSizes;
    }

    public ArrayList<String> getSelectedProductDirectRecoveries() {
        Log.d("tag20", "selectedProductDirectRecoveries from getSelectedProductQuantities() method: " + selectedProductDirectRecoveries);
        return selectedProductDirectRecoveries;
    }

    public ArrayList<String> getSelectedProductNames() {
        Log.d("tag20", "selectedProductNames from getSelectedProductNames() method: " + selectedProductNames);
        return selectedProductNames;
    }

    public ArrayList<String> selectedProductPrices() {
        Log.d("tag20", "selectedProductNames from getSelectedProductNames() method: " + selectedProductPrices);
        return selectedProductPrices;
    }

   public ArrayList<String> selectedProductAmounts() {
        Log.d("tag20", "selectedProductAmounts from getSelectedProductNames() method: " + selectedProductAmounts);
        return selectedProductAmounts;
    }

    public void showProgress() {
        dialog = new ProgressDialog(context);
        dialog.setMessage("please wait.");
        dialog.show();
    }

    public void hideProgress() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private ProgressDialog dialog;


    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public void filter(CharSequence charText) {

        List<ProductList.Data> filteredList = new ArrayList<>();
        String charString = charText.toString();

        if (charString.length() == 0) {
////         productListFiltered = dataSet;
//         filteredList.addAll(dataSet);
            Log.i("tag", String.valueOf("1:  " + charString.length()) + dataSet);


        }

        if (charString.isEmpty() || charString.equalsIgnoreCase("")) {
            productListFiltered = dataSet;
        } else {
//         List<ProductList.Data> filteredList = new ArrayList<>();
            for (ProductList.Data row : dataSet) {
                if (
                        row.getProductName().contains(charString)
                                ||
                                row.getProduct_code().toLowerCase().contains(charString.toLowerCase())
//                             ||
//                             row.getMobileNumber().contains(charText) ||
//                             row.getOrderDate().toLowerCase().contains(charString.toLowerCase()) ||
//                             row.getTakaAmount().toLowerCase().contains(charString.toLowerCase()) ||
//                             row.getPaymentStatus().toLowerCase().contains(charString.toLowerCase())
                ) {
                    filteredList.add(row);
                }
            }

            Log.i("tag", "2:  " + String.valueOf(charString.length()) + filteredList);

            productListFiltered = filteredList;
        }

//     Filter.FilterResults filterResults = new Filter.FilterResults();
//     filterResults.values = productListFiltered;
        this.setData(productListFiltered);
        this.notifyDataSetChanged();
    }


}
