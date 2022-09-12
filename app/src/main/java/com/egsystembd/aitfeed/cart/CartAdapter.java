package com.egsystembd.aitfeed.cart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.egsystembd.aitfeed.R;
import com.egsystembd.aitfeed.data.DatabaseHelper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.SubItemViewHolder> {
    CartAdapter adapter;
    private List<CartModel> dataSet = new ArrayList<>();
    private List<CartModel> dataSet2;
    Context context;
    double sumOfPrice1 = 0.0;
    double sumOfPrice2 = 0.0;
    double sumOfPrice3 = 0.0;


    Cursor dataCursor;
    int id;

    private List<CartModel> mProductList;
    private LayoutInflater mInflater;
    private boolean mShowCheckbox;
    CustomItemClickListener listener;

    List<CartModel> cart;
    HashMap<Object, String> cartWithTitleName = new HashMap<Object, String>();

    String categoryName = "";

    String title;
    String category_id;

    private DatabaseHelper db;
    private static double dTotalPrice1 = 0.0;
    private static double dTotalPrice2 = 0.0;
    private static double dTotalPrice3 = 0.0;
    private List<CartModel> mCartList;


    public CartAdapter() {
    }

    public CartAdapter(Context context) {
        this.context = context;
        this.adapter = this;

        db = new DatabaseHelper(context);

    }

    public CartAdapter(List<CartModel> list, LayoutInflater inflater, boolean showCheckbox, Context context) {
        mProductList = list;
        mInflater = inflater;
        mShowCheckbox = showCheckbox;
        this.context = context;
    }

    public CartAdapter(List<CartModel> list, Context context, CustomItemClickListener listener) {

        db = new DatabaseHelper(context);


        mProductList = list;
        Log.d("tagResponse", " list: " + list);
        this.context = context;
        this.listener = listener;

//        this.cart = ShoppingCartHelper.getCart();
        this.adapter = this; //This is an important line, you need this line to keep track the adapter variable
    }


    public CartAdapter(Context context, Cursor cursor) {
        dataCursor = cursor;
        this.context = context;
        Log.d("tag1wwwww", " adapter: ");
    }

    public void setTitle(String title, String categoryId) {
//        this.categoryName = categoryName;
        this.title = title;
        this.category_id = categoryId;
    }

    public void setData(List<CartModel> dataSet) {
        this.dataSet = dataSet;
    }

    public void setData2(List<CartModel> dataSet2) {
        this.dataSet2 = dataSet2;
        Log.d("tagResponse", " dataSet2: " + dataSet2);

        mCartList = db.getAllCartItems();

        for (CartModel m : mCartList) {
            sumOfPrice1 = sumOfPrice1 + Double.parseDouble(m.getSub_category_price()) * Double.parseDouble(m.getQuantity());
        }

        dTotalPrice1 = sumOfPrice1;
//        CartActivity.setTotalPrice(dTotalPrice1);
        Log.d("tagResponse", " dTotalPrice1 instanceof setdata 2: " + dTotalPrice1);

        Log.d("tagResponse", " dTotalPrice1: " + dTotalPrice1);
    }


    @Override
    public int getItemCount() {
//        return mProductList.size();
        return dataSet2.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public SubItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row_cart_item, parent, false);
        SubItemViewHolder myViewHolder = new SubItemViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listener.onItemClick(v, myViewHolder.getPosition());
            }
        });
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(final SubItemViewHolder holder, int position) {
        TextView txtSlNo = holder.txtSlNo;
        TextView tv_sub_item_name = holder.tv_sub_item_name;
        TextView tv_bag_size = holder.tv_bag_size;
        TextView tv_sub_item_price = holder.tv_sub_item_price;
        TextView tv_quantity = holder.tv_quantity;
        TextView tv_remove_item = holder.tv_remove_item;
        TextView tv_sub_item_extra = holder.tv_sub_item_extra;
        ImageView imageView = holder.imageView;
        ImageView iv_remove_item = holder.iv_remove_item;
        ImageView iv_plus = holder.iv_plus;
        ImageView iv_minus = holder.iv_minus;


//        String dealerData2 = dataSet2.get( position );

//        Product curProduct = mProductList.get(position);
        CartModel curProduct = dataSet2.get(position);
//        CartModel curProduct = mProductList.get(position);

        CartActivity.setTotalPrice(dTotalPrice1);
        Log.d("tagResponse", " dTotalPrice1 in viewholder: " + dTotalPrice1);

        Log.d("tag333", " dataSet2...: " + dataSet2);
        Log.d("tag333", " mProductList...: " + mProductList);

//        String subCategoryName = curProduct.getName();
//        String subCategoryId = curProduct.getId().toString();
//        String imgLink = curProduct.getPhoto();
        tv_sub_item_name.setText(curProduct.getCategory_name());
        tv_bag_size.setText("Bag Size: " + curProduct.getBag_size().toString());
        tv_quantity.setText(curProduct.getQuantity());

        double quantity_item_d = Double.parseDouble(curProduct.getQuantity());
        double price_item_d = Double.parseDouble(curProduct.getSub_category_price());
        double price_item_total_d = quantity_item_d * price_item_d;

        DecimalFormat df = new DecimalFormat("####0.00");

        tv_sub_item_price.setText("Price: TK " + df.format(price_item_total_d));
//        tv_sub_item_extra.setText(curProduct.getCategory_name());
//        int item_row_id= curProduct.getId();
        String sub_item_id = curProduct.getSub_category_id();
        int item_row_id = curProduct.getId();
        Log.d("tag55555", "item_row_id: " + item_row_id);
        Log.d("tag55555", "curProduct.getSub_category_price(): " + curProduct.getSub_category_price());
        Log.d("tag55555", "getQuantity(): " + curProduct.getQuantity());

//
        String price = curProduct.getSub_category_price();
        String item_total_price = curProduct.getSub_category_total_price();
        double iPrice = Double.parseDouble(price);

//        sumOfPrice = sumOfPrice + iPrice;
//        CartActivity.setTotalPrice(sumOfPrice);


        Log.d("tag55555", "sumOfPrice: " + sumOfPrice1);


//        Glide.with(context)
//                .load(curProduct.getImg_link())
//                .into(imageView);


        double cost = 0;
        cost = Double.parseDouble(price);
        double[] finalCost = {Double.parseDouble(item_total_price)};

        double[] bag_size = {Double.parseDouble(curProduct.getBag_size())};
        int[] quantity = {Integer.parseInt(curProduct.getQuantity())};

        double cost1 = cost;
        iv_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finalCost[0] = finalCost[0] + cost1;
                quantity[0]++;

                tv_sub_item_price.setText("Price: TK " + df.format(finalCost[0]));
                tv_quantity.setText(String.valueOf(quantity[0]));


                updateItemInCart(item_row_id, String.valueOf(bag_size[0]), String.valueOf(quantity[0]), String.valueOf(finalCost[0]));

                mCartList = db.getAllCartItems();


                sumOfPrice2 = 0;

                Log.d("tag55555", "dTotalPrice2 prev: " + dTotalPrice2);
                for (CartModel m : mCartList) {
                    sumOfPrice2 = sumOfPrice2 + Double.parseDouble(m.getSub_category_total_price());
                    Log.d("tag55555", "sumOfPrice2: " + sumOfPrice2);
                }

                Log.d("tag55555", "dTotalPrice2: " + dTotalPrice2);
                CartActivity.setTotalPrice(sumOfPrice2);

            }
        });


        double cost2 = cost;
        iv_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (quantity[0] > 1) {
                    finalCost[0] = finalCost[0] - cost2;
                    quantity[0]--;

                    tv_sub_item_price.setText("Price: TK " + df.format(finalCost[0]));
                    tv_quantity.setText(String.valueOf(quantity[0]));

                    updateItemInCart(item_row_id, String.valueOf(bag_size[0]), String.valueOf(quantity[0]), String.valueOf(finalCost[0]));

                    mCartList = db.getAllCartItems();


                    sumOfPrice2 = 0;
                    for (CartModel m : mCartList) {
//                        sumOfPrice3 = sumOfPrice3 + Double.parseDouble(m.getSub_category_price()) * Double.parseDouble(m.getQuantity());
                        sumOfPrice2 = sumOfPrice2 + Double.parseDouble(m.getSub_category_total_price());
                    }

                    CartActivity.setTotalPrice(sumOfPrice2);

                    callEdittext();
                }

            }
        });


        iv_remove_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteItemFromCart2(String.valueOf(item_row_id));

//                ShoppingCartActivity.refreshAdapter();
//                adapter.notifyDataSetChanged();

//                Intent viewShoppingCartIntent = new Intent(context, CartActivity.class);
//                viewShoppingCartIntent.putExtra("TITLE_NAME", title);
//                viewShoppingCartIntent.putExtra("CATEGORY_ID", category_id);
//                context.startActivity(viewShoppingCartIntent);
//                ((Activity)context).finish();

            }
        });


    }

    private void callEdittext() {

    }


    /**
     * Inserting new note in db
     * and refreshing the list
     */
    private void addItemToCart(String category_name, String sub_category_name, String sub_category_id, String img_link, String sub_category_price, String bag_size, String quantity) {
        long id = db.insertCartModel(category_name, sub_category_name, sub_category_id, img_link, sub_category_price, bag_size, quantity);

        CartModel n = db.getCartModel(id);

        if (n != null) {
            // adding new note to array list at 0 position
//            notesList.add(0, n);

        }
    }


    private void updateItemInCart(int id, String bag_size, String quantity, String sub_category_total_price) {

        long id1 = id;
//        long id1 = new Long(id);
        Log.d("tag55555", "id1: " + id1);
        Log.d("tag55555", "id: " + id);

        CartModel model = db.getCartModel(id1);
        Log.d("tag55555", "model: " + model);
        db.updateCartModel2(model, bag_size, quantity, sub_category_total_price);


    }


    private void deleteItemFromCart(int id) {

        long id1 = id;
//        long id1 = new Long(id);
        Log.d("tag55555", "id1: " + id1);
        Log.d("tag55555", "id: " + id);

//        CartModel model = db.getCartModel(id1);
//        Log.d("tag55555", "model: " + model);
//        db.deleteCartItem(model);

    }


    private void deleteItemFromCart2(String id) {

        Log.d("tag55555", "id: " + id);
        db.deleteCartItem2(id);

        Intent viewShoppingCartIntent = new Intent(context, CartActivity.class);
        context.startActivity(viewShoppingCartIntent);
        ((Activity) context).finish();

    }


    class SubItemViewHolder extends RecyclerView.ViewHolder {

        TextView txtSlNo;
        TextView tv_sub_item_name;
        TextView tv_bag_size;
        TextView tv_remove_item;
        TextView tv_sub_item_extra;
        TextView tv_sub_item_price;
        TextView tv_quantity;

        ImageView imageView;
        ImageView iv_remove_item;
        ImageView iv_plus;
        ImageView iv_minus;

        public SubItemViewHolder(View itemView) {
            super(itemView);
            tv_sub_item_name = itemView.findViewById(R.id.tv_sub_item_name);
            tv_bag_size = itemView.findViewById(R.id.tv_bag_size);
//            tv_remove_item = itemView.findViewById(R.id.tv_remove_item);
            tv_sub_item_price = itemView.findViewById(R.id.tv_sub_item_price);
            tv_quantity = itemView.findViewById(R.id.tv_quantity);
//            tv_remove_item = itemView.findViewById(R.id.tv_remove_item);
//            tv_sub_item_extra = itemView.findViewById(R.id.tv_sub_item_extra);
            imageView = itemView.findViewById(R.id.imageView);
            iv_remove_item = itemView.findViewById(R.id.iv_remove_item);
            iv_plus = itemView.findViewById(R.id.iv_plus);
            iv_minus = itemView.findViewById(R.id.iv_minus);

        }
    }


}

