package com.egsystembd.aitfeed.cart;

public class CartModel {
    public static final String TABLE_NAME = "cart_items";
    public static final String TABLE_NAME2 = "tbl_client_address";

    public static final String ID = "id";
    public static final String ADDRESS_NAME = "address_name";

    public static final String COLUMN_ID = "id";
    public static final String CATEGORY_NAME = "category_name";
    public static final String SUB_CATEGORY_NAME = "sub_category_name";
    public static final String SUB_CATEGORY_ID = "sub_category_id";
    public static final String SUB_CATEGORY_PRICE = "sub_category_price";
    public static final String SUB_CATEGORY_TOTAL_PRICE = "sub_category_total_price";
    public static final String BAG_SIZE = "bag_size";
    public static final String QUANTITY = "quantity";
    public static final String DIRECT_RECOVERY = "direct_recovery";
    public static final String IMG_LINK = "img_link";

    private int id;
    private String category_name;
    private String sub_category_name;
    private String sub_category_id;
    private String sub_category_price;
    private String sub_category_total_price;
    private String bag_size;
    private String quantity;
    private String direct_recovery;
    private String img_link;

    
    public static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + CATEGORY_NAME + " TEXT,"
                    + SUB_CATEGORY_NAME + " TEXT,"
                    + SUB_CATEGORY_ID + " TEXT,"
                    + SUB_CATEGORY_PRICE + " TEXT,"
                    + SUB_CATEGORY_TOTAL_PRICE + " TEXT,"
                    + BAG_SIZE + " TEXT,"
                    + QUANTITY + " TEXT,"
                    + DIRECT_RECOVERY + " TEXT,"
                    + IMG_LINK + " TEXT "
                    + ");";

    public static final String CREATE_TABLE2 =
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + " ( "
                    + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + ADDRESS_NAME + " TEXT "
                    + ");";

    public CartModel() {
    }


    public CartModel(int id, String category_name, String sub_category_name, String sub_category_id, String sub_category_price, String sub_category_total_price,
                     String bag_size, String quantity, String direct_recovery, String img_link) {
        this.id = id;
        this.category_name = category_name;
        this.sub_category_name = sub_category_name;
        this.sub_category_id = sub_category_id;
        this.sub_category_price = sub_category_price;
        this.sub_category_total_price = sub_category_total_price;
        this.bag_size = bag_size;
        this.quantity = quantity;
        this.direct_recovery = direct_recovery;
        this.img_link = img_link;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getSub_category_name() {
        return sub_category_name;
    }

    public void setSub_category_name(String sub_category_name) {
        this.sub_category_name = sub_category_name;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(String sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }

    public String getSub_category_price() {
        return sub_category_price;
    }

    public void setSub_category_price(String sub_category_price) {
        this.sub_category_price = sub_category_price;
    }


    public String getSub_category_total_price() {
        return sub_category_total_price;
    }

    public void setSub_category_total_price(String sub_category_total_price) {
        this.sub_category_total_price = sub_category_total_price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDirect_recovery() {
        return direct_recovery;
    }

    public void setDirect_recovery(String direct_recovery) {
        this.direct_recovery = direct_recovery;
    }

    public String getBag_size() {
        return bag_size;
    }

    public void setBag_size(String bag_size) {
        this.bag_size = bag_size;
    }
}