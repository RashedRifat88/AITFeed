package com.egsystembd.aitfeed.data;


import static com.egsystembd.aitfeed.cart.CartModel.TABLE_NAME;
import static com.egsystembd.aitfeed.cart.CartModel.TABLE_NAME2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.egsystembd.aitfeed.cart.CartModel;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "aitfeed.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        context.deleteDatabase(DATABASE_NAME);
//        context.deleteDatabase(DATABASE_NAME2);
    }


      public void deleteDatabase(Context context) {
          context.deleteDatabase(DATABASE_NAME);
    }



    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create cartModels table
        db.execSQL(CartModel.CREATE_TABLE);

        db.execSQL(CartModel.CREATE_TABLE2);

        db.execSQL("CREATE TABLE IF NOT EXISTS " + "tbl_catagory" + " ( "
                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "catagory_name" + " TEXT,"
                + "catagory_id" + " TEXT,"
                + "catagory_img_link" + " TEXT "
                + ");");

//        db.execSQL("CREATE TABLE IF NOT EXISTS " + "tbl_client_address" + " ( "
//                + "id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + "address_name" + " TEXT"
//                + ");");

//
//        public static final String CREATE_TABLE =
//                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
//                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                        + CATEGORY_NAME + " TEXT,"
//                        + SUB_CATEGORY_NAME + " TEXT,"
//                        + SUB_CATEGORY_ID + " TEXT,"
//                        + IMG_LINK + " TEXT "
//                        + ");";

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + "tbl_catagory");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        // Create tables again
        onCreate(db);
    }


    public long insertCartModel(String category_name, String sub_category_name, String sub_category_id, String img_link, String sub_category_price,
                                String bag_size, String quantity, String direct_recovery) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // `id` will be inserted automatically, no need to add id
        values.put(CartModel.CATEGORY_NAME, category_name);
        values.put(CartModel.SUB_CATEGORY_NAME, sub_category_name);
        values.put(CartModel.SUB_CATEGORY_ID, sub_category_id);
        values.put(CartModel.IMG_LINK, img_link);
        values.put(CartModel.SUB_CATEGORY_PRICE, sub_category_price);
        values.put(CartModel.SUB_CATEGORY_TOTAL_PRICE, sub_category_price);
        values.put(CartModel.BAG_SIZE, bag_size);
        values.put(CartModel.QUANTITY, quantity);
        values.put(CartModel.DIRECT_RECOVERY, direct_recovery);
        // insert row
        long id = db.insert(TABLE_NAME, null, values);
        // close db connection
        db.close();

        Log.d("id555", "id: table insert called" + id);

        // return newly inserted row id
        return id;
    }

    public long insertIntoClientAddress(String address_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("address_name", address_name);
        // insert row
        long id = db.insert(TABLE_NAME2, null, values);
        // close db connection
        db.close();
        Log.d("id555", "id: table insert called" + id);

        return id;
    }

    public CartModel getCartModel(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[]{CartModel.COLUMN_ID, CartModel.CATEGORY_NAME, CartModel.SUB_CATEGORY_NAME,
                        CartModel.SUB_CATEGORY_ID, CartModel.SUB_CATEGORY_PRICE, CartModel.SUB_CATEGORY_TOTAL_PRICE,
                        CartModel.BAG_SIZE, CartModel.QUANTITY, CartModel.DIRECT_RECOVERY, CartModel.IMG_LINK},
                CartModel.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare cartModel object
        @SuppressLint("Range") CartModel cartModel = new CartModel(
                cursor.getInt(cursor.getColumnIndex(CartModel.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(CartModel.CATEGORY_NAME)),
                cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_NAME)),
                cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_ID)),
                cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_PRICE)),
                cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_TOTAL_PRICE)),
                cursor.getString(cursor.getColumnIndex(CartModel.BAG_SIZE)),
                cursor.getString(cursor.getColumnIndex(CartModel.QUANTITY)),
                cursor.getString(cursor.getColumnIndex(CartModel.DIRECT_RECOVERY)),
                cursor.getString(cursor.getColumnIndex(CartModel.IMG_LINK)));

        // close the db connection
        cursor.close();

        return cartModel;
    }


//    public CartModel getCartModelWithSubCategoryId(String id) {
//        // get readable database as we are not inserting anything
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_NAME,
//                new String[]{CartModel.COLUMN_ID, CartModel.CATEGORY_NAME, CartModel.SUB_CATEGORY_NAME,
//                        CartModel.SUB_CATEGORY_ID, CartModel.SUB_CATEGORY_PRICE, CartModel.SUB_CATEGORY_TOTAL_PRICE, CartModel.QUANTITY, CartModel.IMG_LINK},
//                CartModel.SUB_CATEGORY_ID + "=?",
//                new String[]{String.valueOf(id)}, null, null, null, null);
//
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        // prepare cartModel object
//        CartModel cartModel = new CartModel(
//                cursor.getInt(cursor.getColumnIndex(CartModel.COLUMN_ID)),
//                cursor.getString(cursor.getColumnIndex(CartModel.CATEGORY_NAME)),
//                cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_NAME)),
//                cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_ID)),
//                cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_PRICE)),
//                cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_TOTAL_PRICE)),
//                cursor.getString(cursor.getColumnIndex(CartModel.QUANTITY)),
//                cursor.getString(cursor.getColumnIndex(CartModel.IMG_LINK)));
//
//        // close the db connection
//        cursor.close();
//
//        return cartModel;
//    }


    @SuppressLint("Range")
    public List<CartModel> getAllCartItems() {
        List<CartModel> cartItemsList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CartModel cartModel = new CartModel();
                cartModel.setId(cursor.getInt(cursor.getColumnIndex(CartModel.COLUMN_ID)));
                cartModel.setCategory_name(cursor.getString(cursor.getColumnIndex(CartModel.CATEGORY_NAME)));
                cartModel.setSub_category_name(cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_NAME)));
                cartModel.setSub_category_id(cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_ID)));
                cartModel.setSub_category_price(cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_PRICE)));
                cartModel.setSub_category_total_price(cursor.getString(cursor.getColumnIndex(CartModel.SUB_CATEGORY_TOTAL_PRICE)));
                cartModel.setBag_size(cursor.getString(cursor.getColumnIndex(CartModel.BAG_SIZE)));
                cartModel.setQuantity(cursor.getString(cursor.getColumnIndex(CartModel.QUANTITY)));
                cartModel.setQuantity(cursor.getString(cursor.getColumnIndex(CartModel.DIRECT_RECOVERY)));
                cartModel.setImg_link(cursor.getString(cursor.getColumnIndex(CartModel.IMG_LINK)));


                cartItemsList.add(cartModel);
            } while (cursor.moveToNext());
        }

        db.close();

        return cartItemsList;
    }


//    public List<String> getAllAddresses() {
//        List<String> addressList = new ArrayList<>();
//        String selectQuery = "SELECT  * FROM " + "tbl_client_address" + " ORDER BY id DESC";
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        // looping through all rows and adding to list
//        if (cursor.moveToFirst()) {
//            do {
//                String address = cursor.getString(cursor.getColumnIndex(CartModel.ADDRESS_NAME));
//                addressList.add(address);
//
//            } while (cursor.moveToNext());
//        }
//        db.close();
//
//        return addressList;
//    }


    public int getCartItemsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateCartModel(CartModel cartModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CartModel.CATEGORY_NAME, cartModel.getCategory_name());
        values.put(CartModel.SUB_CATEGORY_NAME, cartModel.getSub_category_id());
        values.put(CartModel.SUB_CATEGORY_ID, cartModel.getSub_category_id());
        values.put(CartModel.SUB_CATEGORY_PRICE, cartModel.getSub_category_price());
        values.put(CartModel.SUB_CATEGORY_TOTAL_PRICE, cartModel.getSub_category_total_price());
        values.put(CartModel.BAG_SIZE, cartModel.getBag_size());
        values.put(CartModel.QUANTITY, cartModel.getQuantity());
        values.put(CartModel.DIRECT_RECOVERY, cartModel.getDirect_recovery());
        values.put(CartModel.IMG_LINK, cartModel.getImg_link());


        // updating row
        return db.update(TABLE_NAME, values, CartModel.COLUMN_ID + " = ?",
                new String[]{String.valueOf(cartModel.getId())});
    }


        public int updateCartModel2(CartModel cartModel, String bag_size, String quantity, String sub_category_total_price) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CartModel.CATEGORY_NAME, cartModel.getCategory_name());
        values.put(CartModel.SUB_CATEGORY_NAME, cartModel.getSub_category_id());
        values.put(CartModel.SUB_CATEGORY_ID, cartModel.getSub_category_id());
        values.put(CartModel.SUB_CATEGORY_PRICE, cartModel.getSub_category_price());
        values.put(CartModel.SUB_CATEGORY_TOTAL_PRICE, sub_category_total_price);
        values.put(CartModel.BAG_SIZE, bag_size);
        values.put(CartModel.QUANTITY, quantity);
        values.put(CartModel.DIRECT_RECOVERY, cartModel.getDirect_recovery());
        values.put(CartModel.IMG_LINK, cartModel.getImg_link());


        // updating row
        return db.update(TABLE_NAME, values, CartModel.COLUMN_ID + " = ?",
                new String[]{String.valueOf(cartModel.getId())});
    }






    //    public void deleteCartItem(CartModel cartModel) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(CartModel.TABLE_NAME, CartModel.COLUMN_ID + " = ?",
//                new String[]{String.valueOf(cartModel.getId())});
//        db.close();
//    }


    public void deleteCartItem(CartModel cartModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, CartModel.SUB_CATEGORY_ID + " = ?",
                new String[]{String.valueOf(cartModel.getSub_category_id())});
        db.close();
    }

    public void deleteCartItem2(String sub_cat_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, CartModel.ID + " = ?",
                new String[]{String.valueOf(sub_cat_id)});
        db.close();
    }


    public void deleteAllRowsFromTAble(String table_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_name, "1", null); //count deleted rows
        db.close();
    }


}