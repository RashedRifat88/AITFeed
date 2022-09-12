package com.egsystembd.aitfeed.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductList {


    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public class Data {

        @SerializedName("product_id")
        @Expose
        private String productId;
        @SerializedName("product_name")
        @Expose
        private String productName;
        @SerializedName("product_detail")
        @Expose
        private String productDetail;
        @SerializedName("product_price")
        @Expose
        private String productPrice;
        @SerializedName("product_sale_price")
        @Expose
        private String productSalePrice;
        @SerializedName("status")
        @Expose
        private String status;

        @SerializedName("product_code")
        @Expose
        private String product_code;

        @SerializedName("product_pack_size")
        @Expose
        private String product_pack_size;

        @SerializedName("product_category_id")
        @Expose
        private String product_category_id;
//        @SerializedName("created_at")
//        @Expose
//        private String createdAt;
//        @SerializedName("updated_at")
//        @Expose
//        private String updatedAt;
//        @SerializedName("created_by")
//        @Expose
//        private String createdBy;

//        @SerializedName("updated_by")
//        @Expose
//        private String updatedBy;

        @SerializedName("product_image")
        @Expose
        private String product_image;

        @SerializedName("product_net_pice")
        @Expose
        private String product_net_pice;

        @SerializedName("product_discount")
        @Expose
        private String product_discount;

        @SerializedName("direct_recovery")
        @Expose
        private String direct_recovery;

//        @SerializedName("message")
//        @Expose
//        private String message;

//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }

        public String getDirect_recovery() {
            return direct_recovery;
        }

        public void setDirect_recovery(String direct_recovery) {
            this.direct_recovery = direct_recovery;
        }

        public String getProduct_net_pice() {
            return product_net_pice;
        }

        public void setProduct_net_pice(String product_net_pice) {
            this.product_net_pice = product_net_pice;
        }

        public String getProduct_discount() {
            return product_discount;
        }

        public void setProduct_discount(String product_discount) {
            this.product_discount = product_discount;
        }

        public String getProduct_category_id() {
            return product_category_id;
        }

        public void setProduct_category_id(String product_category_id) {
            this.product_category_id = product_category_id;
        }

        public String getProduct_code() {
            return product_code;
        }

        public String getProduct_pack_size() {
            return product_pack_size;
        }

        public void setProduct_pack_size(String product_pack_size) {
            this.product_pack_size = product_pack_size;
        }

        public void setProduct_code(String product_code) {
            this.product_code = product_code;
        }

        public String getProduct_image() {
            return product_image;
        }

        public void setProduct_image(String product_image) {
            this.product_image = product_image;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductDetail() {
            return productDetail;
        }

        public void setProductDetail(String productDetail) {
            this.productDetail = productDetail;
        }

        public String getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(String productPrice) {
            this.productPrice = productPrice;
        }

        public String getProductSalePrice() {
            return productSalePrice;
        }

        public void setProductSalePrice(String productSalePrice) {
            this.productSalePrice = productSalePrice;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

//        public String getCreatedAt() {
//            return createdAt;
//        }
//
//        public void setCreatedAt(String createdAt) {
//            this.createdAt = createdAt;
//        }
//
//        public String getUpdatedAt() {
//            return updatedAt;
//        }
//
//        public void setUpdatedAt(String updatedAt) {
//            this.updatedAt = updatedAt;
//        }
//
//        public String getCreatedBy() {
//            return createdBy;
//        }
//
//        public void setCreatedBy(String createdBy) {
//            this.createdBy = createdBy;
//        }

//        public String getUpdatedBy() {
//            return updatedBy;
//        }
//
//        public void setUpdatedBy(String updatedBy) {
//            this.updatedBy = updatedBy;
//        }


    }


}
